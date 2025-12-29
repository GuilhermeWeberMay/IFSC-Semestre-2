public class MainApp {
    public static void main(String[] args) {
        // INICIO - Instanciação do objeto Consulta
        Consulta consulta = new Consulta();
        consulta.setDataConsulta("2025-10-08");
        consulta.setHorario("13:30");

        Consulta consulta2 = new Consulta();
        consulta2.setDataConsulta("2026-02-31");
        consulta2.setHorario("15:30");
        // FIM - Instanciação do objeto Consulta

        // INICIO - Instanciação do objeto Medico
        Medico medico = new Medico();
        medico.setNome("Shaun Murphy");
        medico.setCpf("00000000000");
        medico.setCrm("000000");
        medico.setEspecialidade("Ortopedista");

        Medico medico2 = new Medico("Oswaldo Cruz","22222222222","Radiologista","222222");
        // FIM - Instanciação do objeto Medico

        // INICIO - Instanciação do objeto Cidade
        Cidade cidade = new Cidade();
        cidade.setNome("Biguaçu");
        cidade.setUf("SC");

        Cidade cidade2 = new Cidade("Curitiba", "PR");
        // FIM - Instanciação do objeto Cidade

        // INICIO - Instanciação do objeto Paciente
        Paciente paciente = new Paciente();
        paciente.setNome("Guilherme");
        paciente.setCpf("11111111111");
        paciente.addEndereco("Rua sete de Setembro", cidade);

        Paciente paciente2 = new Paciente("Eduardo Gomes","33333333333", "Rua Sete", cidade2);
        // FIM - Instanciação do objeto Paciente



        // Carregando informações da primeira consulta
        consulta.setMedico(medico);
        consulta.setPrioridade(EPrioridade.BAIXA);
        consulta.setPaciente(paciente);
        paciente.addConsulta(consulta);
        medico.addConsulta(consulta);

        // Carregando informações da segunda consulta
        consulta2.setMedico(medico2);
        consulta2.setPrioridade(EPrioridade.ALTA);
        consulta2.setPaciente(paciente2);
        paciente2.addConsulta(consulta2);
        medico2.addConsulta(consulta2);

        // INICIO - Instanciação e sobrecarga do objeto Consulta
        // Carregando informações da terceira consulta
        Consulta consulta3 = new Consulta("2025-10-24","19:00", medico,paciente2,EPrioridade.MEDIA);
        consulta3.setMedico(medico);
        consulta3.setPrioridade(EPrioridade.MEDIA);
        consulta3.setPaciente(paciente2);
        paciente2.addConsulta(consulta3);
        medico.addConsulta(consulta3);

        // Carregando informações da quarta consulta
        Consulta consulta4 = new Consulta("2025-07-17","19:00", medico2,paciente,EPrioridade.BAIXA);
        consulta4.setMedico(medico2);
        consulta4.setPrioridade(EPrioridade.BAIXA);
        consulta4.setPaciente(paciente);
        paciente.addConsulta(consulta4);
        medico2.addConsulta(consulta4);
        // INICIO - Instanciação e sobrecarga do objeto Consulta

        System.out.println("Consultas do paciente: " + paciente.getNome());

        for (Consulta c : paciente.getConsultas()) {
            System.out.println("Data: " + c.getDataConsulta());
            System.out.println("Horário: " + c.getHorario());
            System.out.println("Médico: " + c.getMedico().getNome());
            System.out.println("Prioridade: " + c.getPrioridade());
            System.out.println("---------------------------");
        }

        System.out.println("Consultas do paciente: " + paciente2.getNome());
        for (Consulta c : paciente2.getConsultas()) {
            System.out.println("Data: " + c.getDataConsulta());
            System.out.println("Horário: " + c.getHorario());
            System.out.println("Médico: " + c.getMedico().getNome());
            System.out.println("Prioridade: " + c.getPrioridade());
            System.out.println("---------------------------");
        }

        System.out.println("Consulta 1 "+ consulta);
        System.out.println("Consulta 2 "+ consulta2);
        System.out.println("Consulta 3 "+ consulta3);
        System.out.println("Consulta 4 "+ consulta4);

        System.out.println(consulta2.getPaciente().getEndereco().getCidade().getNome());















    }
}
