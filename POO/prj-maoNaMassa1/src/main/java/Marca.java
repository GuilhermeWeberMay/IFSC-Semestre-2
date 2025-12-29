public class Marca {
    private int id;
    private String nome;

    // Métodos contrutores

    // Método construtor completo
    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    // Método construtor vazio


    // Métodos GETTERS e SETTERS
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
        return "Marca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
