import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class MainApp2 {

    public static void main(String[] args) {
        System.out.println("--- INICIANDO SIMULAÇÃO DO SISTEMA LAVA-CAR ---");

        // --- DADOS MESTRE (CONFIGURAÇÃO INICIAL) ---
        List<Preco> tabelaDePrecos = new ArrayList<>();
        tabelaDePrecos.add(new Preco(1, 1, 30.00f)); // Veiculo Pequeno, Serviço Externo
        tabelaDePrecos.add(new Preco(1, 2, 50.00f)); // Veiculo Pequeno, Serviço Completo
        tabelaDePrecos.add(new Preco(2, 1, 40.00f)); // Veiculo Médio, Serviço Externo
        tabelaDePrecos.add(new Preco(2, 2, 70.00f)); // Veiculo Médio, Serviço Completo

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
        Servico servicoEscolhido = servicosDisponiveis.get(1); // Lavação Completa
        Agendamento agendamento1 = new Agendamento(cliente1.getId(), veiculo1.getId(), servicoEscolhido.getTipo());
        agendamentosDB.add(agendamento1);
        System.out.println("  > Novo agendamento criado: " + agendamento1);

        // --- 3. Cálculo do Preço ---
        System.out.println("\n3. CÁLCULO DE PREÇO DO AGENDAMENTO");
        try {
            double precoCalculado = agendamento1.calcularPreco(tabelaDePrecos, veiculo1, servicoEscolhido);
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
            }
        } catch (RuntimeException e) {
            System.err.println("Erro no processamento: " + e.getMessage());
        }

        System.out.println("\n--- SIMULAÇÃO FINALIZADA ---");
    }
}