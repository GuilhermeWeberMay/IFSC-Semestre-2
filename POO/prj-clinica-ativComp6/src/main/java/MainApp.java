public class MainApp {
    public static void print(Pessoa p){
        if (p instanceof Paciente){
            System.out.println("Dados do paciente:");
            p.exibirInformacoes();
            System.out.println("==========");
        }else {
            System.out.println("Dados do médico:");
            p.exibirInformacoes();
            System.out.println("==========");
        }
    }
    public static void print (Consulta c){
        print(c.getPaciente());
        print(c.getMedico());
        System.out.println("MEDICAMENETOS RECEITADOS: ");
        for (HistoricoMedicacao r : c.getRegistroConsulta().getHistoricoMedicacoes()) {
            System.out.println("Nome medicamento....: " + r.getMedicamento().getNome());
            System.out.println("Laboratório indicado: "+ r.getMedicamento().getFabricante());
            System.out.println("Diagnóstico.........: " + r.getRegistroConsulta().getDescricao());
            System.out.println("====================");
        }
    }
    public static void main(String[] args) {
        // INICIO - Instanciação dos objetos
        Medico medico = new Medico("Israel", "123.456.789-01", "Ortopedista", "00000-00");
        Medico medico1 = new Medico("Beatriz", "987.654.321-10", "Cardiologista", "11111-11");

        Cidade cidade = new Cidade("Biguaçu", "SC");
        Cidade cidade1 = new Cidade("Rio Fortuna", "SC");

        Paciente paciente = new Paciente("Guilherme", "10168481960", "48999117218", "Rua Jordelino", "Apartamento", cidade);
        Paciente paciente1 = new Paciente("Silvia", "028.785.159-19", "48991515700", "Estrada Geral do Rio Fortuna", "Casa", cidade1);

        RegistroConsulta rg1 = new RegistroConsulta("O paciente apresenta quadro viral leve.");
        RegistroConsulta rg2 = new RegistroConsulta("O paciente apresenta entorse de tornozelo com lesão ligamentar leve.");

        Consulta consulta = new Consulta("2025-10-16", "16:20h", EPrioridade.BAIXA, rg1);
        Consulta consulta1 = new Consulta("2025-10-29", "15:20", EPrioridade.ALTA, rg2);

        Medicamento medicamento = new Medicamento("Dipirona", "EMS");
        Medicamento medicamento1 = new Medicamento("Ibuprofeno", "BASF");
        Medicamento medicamento2 = new Medicamento("Biofenac", "CIMED");
        Medicamento medicamento3 = new Medicamento("Glucosamina", "NEO QUIMICA");

        HistoricoMedicacao hm1 = new HistoricoMedicacao(rg1, medicamento, "Para aliviar a febre e reduzir o desconforto causado pelos sintomas.");
        HistoricoMedicacao hm2 = new HistoricoMedicacao(rg1, medicamento1, "Para ajudar a diminuir dores corporais e melhorar o bem-estar geral durante a recuperação.");
        HistoricoMedicacao hm3 = new HistoricoMedicacao(rg2, medicamento2, "Para reduzir a inflamação e aliviar a dor, facilitando a recuperação e a mobilidade.");
        HistoricoMedicacao hm4 = new HistoricoMedicacao(rg2, medicamento3, "Para auxiliar na saúde da cartilagem e na recuperação geral das estruturas articulares");
        // FIM - Instanciação dos objetos

        // Associação das consultas com os médicos e pacientes
        // Primeira consulta
        paciente.agendarConsulta(consulta);
        medico.agendarConsulta(consulta);

        // Segunda consulta
        paciente1.agendarConsulta(consulta1);
        medico1.agendarConsulta(consulta1);

        // Associando os historicos aos registros
        rg1.adicionarMedicamento(hm1);
        rg1.adicionarMedicamento(hm2);
        rg2.adicionarMedicamento(hm3);
        rg2.adicionarMedicamento(hm4);

        // Mostrando as informações das consulta
        System.out.println("PRIMEIRA CONSULTA: ");
        print(consulta);
        System.out.println();
        System.out.println("SEGUNDA CONSULTA: ");
        print(consulta1);
    }
}
