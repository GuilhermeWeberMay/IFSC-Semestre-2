public class MainApp {
    public static void main(String[] args) {

        Cidade cidade = new Cidade("Biguacu", "SC");

        Endereco endereco = new Endereco("Rua Sete de Setembro", cidade);

//        endereco = null;
        Paciente paciente = new Paciente("Guilherme Weber May", "00000000000", endereco.getRua(), cidade);

        Medico medico = new Medico("Shaun Murphy", "11111111111", "Ortopedista","123456");

        Consulta consulta = new Consulta("08/10/2025", "13:30", medico, paciente, EPrioridade.BAIXA);

        System.out.println("\nPrincipais informações sobre a primeira consulta: ");
        System.out.println("Data......: " + consulta.getDataConsulta());
        System.out.println("Horario...: " + consulta.getHorario());
        System.out.println("Médico....: " + consulta.getMedico().getNome());
        System.out.println("Paciente..: " + consulta.getPaciente().getNome());
        System.out.println("Prioridade: " + consulta.getPrioridade().getDescricao());
        System.out.println("--------------------");

    }
}
