package br.edu.ifsc.fln.domain;

public enum ETipoCombustivel {
    GALOSINA("Gasolina"), ETANOL("Etanol"), FLEX("Flex"), DIESEL("Diesel"), GNV("GNV"), OUTRO("Outro?");
    private String descricao;
    private ETipoCombustivel(String descricao) {this.descricao = descricao;}
    public String getDescricao() {return descricao;}

}
