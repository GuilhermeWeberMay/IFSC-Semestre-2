public class Pontuacao {
    // Atributos
    private int quantidade = 0;

    // Construtores
    public Pontuacao(int quantidade) {
        this.quantidade = quantidade;
    }

    // Métodos
    public int saldo() {
        return quantidade;
    }
    public void subtrair(int quantidade) {
        quantidade -= quantidade;
    }
    public void adicionar(int quantidade) {
        quantidade += quantidade;
    }

    @Override
    public String toString() {
        return "Pontuacao{" +
                "quantidade=" + quantidade +
                '}';
    }
}
