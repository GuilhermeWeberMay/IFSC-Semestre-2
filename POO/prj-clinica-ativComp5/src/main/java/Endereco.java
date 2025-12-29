public class Endereco {
    // Atributos
    private String rua;
    private String complemento;
    // Relacionamento unidirecional com Cidade
    private Cidade cidade;

    // Construtores
    public Endereco(String rua, String complemento, Cidade cidade) {
        this.rua = rua;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    // Métodos de acesso - getters e setters
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
