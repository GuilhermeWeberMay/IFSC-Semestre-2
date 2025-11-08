public class Funcionario {
    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public void atualizarEstagio(Agendamento agendamento, String novoEstagio) {
        System.out.printf(" [AÇÃO FUNCIONÁRIO %s] Atualizando agendamento %d para o estágio: %s\n", this.nome, agendamento.getId(), novoEstagio);
        agendamento.setEstagio(novoEstagio);
    }
}
