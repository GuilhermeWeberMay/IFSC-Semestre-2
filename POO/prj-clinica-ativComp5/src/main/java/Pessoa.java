public abstract class Pessoa {
    // Atributos
    private String nome;
    private String cpf;

    // Construtores
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Métodos de acesso - getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Métodos
    protected void exibirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
