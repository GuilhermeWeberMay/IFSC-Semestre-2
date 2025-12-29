public class MainApp {
    public static void main(String[] args) {
        // INICIO - Instanciação dos objetos
        Medico medico = new Medico("Israel", "123.456.789-01", "Ortopedista", "00000-00");
        Medico medico1 = new Medico("Beatriz", "987.654.321-10", "Cardiologista", "11111-11");

        Cidade cidade = new Cidade("Biguaçu", "SC");
        Cidade cidade1 = new Cidade("Rio Fortuna", "SC");

        Paciente paciente = new Paciente("Guilherme", "10168481960", "48999117218", "Rua Jordelino", "Apartamento", cidade);
        Paciente paciente1 = new Paciente("Silvia", "028.785.159-19", "48991515700", "Estrada Geral do Rio Fortuna", "Casa", cidade1);

        Consulta consulta = new Consulta("2025-10-16", "16:20h", EPrioridade.BAIXA);
        Consulta consulta1 = new Consulta("2025-10-29", "15:20", EPrioridade.ALTA);
        // FIM - Instanciação dos objetos

        // Associação das consultas com os médicos e pacientes
        // Primeira consulta
        paciente.agendarConsulta(consulta);
        medico.agendarConsulta(consulta);

        // Segunda consulta
        paciente1.agendarConsulta(consulta1);
        medico1.agendarConsulta(consulta1);

        // Uso do método exibirInformacoes();
        medico.exibirInformacoes();
        System.out.println("===================");
        medico1.exibirInformacoes();
        System.out.println("===================");
        paciente.exibirInformacoes();
        System.out.println("===================");
        paciente1.exibirInformacoes();
        System.out.println();

        // Apresentação das informações da consulta
        System.out.println("Informações das consultas: ");
        System.out.println(consulta);
        System.out.println(consulta1);
    }
}
