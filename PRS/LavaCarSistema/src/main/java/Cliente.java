public class Cliente {
    private int id;
    private String nome;
    private String contato;
    private static int proximoId = 1;

    public Cliente(String nome, String contato) {
        this.id = proximoId++;
        this.nome = nome;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome='" + nome + "'}";
    }
}