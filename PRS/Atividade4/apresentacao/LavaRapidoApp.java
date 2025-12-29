package org.example;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class Relatorio {
    int id;
    String tipo;
    List<Fatura> faturas = new ArrayList<>();
    List<Servico> servicos = new ArrayList<>();
    List<Agendamento> agendamentos = new ArrayList<>();
    public float calcularFaturamentoDia() {
        Calendar hoje = Calendar.getInstance();
        float total = 0f;
        for (Fatura f : faturas) {
            Calendar dt = Calendar.getInstance();
            dt.setTime(f.dataEmissao);
            boolean mesmoDia = dt.get(Calendar.YEAR) == hoje.get(Calendar.YEAR) &&
                    dt.get(Calendar.DAY_OF_YEAR) == hoje.get(Calendar.DAY_OF_YEAR);
            if (mesmoDia) total += f.valorFinal;
        }
        return total;
    }
    public float calcularFaturamentoSemana() {
        Calendar hoje = Calendar.getInstance();
        int semanaAno = hoje.get(Calendar.WEEK_OF_YEAR);
        int ano = hoje.get(Calendar.YEAR);
        float total = 0f;
        for (Fatura f : faturas) {
            Calendar dt = Calendar.getInstance();
            dt.setTime(f.dataEmissao);
            int semanaF = dt.get(Calendar.WEEK_OF_YEAR);
            int anoF = dt.get(Calendar.YEAR);
            if (anoF == ano && semanaF == semanaAno) total += f.valorFinal;
        }
        return total;
    }
    public int contarServicosConcluidos() {
        return faturas.size();
    }
}

class Proprietario {
    int id;
    String nome;
    String contato;
    List<Preco> precos = new ArrayList<>();
}

class Cliente {
    int id;
    String nome;
    String contato;
    List<Veiculo> veiculos = new ArrayList<>();
    List<Fatura> historicoFaturas = new ArrayList<>();
    @Override
    public String toString() {
        return nome;
    }
}

class Veiculo {
    int id;
    int clienteId;
    String nome;
    int tipo; // 1=Pequeno,2=Médio,3=Grande
    @Override
    public String toString() {
        return nome + " - " + tipoVeiculoDescricao(tipo);
    }
    private String tipoVeiculoDescricao(int tipo) {
        switch (tipo) {
            case 1: return "Pequeno";
            case 2: return "Médio";
            case 3: return "Grande";
            default: return "Desconhecido";
        }
    }
}

class Preco {
    int id;
    int tipoVeiculo;
    int tipoServico;
    float valor;
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String tipoV = tipoVeiculoDescricao(tipoVeiculo);
        return String.format("%s - Serviço %d - %s", tipoV, tipoServico, nf.format(valor));
    }
    private String tipoVeiculoDescricao(int tipo) {
        switch (tipo) {
            case 1: return "Pequeno";
            case 2: return "Médio";
            case 3: return "Grande";
            default: return "Desconhecido";
        }
    }
}

class Servico {
    int id;
    String nome;
    int tipo;
    @Override
    public String toString() { return nome; }
}

class Agendamento {
    int id;
    int clienteId;
    int veiculoId;
    int servicoId;
    String status;
    public float calcularPreco(List<Preco> precos, int tipoVeiculo) {
        for (Preco p : precos) {
            if (p.tipoVeiculo == tipoVeiculo && p.tipoServico == this.servicoId) {
                return p.valor;
            }
        }
        return 0f;
    }
    @Override
    public String toString() {
        return "ID:" + id + " - Status:" + status;
    }
}

class Fatura {
    int id;
    int agendamentoId;
    float valorFinal;
    Date dataEmissao;
}

public class LavaRapidoApp extends JFrame {

    // Dados
    private Relatorio relatorio;
    private Proprietario proprietario = new Proprietario();

    private List<Cliente> clientes;
    private List<Veiculo> veiculos;
    private List<Servico> servicos;
    private List<Preco> precos;
    private List<Agendamento> agendamentos;
    private List<Fatura> faturas;

    // Layout principal e controle
    private JPanel mainPanel;
    private CardLayout mainCardLayout;

    // Labels Dashboard para atualizar valores
    private JLabel faturamentoDiaLabel, faturamentoSemanaLabel, servicosConcluidosLabel;
    private JPanel filaCardsContainer;

    // Agendamentos
    private DefaultListModel<Agendamento> agendamentoListModel;
    private JList<Agendamento> agendamentoJList;
    private JComboBox<Cliente> clienteComboBox;
    private JComboBox<Veiculo> veiculoComboBox;
    private JComboBox<Servico> servicoComboBox;
    private JComboBox<String> statusComboBox;

    // Clientes
    private DefaultListModel<Cliente> clienteListModel;
    private JList<Cliente> clienteJList;
    private JTextField campoNomeCliente, campoContatoCliente;
    private DefaultListModel<Veiculo> veiculoClienteListModel;
    private JList<Veiculo> veiculoClienteJList;
    private JTextField campoNomeVeiculo;
    private JComboBox<String> campoTipoVeiculo;
    private JButton btnAddVeiculo;
    private Cliente clienteSelecionado = null;

    // Configurações
    private JTextField campoNomeProprietario;
    private JTextField campoContatoProprietario;
    private DefaultListModel<Preco> precoListModel;
    private JList<Preco> precoJList;
    private JComboBox<String> precoTipoVeiculoCombo;
    private JComboBox<String> precoTipoServicoCombo;
    private JTextField precoValorField;
    private JButton btnSalvarPreco, btnExcluirPreco;
    private Preco precoSelecionado = null;

    // Botão Salvar Cliente (declarar para remover erro)
    private JButton btnSalvarCliente;

    public LavaRapidoApp() {
        inicializarDados();
        inicializarInterface();
    }

    private void inicializarDados() {
        clientes = new ArrayList<>();
        veiculos = new ArrayList<>();
        precos = new ArrayList<>();
        servicos = new ArrayList<>();
        agendamentos = new ArrayList<>();
        faturas = new ArrayList<>();
        proprietario.precos = new ArrayList<>();

        // Serviços
        Servico s1 = new Servico(); s1.id = 1; s1.nome = "Completa"; s1.tipo = 1;
        Servico s2 = new Servico(); s2.id = 2; s2.nome = "Externa"; s2.tipo = 2;
        Servico s3 = new Servico(); s3.id = 3; s3.nome = "Completa + Cera"; s3.tipo = 3;
        servicos.addAll(Arrays.asList(s1, s2, s3));

        // Preços iniciais no proprietário e global
        Preco p1 = new Preco(); p1.id=1; p1.tipoVeiculo=1; p1.tipoServico=2; p1.valor=70f;
        Preco p2 = new Preco(); p2.id=2; p2.tipoVeiculo=2; p2.tipoServico=1; p2.valor=100f;
        Preco p3 = new Preco(); p3.id=3; p3.tipoVeiculo=3; p3.tipoServico=3; p3.valor=150f;
        precos.addAll(Arrays.asList(p1,p2,p3));
        proprietario.precos.addAll(precos);

        // Clientes e veículos
        Cliente c1 = new Cliente(); c1.id=1; c1.nome="João Silva"; c1.contato="1234-5678";
        Veiculo v1 = new Veiculo(); v1.id=1; v1.clienteId=1; v1.nome="Gol"; v1.tipo=2;
        c1.veiculos.add(v1); veiculos.add(v1);

        Cliente c2 = new Cliente(); c2.id=2; c2.nome="Maria Santos"; c2.contato="4321-8765";
        Veiculo v2 = new Veiculo(); v2.id=2; v2.clienteId=2; v2.nome="Ford Ka"; v2.tipo=1;
        c2.veiculos.add(v2); veiculos.add(v2);

        Cliente c3 = new Cliente(); c3.id=3; c3.nome="Pedro Oliveira"; c3.contato="5678-4321";
        Veiculo v3 = new Veiculo(); v3.id=3; v3.clienteId=3; v3.nome="Hilux"; v3.tipo=3;
        c3.veiculos.add(v3); veiculos.add(v3);

        clientes.addAll(Arrays.asList(c1,c2,c3));

        // Agendamentos/faturas
        Agendamento a1 = new Agendamento(); a1.id=1; a1.clienteId=1; a1.veiculoId=1; a1.servicoId=1; a1.status="Na Fila";
        Agendamento a2 = new Agendamento(); a2.id=2; a2.clienteId=2; a2.veiculoId=2; a2.servicoId=2; a2.status="Em Lavagem";
        Agendamento a3 = new Agendamento(); a3.id=3; a3.clienteId=3; a3.veiculoId=3; a3.servicoId=3; a3.status="Finalizando";
        agendamentos.addAll(Arrays.asList(a1,a2,a3));

        Fatura f1 = new Fatura(); f1.id=1; f1.agendamentoId=1; f1.valorFinal=calcularPrecoAgendamento(a1); f1.dataEmissao = new Date();
        Fatura f2 = new Fatura(); f2.id=2; f2.agendamentoId=2; f2.valorFinal=calcularPrecoAgendamento(a2); f2.dataEmissao = new Date();
        Fatura f3 = new Fatura(); f3.id=3; f3.agendamentoId=3; f3.valorFinal=calcularPrecoAgendamento(a3); f3.dataEmissao = new Date();
        faturas.addAll(Arrays.asList(f1,f2,f3));
        c1.historicoFaturas.add(f1); c2.historicoFaturas.add(f2); c3.historicoFaturas.add(f3);

        relatorio = new Relatorio();
        relatorio.faturas=faturas;
        relatorio.servicos=servicos;
        relatorio.agendamentos=agendamentos;
    }

    private float calcularPrecoAgendamento(Agendamento a) {
        Veiculo v = veiculos.stream().filter(vei->vei.id==a.veiculoId).findFirst().orElse(null);
        if(v==null) return 0f;
        for(Preco p : proprietario.precos) {
            if(p.tipoVeiculo == v.tipo && p.tipoServico == a.servicoId) {
                return p.valor;
            }
        }
        return 0f;
    }

    private void inicializarInterface() {
        setTitle("LavaRápido Pro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050,720);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel sideMenu = criarMenuLateral();
        getContentPane().add(sideMenu, BorderLayout.WEST);

        mainCardLayout = new CardLayout();
        mainPanel = new JPanel(mainCardLayout);
        mainPanel.setBorder(new EmptyBorder(15,15,15,15));

        mainPanel.add(criarDashboardPanel(), "Dashboard");
        mainPanel.add(criarAgendamentoPanel(), "Agendamentos");
        mainPanel.add(criarClientePanel(), "Clientes");
        mainPanel.add(criarConfiguracoesPanel(), "Configurações");

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainCardLayout.show(mainPanel, "Dashboard");
    }

    private JPanel criarMenuLateral() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(180, 700));
        panel.setBackground(new Color(237,250,241));
        panel.setLayout(new BorderLayout());

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(panel.getBackground());
        logoPanel.setBorder(new EmptyBorder(20,20,20,20));
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        JLabel icone = new JLabel("\uD83D\uDE97 LavaRápido");
        icone.setFont(new Font("Segoe UI", Font.BOLD,22));
        icone.setForeground(new Color(27,127,48));
        logoPanel.add(icone);
        JLabel proLabel = new JLabel("Pro");
        proLabel.setFont(new Font("Segoe UI", Font.BOLD,18));
        proLabel.setForeground(new Color(27,127,48));
        logoPanel.add(proLabel);
        panel.add(logoPanel, BorderLayout.NORTH);

        JPanel menuButtonsPanel = new JPanel();
        menuButtonsPanel.setBackground(panel.getBackground());
        menuButtonsPanel.setLayout(new BoxLayout(menuButtonsPanel, BoxLayout.Y_AXIS));
        menuButtonsPanel.setBorder(new EmptyBorder(10,10,10,10));
        menuButtonsPanel.add(criarBotaoMenu("Dashboard", "\uD83D\uDCC8", true));
        menuButtonsPanel.add(criarBotaoMenu("Agendamentos", "\uD83D\uDCC5", false));
        menuButtonsPanel.add(criarBotaoMenu("Clientes", "\uD83D\uDC65", false));
        menuButtonsPanel.add(criarBotaoMenu("Configurações", "\u2699", false));
        panel.add(menuButtonsPanel, BorderLayout.CENTER);

        JPanel perfilPanel = new JPanel();
        perfilPanel.setBackground(panel.getBackground());
        perfilPanel.setLayout(new BoxLayout(perfilPanel, BoxLayout.Y_AXIS));
        perfilPanel.setBorder(new EmptyBorder(20,10,20,10));
        JLabel perfilAtualLabel = new JLabel("Perfil Atual:");
        perfilAtualLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        perfilAtualLabel.setForeground(Color.GRAY);
        JLabel perfilValorLabel = new JLabel("Proprietario");
        perfilValorLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        perfilValorLabel.setForeground(new Color(198,237,208));
        perfilValorLabel.setBorder(new EmptyBorder(5,5,5,5));
        perfilValorLabel.setOpaque(true);
        perfilValorLabel.setBackground(new Color(220,245,220));
        JButton trocarPerfilBtn = new JButton("⇄ Trocar Perfil");
        trocarPerfilBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        trocarPerfilBtn.setBackground(new Color(230,230,230));
        trocarPerfilBtn.setFocusPainted(false);
        trocarPerfilBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        trocarPerfilBtn.addActionListener(e -> JOptionPane.showMessageDialog(this,"Trocar Perfil ainda não implementado"));
        perfilPanel.add(Box.createVerticalGlue());
        perfilPanel.add(perfilAtualLabel);
        perfilPanel.add(perfilValorLabel);
        perfilPanel.add(Box.createVerticalStrut(10));
        perfilPanel.add(trocarPerfilBtn);
        panel.add(perfilPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JButton criarBotaoMenu(String nome, String iconUnicode, boolean selecionado) {
        JButton botao = new JButton(iconUnicode + "  " + nome);
        botao.setAlignmentX(Component.LEFT_ALIGNMENT);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botao.setOpaque(true);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if(selecionado) {
            botao.setBackground(new Color(198,237,208));
        } else {
            botao.setBackground(new Color(237,250,241));
            botao.addActionListener(e -> mainCardLayout.show(mainPanel,nome));
        }
        return botao;
    }

    private JPanel criarDashboardPanel() {
        JPanel painel = new JPanel(new BorderLayout(10,10));
        painel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Dashboard");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        JLabel subtitulo = new JLabel("Visão geral da operação");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitulo.setForeground(Color.GRAY);
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(titulo);
        textPanel.add(subtitulo);
        topPanel.add(textPanel, BorderLayout.WEST);

        JButton novoAgendamentoBtn = new JButton("+ Novo Agendamento");
        novoAgendamentoBtn.setBackground(new Color(27,127,48));
        novoAgendamentoBtn.setForeground(Color.WHITE);
        novoAgendamentoBtn.setFocusPainted(false);
        novoAgendamentoBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        novoAgendamentoBtn.setPreferredSize(new Dimension(190,40));
        novoAgendamentoBtn.addActionListener(e -> {
            mainCardLayout.show(mainPanel,"Agendamentos");
            clienteComboBox.requestFocus();
        });
        topPanel.add(novoAgendamentoBtn, BorderLayout.EAST);
        topPanel.setBorder(new EmptyBorder(0,0,20,0));
        painel.add(topPanel, BorderLayout.NORTH);

        JPanel cardsPanel = new JPanel(new GridLayout(1,3,20,0));
        cardsPanel.setOpaque(false);

        faturamentoDiaLabel = new JLabel(String.format("R$ %.2f", relatorio.calcularFaturamentoDia()));
        faturamentoDiaLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        faturamentoSemanaLabel = new JLabel(String.format("R$ %.2f", relatorio.calcularFaturamentoSemana()));
        faturamentoSemanaLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        servicosConcluidosLabel = new JLabel(String.valueOf(relatorio.contarServicosConcluidos()));
        servicosConcluidosLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));

        cardsPanel.add(criarCardInfo(faturamentoDiaLabel,"Faturamento do Dia","\u0024"));
        cardsPanel.add(criarCardInfo(faturamentoSemanaLabel,"Faturamento da Semana","\u2191"));
        cardsPanel.add(criarCardInfo(servicosConcluidosLabel,"Serviços Concluídos","\u2713"));

        painel.add(cardsPanel, BorderLayout.CENTER);

        filaCardsContainer = new JPanel(new GridLayout(1,4,15,0));
        filaCardsContainer.setBackground(Color.WHITE);
        painel.add(filaCardsContainer, BorderLayout.SOUTH);

        atualizarFilaDeTrabalho();

        return painel;
    }

    private JPanel criarCardInfo(JLabel valorLabel,String desc,String icone) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(new EmptyBorder(20,20,20,20));
        painel.setBackground(new Color(220,245,220));
        painel.setOpaque(true);
        painel.setPreferredSize(new Dimension(220,120));

        JLabel iconLabel = new JLabel(icone);
        iconLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 36));
        iconLabel.setForeground(new Color(27,127,48));

        JLabel descLabel = new JLabel(desc);
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        descLabel.setBorder(new EmptyBorder(8,0,0,0));

        painel.add(iconLabel, BorderLayout.WEST);

        JPanel texto = new JPanel();
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));
        texto.setBackground(painel.getBackground());
        texto.add(valorLabel);
        texto.add(descLabel);

        painel.add(texto, BorderLayout.CENTER);
        return painel;
    }

    private void atualizarFilaDeTrabalho() {
        filaCardsContainer.removeAll();
        String[] statusLabels = {"Na Fila","Em Lavagem","Finalizando","Pronto"};
        for(String status : statusLabels) {
            filaCardsContainer.add(criarCardFilaComDados(status));
        }
        filaCardsContainer.revalidate();
        filaCardsContainer.repaint();
    }

    private JPanel criarCardFilaComDados(String status) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(new LineBorder(new Color(180,180,180),1,true));
        painel.setBackground(Color.WHITE);
        painel.setOpaque(true);
        painel.setPreferredSize(new Dimension(220,140));

        List<Agendamento> agsStatus = agendamentos.stream()
                .filter(a -> a.status.equalsIgnoreCase(status))
                .collect(Collectors.toList());
        int qtd = agsStatus.size();

        JLabel lblStatus = new JLabel(status);
        lblStatus.setFont(new Font("Segoe UI", Font.BOLD,16));
        lblStatus.setBorder(new EmptyBorder(10,10,0,0));
        painel.add(lblStatus, BorderLayout.NORTH);

        JLabel lblQtd = new JLabel(String.valueOf(qtd));
        lblQtd.setFont(new Font("Segoe UI", Font.BOLD,28));
        lblQtd.setBorder(new EmptyBorder(10,10,0,0));
        lblQtd.setHorizontalAlignment(SwingConstants.LEFT);
        painel.add(lblQtd, BorderLayout.WEST);

        if(qtd > 0) {
            Agendamento ag = agsStatus.get(0);
            Cliente cli = clientes.stream().
                    filter(c -> c.id == ag.clienteId).findFirst().orElse(null);
            Servico serv = servicos.stream().
                    filter(s -> s.id == ag.servicoId).findFirst().orElse(null);
            Veiculo veic = veiculos.stream().
                    filter(v -> v.id == ag.veiculoId).findFirst().orElse(null);

            String descricao = "";
            if(veic != null && serv != null) {
                descricao = veic.nome + " - " + tipoVeiculoDescricao(veic.tipo) + " • " + serv.nome;
            }

            JPanel clienteInfo = new JPanel();
            clienteInfo.setLayout(new BoxLayout(clienteInfo, BoxLayout.Y_AXIS));
            clienteInfo.setBorder(new EmptyBorder(15,10,15,10));
            clienteInfo.setBackground(new Color(220,245,220));

            JLabel nomeLabel = new JLabel(cli != null ? cli.nome : "");
            nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

            JLabel descLabel = new JLabel(descricao);
            descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            descLabel.setForeground(new Color(80,110,80));

            clienteInfo.add(nomeLabel);
            clienteInfo.add(descLabel);

            painel.add(clienteInfo, BorderLayout.CENTER);
        }

        return painel;
    }

    private String tipoVeiculoDescricao(int tipo) {
        switch(tipo) {
            case 1: return "Pequeno";
            case 2: return "Médio";
            case 3: return "Grande";
            default: return "Desconhecido";
        }
    }

    private JPanel criarAgendamentoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        JLabel titulo = new JLabel("Agendamentos");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        topPanel.add(titulo, BorderLayout.WEST);

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnVoltar.addActionListener(e -> mainCardLayout.show(mainPanel, "Dashboard"));
        topPanel.add(btnVoltar, BorderLayout.EAST);
        topPanel.setBorder(new EmptyBorder(0,0,20,0));
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel corpoPanel = new JPanel(new GridLayout(1,2,20,0));
        corpoPanel.setBackground(Color.WHITE);

        agendamentoListModel = new DefaultListModel<>();
        agendamentoJList = new JList<>(agendamentoListModel);
        agendamentoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollLista = new JScrollPane(agendamentoJList);
        scrollLista.setBorder(BorderFactory.createTitledBorder("Agendamentos atuais"));
        scrollLista.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        corpoPanel.add(scrollLista);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder("Novo Agendamento"));
        formPanel.setBackground(Color.WHITE);

        formPanel.add(criarLabel("Cliente:"));
        clienteComboBox = new JComboBox<>(new DefaultComboBoxModel<>(clientes.toArray(new Cliente[0])));
        clienteComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(clienteComboBox);

        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(criarLabel("Veículo:"));
        veiculoComboBox = new JComboBox<>();
        veiculoComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(veiculoComboBox);

        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(criarLabel("Serviço:"));
        servicoComboBox = new JComboBox<>(new DefaultComboBoxModel<>(servicos.toArray(new Servico[0])));
        servicoComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(servicoComboBox);

        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(criarLabel("Status:"));
        statusComboBox = new JComboBox<>(new String[]{"Na Fila","Em Lavagem","Finalizando","Pronto"});
        statusComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(statusComboBox);

        formPanel.add(Box.createVerticalStrut(25));
        btnSalvarCliente = new JButton("Salvar Agendamento");
        btnSalvarCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalvarCliente.setBackground(new Color(27,127,48));
        btnSalvarCliente.setForeground(Color.WHITE);
        btnSalvarCliente.setFocusPainted(false);
        btnSalvarCliente.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSalvarCliente.addActionListener(e -> salvarNovoAgendamento());
        formPanel.add(btnSalvarCliente);

        corpoPanel.add(formPanel);

        clienteComboBox.addActionListener(e -> atualizarVeiculosDoClienteSelecionado());
        atualizarVeiculosDoClienteSelecionado();
        atualizarListaAgendamentos();

        panel.add(corpoPanel, BorderLayout.CENTER);

        return panel;
    }

    private void atualizarVeiculosDoClienteSelecionado() {
        Cliente selecionado = (Cliente) clienteComboBox.getSelectedItem();
        veiculoComboBox.removeAllItems();
        if(selecionado != null) {
            selecionado.veiculos.forEach(veiculoComboBox::addItem);
        }
        if(veiculoComboBox.getItemCount() > 0) {
            veiculoComboBox.setSelectedIndex(0);
        }
    }

    private void salvarNovoAgendamento() {
        Cliente cliente = (Cliente) clienteComboBox.getSelectedItem();
        Veiculo veiculo = (Veiculo) veiculoComboBox.getSelectedItem();
        Servico servico = (Servico) servicoComboBox.getSelectedItem();
        String status = (String) statusComboBox.getSelectedItem();

        if(cliente == null || veiculo == null || servico == null || status == null) {
            JOptionPane.showMessageDialog(this,"Preencha todos os campos corretamente.","Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int novoId = agendamentos.stream().mapToInt(a -> a.id).max().orElse(0) + 1;
        Agendamento ag = new Agendamento();
        ag.id = novoId;
        ag.clienteId = cliente.id;
        ag.veiculoId = veiculo.id;
        ag.servicoId = servico.id;
        ag.status = status;
        agendamentos.add(ag);

        Fatura f = new Fatura();
        f.id = faturas.stream().mapToInt(fat -> fat.id).max().orElse(0) + 1;
        f.agendamentoId = novoId;
        f.valorFinal = ag.calcularPreco(proprietario.precos, veiculo.tipo);
        f.dataEmissao = new Date();
        faturas.add(f);

        cliente.historicoFaturas.add(f);

        relatorio.faturas = faturas;
        relatorio.agendamentos = agendamentos;

        atualizarListaAgendamentos();
        atualizarFilaDeTrabalho();
        atualizarDashboardDados();

        JOptionPane.showMessageDialog(this,"Agendamento salvo com sucesso!");

        clienteComboBox.setSelectedIndex(0);
        servicoComboBox.setSelectedIndex(0);
        statusComboBox.setSelectedIndex(0);
        atualizarVeiculosDoClienteSelecionado();
    }

    private void atualizarListaAgendamentos() {
        if(agendamentoListModel == null) agendamentoListModel = new DefaultListModel<>();
        agendamentoListModel.clear();
        agendamentos.forEach(agendamentoListModel::addElement);
        if(agendamentoJList == null) {
            agendamentoJList = new JList<>(agendamentoListModel);
        }
    }

    private void atualizarDashboardDados() {
        faturamentoDiaLabel.setText(String.format("R$ %.2f", relatorio.calcularFaturamentoDia()));
        faturamentoSemanaLabel.setText(String.format("R$ %.2f", relatorio.calcularFaturamentoSemana()));
        servicosConcluidosLabel.setText(String.valueOf(relatorio.contarServicosConcluidos()));
    }

    private JPanel criarClientePanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        JLabel titulo = new JLabel("Clientes");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        topPanel.add(titulo, BorderLayout.WEST);

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnVoltar.addActionListener(e -> mainCardLayout.show(mainPanel, "Dashboard"));
        topPanel.add(btnVoltar, BorderLayout.EAST);
        topPanel.setBorder(new EmptyBorder(0,0,20,0));
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel corpoPanel = new JPanel(new GridLayout(1,2,20,0));
        corpoPanel.setBackground(Color.WHITE);

        clienteListModel = new DefaultListModel<>();
        clienteJList = new JList<>(clienteListModel);
        clienteJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clienteJList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        JScrollPane scrollClientes = new JScrollPane(clienteJList);
        scrollClientes.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        corpoPanel.add(scrollClientes);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar / Editar Cliente"));
        formPanel.setBackground(Color.WHITE);

        formPanel.add(criarLabel("Nome:"));
        campoNomeCliente = new JTextField();
        campoNomeCliente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(campoNomeCliente);

        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(criarLabel("Contato:"));
        campoContatoCliente = new JTextField();
        campoContatoCliente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPanel.add(campoContatoCliente);

        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(criarLabel("Veículos do Cliente:"));

        veiculoClienteListModel = new DefaultListModel<>();
        veiculoClienteJList = new JList<>(veiculoClienteListModel);
        veiculoClienteJList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scrollVeiculos = new JScrollPane(veiculoClienteJList);
        scrollVeiculos.setPreferredSize(new Dimension(200,100));
        scrollVeiculos.setBorder(new LineBorder(Color.GRAY,1));
        formPanel.add(scrollVeiculos);

        JPanel veiculoInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        campoNomeVeiculo = new JTextField(10);
        campoNomeVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoTipoVeiculo = new JComboBox<>(new String[]{"Pequeno","Médio","Grande"});
        campoTipoVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnAddVeiculo = new JButton("Adicionar Veículo");
        btnAddVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnAddVeiculo.addActionListener(e -> adicionarVeiculoCliente());

        veiculoInputPanel.add(new JLabel("Nome:"));
        veiculoInputPanel.add(campoNomeVeiculo);
        veiculoInputPanel.add(new JLabel("Tipo:"));
        veiculoInputPanel.add(campoTipoVeiculo);
        veiculoInputPanel.add(btnAddVeiculo);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(veiculoInputPanel);

        formPanel.add(Box.createVerticalStrut(20));
        JButton btnSalvar = new JButton("Salvar Cliente");
        btnSalvar.setBackground(new Color(27,127,48));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSalvar.setFocusPainted(false);
        btnSalvar.addActionListener(e -> salvarCliente());
        formPanel.add(btnSalvar);

        corpoPanel.add(formPanel);

        clienteJList.addListSelectionListener(e -> carregarClienteSelecionado());

        atualizarListaClientes();

        panel.add(corpoPanel, BorderLayout.CENTER);

        return panel;
    }

    private void adicionarVeiculoCliente() {
        String nomeVeic = campoNomeVeiculo.getText().trim();
        int tipoVeic = campoTipoVeiculo.getSelectedIndex() + 1;
        if(nomeVeic.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Informe o nome do veículo");
            return;
        }
        if(clienteSelecionado == null){
            JOptionPane.showMessageDialog(this,"Selecione e/ou salve um cliente para adicionar veículos.");
            return;
        }
        Veiculo v = new Veiculo();
        v.id = veiculos.stream().mapToInt(vei->vei.id).max().orElse(0) + 1;
        v.clienteId = clienteSelecionado.id;
        v.nome = nomeVeic;
        v.tipo = tipoVeic;
        clienteSelecionado.veiculos.add(v);
        veiculos.add(v);
        veiculoClienteListModel.addElement(v);
        campoNomeVeiculo.setText("");
        campoTipoVeiculo.setSelectedIndex(0);
    }

    private void carregarClienteSelecionado() {
        clienteSelecionado = clienteJList.getSelectedValue();
        if(clienteSelecionado != null){
            campoNomeCliente.setText(clienteSelecionado.nome);
            campoContatoCliente.setText(clienteSelecionado.contato);
            veiculoClienteListModel.clear();
            clienteSelecionado.veiculos.forEach(veiculoClienteListModel::addElement);
        }
    }

    private void salvarCliente() {
        String nome = campoNomeCliente.getText().trim();
        String contato = campoContatoCliente.getText().trim();

        if(nome.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nome do cliente é obrigatório.");
            return;
        }
        if(clienteSelecionado == null){
            Cliente novoCliente = new Cliente();
            novoCliente.id = clientes.stream().mapToInt(c -> c.id).max().orElse(0) + 1;
            novoCliente.nome = nome;
            novoCliente.contato = contato;
            clientes.add(novoCliente);
            JOptionPane.showMessageDialog(this,"Cliente cadastrado com sucesso.");
        } else {
            clienteSelecionado.nome = nome;
            clienteSelecionado.contato = contato;
            JOptionPane.showMessageDialog(this,"Cliente atualizado com sucesso.");
        }
        campoNomeCliente.setText("");
        campoContatoCliente.setText("");
        veiculoClienteListModel.clear();
        atualizarListaClientes();
        clienteSelecionado = null;
    }

    private void atualizarListaClientes() {
        clienteListModel.clear();
        clientes.forEach(clienteListModel::addElement);
    }

    private JPanel criarConfiguracoesPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Configurações");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        topPanel.add(titulo, BorderLayout.WEST);

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnVoltar.addActionListener(e -> mainCardLayout.show(mainPanel, "Dashboard"));
        topPanel.add(btnVoltar, BorderLayout.EAST);
        topPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel corpoPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        corpoPanel.setBackground(Color.WHITE);

        JPanel proprietarioPanel = new JPanel();
        proprietarioPanel.setBorder(BorderFactory.createTitledBorder("Dados do Proprietário"));
        proprietarioPanel.setLayout(new BoxLayout(proprietarioPanel, BoxLayout.Y_AXIS));
        proprietarioPanel.setBackground(Color.WHITE);

        proprietarioPanel.add(criarLabel("Nome do Proprietário:"));
        campoNomeProprietario = new JTextField();
        campoNomeProprietario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        proprietarioPanel.add(campoNomeProprietario);

        proprietarioPanel.add(Box.createVerticalStrut(15));
        proprietarioPanel.add(criarLabel("Contato do Proprietário:"));
        campoContatoProprietario = new JTextField();
        campoContatoProprietario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        proprietarioPanel.add(campoContatoProprietario);

        JButton btnSalvarProprietario = new JButton("Salvar Dados");
        btnSalvarProprietario.setBackground(new Color(27, 127, 48));
        btnSalvarProprietario.setForeground(Color.WHITE);
        btnSalvarProprietario.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSalvarProprietario.setFocusPainted(false);
        btnSalvarProprietario.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalvarProprietario.addActionListener(e -> salvarDadosProprietario());
        proprietarioPanel.add(Box.createVerticalStrut(20));
        proprietarioPanel.add(btnSalvarProprietario);

        corpoPanel.add(proprietarioPanel);

        JPanel precoPanel = new JPanel(new BorderLayout(15, 15));
        precoPanel.setBorder(BorderFactory.createTitledBorder("Gerenciar Preços"));
        precoPanel.setBackground(Color.WHITE);

        precoListModel = new DefaultListModel<>();
        precoJList = new JList<>(precoListModel);
        precoJList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        precoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane precoScroll = new JScrollPane(precoJList);
        precoScroll.setPreferredSize(new Dimension(350, 200));
        precoPanel.add(precoScroll, BorderLayout.NORTH);

        JPanel formPrecoPanel = new JPanel();
        formPrecoPanel.setLayout(new BoxLayout(formPrecoPanel, BoxLayout.Y_AXIS));
        formPrecoPanel.setBackground(Color.WHITE);

        formPrecoPanel.add(criarLabel("Tipo de Veículo:"));
        precoTipoVeiculoCombo = new JComboBox<>(new String[] {"Pequeno", "Médio", "Grande"});
        precoTipoVeiculoCombo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPrecoPanel.add(precoTipoVeiculoCombo);

        formPrecoPanel.add(Box.createVerticalStrut(10));
        formPrecoPanel.add(criarLabel("Tipo de Serviço:"));
        precoTipoServicoCombo = new JComboBox<>();
        precoTipoServicoCombo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        atualizarComboServicoPrecos();
        formPrecoPanel.add(precoTipoServicoCombo);

        formPrecoPanel.add(Box.createVerticalStrut(10));
        formPrecoPanel.add(criarLabel("Valor (R$):"));
        precoValorField = new JTextField();
        precoValorField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formPrecoPanel.add(precoValorField);

        formPrecoPanel.add(Box.createVerticalStrut(20));

        JPanel botoesPrecoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        botoesPrecoPanel.setBackground(Color.WHITE);

        btnSalvarPreco = new JButton("Salvar Preço");
        btnSalvarPreco.setBackground(new Color(27, 127, 48));
        btnSalvarPreco.setForeground(Color.WHITE);
        btnSalvarPreco.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnSalvarPreco.setFocusPainted(false);
        btnSalvarPreco.addActionListener(e -> salvarPreco());
        botoesPrecoPanel.add(btnSalvarPreco);

        btnExcluirPreco = new JButton("Excluir Preço");
        btnExcluirPreco.setEnabled(false);
        btnExcluirPreco.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnExcluirPreco.setForeground(Color.RED);
        btnExcluirPreco.addActionListener(e -> excluirPreco());
        botoesPrecoPanel.add(btnExcluirPreco);

        formPrecoPanel.add(botoesPrecoPanel);

        precoPanel.add(formPrecoPanel, BorderLayout.CENTER);

        precoJList.addListSelectionListener(e -> carregarPrecoSelecionado());

        corpoPanel.add(precoPanel);

        carregarDadosProprietario();
        atualizarListaPrecos();

        return panel;
    }

    private void salvarDadosProprietario() {
        String nome = campoNomeProprietario.getText().trim();
        String contato = campoContatoProprietario.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome do Proprietário é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        proprietario.nome = nome;
        proprietario.contato = contato;
        JOptionPane.showMessageDialog(this, "Dados do proprietário salvos com sucesso!");
    }

    private void carregarDadosProprietario() {
        campoNomeProprietario.setText(proprietario.nome != null ? proprietario.nome : "");
        campoContatoProprietario.setText(proprietario.contato != null ? proprietario.contato : "");
    }

    private void atualizarComboServicoPrecos() {
        precoTipoServicoCombo.removeAllItems();
        for (Servico s : servicos) {
            precoTipoServicoCombo.addItem(s.nome);
        }
    }

    private void atualizarListaPrecos() {
        precoListModel.clear();
        if (proprietario.precos != null) {
            for (Preco p : proprietario.precos) {
                precoListModel.addElement(p);
            }
        }
    }

    private void carregarPrecoSelecionado() {
        precoSelecionado = precoJList.getSelectedValue();
        if (precoSelecionado != null) {
            precoTipoVeiculoCombo.setSelectedIndex(precoSelecionado.tipoVeiculo - 1);
            for (int i = 0; i < servicos.size(); i++) {
                if (servicos.get(i).id == precoSelecionado.tipoServico) {
                    precoTipoServicoCombo.setSelectedIndex(i);
                    break;
                }
            }
            precoValorField.setText(String.format("%.2f", precoSelecionado.valor));
            btnExcluirPreco.setEnabled(true);
            btnSalvarPreco.setText("Atualizar Preço");
        } else {
            limparFormularioPreco();
        }
    }

    private void salvarPreco() {
        int tipoVeiculo = precoTipoVeiculoCombo.getSelectedIndex() + 1;
        int tipoServico = precoTipoServicoCombo.getSelectedIndex() >= 0 ? servicos.get(precoTipoServicoCombo.getSelectedIndex()).id : -1;
        String valorStr = precoValorField.getText().trim();

        if (tipoVeiculo <= 0 || tipoServico == -1 || valorStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para salvar o preço.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float valor;
        try {
            valor = Float.parseFloat(valorStr.replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Informe um número decimal.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (proprietario.precos == null) {
            proprietario.precos = new ArrayList<>();
        }

        if (precoSelecionado == null) {
            Preco novo = new Preco();
            novo.id = proprietario.precos.stream().mapToInt(p -> p.id).max().orElse(0) + 1;
            novo.tipoVeiculo = tipoVeiculo;
            novo.tipoServico = tipoServico;
            novo.valor = valor;
            proprietario.precos.add(novo);
            JOptionPane.showMessageDialog(this, "Preço cadastrado com sucesso!");
        } else {
            precoSelecionado.tipoVeiculo = tipoVeiculo;
            precoSelecionado.tipoServico = tipoServico;
            precoSelecionado.valor = valor;
            JOptionPane.showMessageDialog(this, "Preço atualizado com sucesso!");
        }
        limparFormularioPreco();
        atualizarListaPrecos();
        precoSelecionado = null;
    }

    private void excluirPreco() {
        if (precoSelecionado == null) return;
        int resp = JOptionPane.showConfirmDialog(this, "Confirma exclusão deste preço?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            proprietario.precos.remove(precoSelecionado);
            precoSelecionado = null;
            limparFormularioPreco();
            atualizarListaPrecos();
        }
    }

    private void limparFormularioPreco() {
        precoTipoVeiculoCombo.setSelectedIndex(0);
        precoTipoServicoCombo.setSelectedIndex(0);
        precoValorField.setText("");
        btnExcluirPreco.setEnabled(false);
        btnSalvarPreco.setText("Salvar Preço");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LavaRapidoApp app = new LavaRapidoApp();
            app.setVisible(true);
        });
    }

    // Criador de JLabel personalizado
    private JLabel criarLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setBorder(new EmptyBorder(5, 0, 5, 0));
        return lbl;
    }
}
