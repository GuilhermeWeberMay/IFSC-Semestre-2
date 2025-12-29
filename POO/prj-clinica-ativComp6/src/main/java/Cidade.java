public class Cidade {
    // Atributos
    private String nome;
    private String uf;

    // Construtores
    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    // Métodos de acesso - getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
