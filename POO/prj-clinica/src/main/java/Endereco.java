public class Endereco {
    private String rua;
    // Associação da classe Cidade no objeto Endereco - Associação Unidirecional
    private Cidade cidade;

    public Endereco(String rua, Cidade cidade){
        this.rua = rua;
        this.cidade = cidade;
    }

    public Cidade getCidade(){
        return this.cidade;
    }
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }

    public String getRua(){
        return rua;
    }
    public void setRua(String rua){
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
