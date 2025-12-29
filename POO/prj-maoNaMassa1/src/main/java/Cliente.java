import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String celular;
    private String email;
    private LocalDate dataCadastro;
    private List<Veiculo> listaVeiculos =  new ArrayList<>();

    public Cliente(int id, String nome, String celular, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = LocalDate.now();
    }

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

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
        veiculo.setCliente(this);
    }
    public void removeVeiculo(Veiculo veiculo) {
        this.listaVeiculos.remove(veiculo);
        veiculo.setCliente(null);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
