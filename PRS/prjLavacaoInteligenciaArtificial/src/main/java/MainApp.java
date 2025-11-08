import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Arquivo único contendo todo o sistema de gestão de Lava-Car para fácil execução.
 * Para usar:
 * 1. Crie um arquivo chamado LavaCarSistema.java
 * 2. Cole todo este código no arquivo.
 * 3. Compile e execute o método main.
 */
public class LavaCarSistema {

    // =================================================================
    // 1. CLASSES DE ENTIDADE (Modelos)
    // =================================================================

    public static class Cliente {
        private int id;
        private String nome;
        private String contato;
        private static int proximoId = 1;

        public Cliente(String nome, String contato) {
            this.id = proximoId++;
            this.nome = nome;
            this.contato = contato;
        }

        // --- Getters para acesso aos dados ---
        public int getId() { return id; }
        public String getNome() { return nome; }

        @Override
        public String toString() {
            return "Cliente{" + "id=" + id + ", nome='" + nome + "'}";
        }
    }

    public static class Veiculo {
        private int id;
        private int clienteId;
        private int tipo; // 1-Pequeno, 2-Médio, 3-Grande
        private static int proximoId = 1;

        public Veiculo(int clienteId, int tipo) {
            throw new IllegalArgumentException("Tipo de veículo inválido. Use 1, 2 ou 3.");
        }
            this.id = proximoId++;
            this.clienteId = clienteId;
            this.tipo = tipo;
    }

    public int getTipo() { return tipo; }
    public int getId() { return id; }
    public int getClienteId() { return clienteId; }

    @Override
    public String toString() {
        String tipoStr = (tipo == 1) ? "Pequeno" : (tipo == 2) ? "Médio" : "Grande";
        return "Veiculo{" + "id=" + id + ", clienteId=" + clienteId + ", tipo=" + tipoStr + "}";
    }
}

public static class Servico {
    private int id;
    private String nome;
    private int tipo; // 1-Externa, 2-Completa, 3-Completa+Cera
    private static int proximoId = 1;

    public Servico(String nome, int tipo) {
        throw new IllegalArgumentException("Tipo de serviço inválido. Use 1, 2 ou 3.");
    }
            this.id = proximoId++;
            this.nome = nome;
            this.tipo = tipo;
}

public int getTipo() { return tipo; }
public String getNome() { return nome; }

@Override
public String toString() {
    return "Servico{" + "id=" + id + ", nome='" + nome + "'}";
}
    }

public static class Preco {
    private int id;
    private int tipoVeiculo;
    private int tipoServico;
    private double valor;
    private static int proximoId = 1;

    public Preco(int tipoVeiculo, int tipoServico, double valor) {
        this.id = proximoId++;
        this.tipoVeiculo = tipoVeiculo;
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public double buscarPreco(int tipoVeiculo, int tipoServico) {
        if (this.tipoVeiculo == tipoVeiculo && this.tipoServico == tipoServico) {
            return this.valor;
        }
        return -1; // Indica que este objeto de preço não corresponde
    }

    public int getTipoVeiculo() { return tipoVeiculo; }
    public int getTipoServico() { return tipoServico; }
    public double getValor() { return valor; }
}

public static class Agendamento {
    private int id;
    private int clienteId;
    private int veiculoId;
    private int servicoId;
    private String estagio; // Ex: "Na Fila", "Em Lavagem", "Finalizado"
    private static int proximoId = 1;

    public Agendamento(int clienteId, int veiculoId, int servicoId) {
        this.id = proximoId++;
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.servicoId = servicoId;
        this.estagio = "Na Fila"; // Estado inicial
    }

    public double calcularPreco(List<Preco> tabelaPrecos, Veiculo veiculo, Servico servico) {
        for (Preco p : tabelaPrecos) {
            if (p.getTipoVeiculo() == veiculo.getTipo() && p.getTipoServico() == servico.getTipo()) {
                return p.getValor();
            }
        }
        throw new RuntimeException("Preço não encontrado para a combinação de veículo e serviço.");
    }

    public int getId() { return id; }
    public int getClienteId() { return clienteId; }
    public String getEstagio() { return estagio; }
    public void setEstagio(String estagio) { this.estagio = estagio; }

    @Override
    public String toString() {
        return String.format("Agendamento{id=%d, clienteId=%d, veiculoId=%d, servicoId=%d, estagio='%s'}",
                id, clienteId, veiculoId, servicoId, estagio);
    }
}

public static class Fatura {
    private int id;
    private int agendamentoId;
    private double valorFinal;
    private Date dataEmissao;
    private static int proximoId = 1;

    public Fatura(int agendamentoId, double valorFinal) {
        this.id = proximoId++;
        this.agendamentoId = agendamentoId;
        this.valorFinal = valorFinal;
        this.dataEmissao = new Date(); // Data atual
    }

    @Override
    public String toString() {
        return String.format("Fatura{id=%d, agendamentoId=%d, valorFinal=R$%.2f, data=%s}",
                id, agendamentoId, valorFinal, dataEmissao);
    }
}

public static class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private static int proximoId = 1;

    public Funcionario(String nome, String cargo) {
        this.id = proximoId++;
        this.nome = nome;
        this.cargo = cargo;
    }

    public void atualizarEstagio(Agendamento agendamento, String novoEstagio) {
        System.out.printf("  [AÇÃO FUNCIONÁRIO %s] Atualizando agendamento %d para o estágio: %s\n", this.nome, agendamento.getId(), novoEstagio);
        agendamento.setEstagio(novoEstagio);
    }
}

// Classes Proprietario e Relatorio seguem o mesmo padrão
public static class Proprietario { }
public static class Relatorio { }


// =================================================================
// 2. CLASSE PRINCIPAL COM A LÓGICA DE EXECUÇÃO
// =================================================================

public static void main(String[] args) {
    System.out.println("--- INICIANDO SIMULAÇÃO DO SISTEMA LAVA-CAR ---");

    // --- DADOS MESTRE (CONFIGURAÇÃO INICIAL) ---
    List<Preco> tabelaDePrecos = new ArrayList<>();
    tabelaDePrecos.add(new Preco(1, 1, 30.00)); // Veiculo Pequeno, Serviço Externo
    tabelaDePrecos.add(new Preco(1, 2, 50.00)); // Veiculo Pequeno, Serviço Completo
    tabelaDePrecos.add(new Preco(2, 1, 40.00)); // Veiculo Médio, Serviço Externo
    tabelaDePrecos.add(new Preco(2, 2, 70.00)); // Veiculo Médio, Serviço Completo

    List<Servico> servicosDisponiveis = new ArrayList<>();
    servicosDisponiveis.add(new Servico("Lavação Externa", 1));
    servicosDisponiveis.add(new Servico("Lavação Completa", 2));

    // --- Listas para simular o banco de dados ---
    List<Cliente> clientesDB = new ArrayList<>();
    List<Veiculo> veiculosDB = new ArrayList<>();
    List<Agendamento> agendamentosDB = new ArrayList<>();
    List<Fatura> faturasDB = new ArrayList<>();

    // --- 1. Cadastro de Clientes e Veículos ---
    System.out.println("\n1. CADASTRO DE CLIENTES E VEÍCULOS");
    Cliente cliente1 = new Cliente("Guilherme Weber", "111-222");
    clientesDB.add(cliente1);
    Veiculo veiculo1 = new Veiculo(cliente1.getId(), 1); // Carro Pequeno
    veiculosDB.add(veiculo1);
    System.out.println("  > Cliente cadastrado: " + cliente1);
    System.out.println("  > Veículo cadastrado: " + veiculo1);

    Cliente cliente2 = new Cliente("Ana Costa", "333-444");
    clientesDB.add(cliente2);
    Veiculo veiculo2 = new Veiculo(cliente2.getId(), 2); // Carro Médio
    veiculosDB.add(veiculo2);
    System.out.println("  > Cliente cadastrado: " + cliente2);
    System.out.println("  > Veículo cadastrado: " + veiculo2);

    // --- 2. Criação de um novo agendamento ---
    System.out.println("\n2. CRIANDO NOVO AGENDAMENTO");
    Agendamento agendamento1 = new Agendamento(cliente1.getId(), veiculo1.getId(), servicosDisponiveis.get(1).getNome().equals("Lavação Completa") ? 2 : 1);
    agendamentosDB.add(agendamento1);
    System.out.println("  > Novo agendamento criado: " + agendamento1);

    // --- 3. Cálculo do Preço ---
    System.out.println("\n3. CÁLCULO DE PREÇO DO AGENDAMENTO");
    try {
        double precoCalculado = agendamento1.calcularPreco(tabelaDePrecos, veiculo1, servicosDisponiveis.get(1));
        System.out.printf("  > Preço calculado para o agendamento %d: R$%.2f\n", agendamento1.getId(), precoCalculado);

        // --- 4. Ação do Funcionário ---
        System.out.println("\n4. ATUALIZAÇÃO DE ESTÁGIO PELO FUNCIONÁRIO");
        Funcionario func1 = new Funcionario("Carlos", "Lavador");
        func1.atualizarEstagio(agendamento1, "Em Lavagem");
        System.out.println("  > Status atual do agendamento: " + agendamento1);

        func1.atualizarEstagio(agendamento1, "Finalizado");
        System.out.println("  > Status atual do agendamento: " + agendamento1);

        // --- 5. Geração da Fatura ---
        System.out.println("\n5. GERAÇÃO DA FATURA");
        if (agendamento1.getEstagio().equals("Finalizado")) {
            Fatura fatura1 = new Fatura(agendamento1.getId(), precoCalculado);
            faturasDB.add(fatura1);
            System.out.println("  > Fatura gerada com sucesso: " + fatura1);
        } else {
            System.out.println("  > Agendamento ainda não finalizado. Fatura não pode ser gerada.");
        }

    } catch (RuntimeException e) {
        System.err.println("Erro no processamento: " + e.getMessage());
    }

    System.out.println("\n--- SIMULAÇÃO FINALIZADA ---");
}
}