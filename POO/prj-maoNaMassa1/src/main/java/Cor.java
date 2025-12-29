public class Cor {
    private int id;
    private String nome;

    // Métodos construtores

    // Método construtor completo
    public Cor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Método construtor vazio


    // Métodos getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método de apresentação do objeto - Reescreve o método toString();
    @Override
    public String toString() {
        return "Cor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
