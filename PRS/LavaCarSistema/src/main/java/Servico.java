public class Servico {
    private int id;
    private String nome;
    private int tipo; // 1-Externa,2-Completa,3-Completa+Cera
    private static int proximoId = 1;

    public Servico(String nome, int tipo) {
        this.id = proximoId++;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}