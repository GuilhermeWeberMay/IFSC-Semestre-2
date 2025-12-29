package br.edu.ifsc.fln.domain;

public class Servico {
    // Atributos
    private int id;
    private String descricao;
    private double valor;
    private static int pontos;
    // Associação Uniderecional com ECategoria
    private ECategoria categoria;

    // Construtor
    public Servico(int id, String descricao, double valor,ECategoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }


    // Métodos getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public static int getPontos() {
        return pontos;
    }
    public static void setPontos(int pontos) {
        Servico.pontos = pontos;
    }

    public ECategoria getCategoria() {
        return categoria;
    }
    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", categoria=" + categoria +
                '}';
    }
}
