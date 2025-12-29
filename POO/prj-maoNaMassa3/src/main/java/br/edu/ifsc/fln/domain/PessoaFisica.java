package br.edu.ifsc.fln.domain;

import java.time.LocalDate;
public class PessoaFisica extends Cliente implements IDados { // Extends é a palavra servada para herança
    // Atributos
    private String cpf;
    private LocalDate dataNascimento;

    // Construtores
    public PessoaFisica(int id, String nome, String celular, String email, String cpf, int ano, int mes, int dia) {
        // Na herança o super é a chamado do construtor da classe acima dele, e enviamos os atributos desta classe
        super(id, nome, celular, email);
        this.cpf = cpf;
        this.dataNascimento = LocalDate.of(ano, mes, dia);
    }

    // Métodos getters e setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDados() {
        StringBuilder info = new StringBuilder();
        info.append(super.getDados());
        info.append("CPF...............: ").append(cpf).append("\n");
        info.append("Data de nascimento: ").append(dataNascimento).append("\n");
        return info.toString();
    }

    @Override
    public String getDados(String observacao){
        StringBuilder info = new StringBuilder();
        info.append(getDados());
        info.append("Observação..........: ").append(observacao).append("\n");
        return info.toString();
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                super.toString() +
                "cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
