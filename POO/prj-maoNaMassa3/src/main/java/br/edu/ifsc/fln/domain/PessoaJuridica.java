package br.edu.ifsc.fln.domain;

public class PessoaJuridica extends Cliente implements IDados{
    // Atributos
    private String cnpj;
    private String inscricaoEstadual;

    // Construtores
    public PessoaJuridica(int id, String nome, String celular, String email, String cnpj, String inscricaoEstadual) {
        // Aqui temos o construtor super que é responsavel por levar os atributos para a classe abstrata
        super(id, nome, celular, email);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    // Métodos
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDados() {
        StringBuilder info = new StringBuilder();
        info.append(super.getDados());
        info.append("CNPJ..............: ").append(cnpj).append("\n");
        info.append("Inscrição estadual: ").append(inscricaoEstadual).append("\n");
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
        return "PessoaJuridica{" +
                super.toString() +
                "cnpj='" + cnpj + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                '}';
    }
}
