package br.edu.ifsc.fln.domain;

import br.edu.ifsc.fln.exception.ExceptionLavacao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements IDados { // implements significa que essa classe tera um contrato com a interface
    int id;
    String nome;
    String celular;
    String email;
    LocalDate dataCadastro;
    private List<Veiculo> listaVeiculos =  new ArrayList<>();
    private Pontuacao pontuacao;

    public Cliente(int id, String nome, String celular, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = LocalDate.now();
        this.pontuacao = new Pontuacao(0);
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

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void addVeiculo(Veiculo veiculo) throws ExceptionLavacao {
        if(listaVeiculos.contains(veiculo)) {
            throw new ExceptionLavacao("Carro já tem cliente");
        }else{
            this.listaVeiculos.add(veiculo);
            veiculo.setCliente(this);
        }
    }
    public void removeVeiculo(Veiculo veiculo) throws ExceptionLavacao {
        if(!listaVeiculos.contains(veiculo)) {
            throw new ExceptionLavacao("Carro não está neste cliente");
        }else{
            this.listaVeiculos.remove(veiculo);
            veiculo.setCliente(null);
        }
    }

    public String apresentaListaCarros(){
        StringBuilder car = new StringBuilder();
        for (Veiculo v : listaVeiculos){
            car.append(v.getCor());
        }
        return car.toString();
    }

    // Métodos abstratos da Interface
    public String getDados(){
        StringBuilder info = new StringBuilder();
        info.append("Id................: ").append(id).append("\n");
        info.append("Nome..............: ").append(nome).append("\n");
        info.append("Celular...........: ").append(celular).append("\n");
        info.append("Email.............: ").append(email).append("\n");
        info.append("Data de cadastro..: ").append(dataCadastro).append("\n");
        info.append("Pontuacao.........: ").append(getPontuacao().saldo()).append("\n");
        return info.toString();
    }
    public String getDados(String observacao){
        StringBuilder info = new StringBuilder();
        info.append(getDados());
        info.append("Observação........: ").append(observacao).append("\n");
        return info.toString();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", pontuacao=" + pontuacao +
                '}';
    }
}
