package br.edu.ifsc.fln.domain;

public enum EStatus {
    ABERTA("Aberta"), FECHADA("Fechada"),CANCELADA("Cancelada");
    private String descricao;
    private EStatus(String descricao) {this.descricao = descricao;}
    public String getDescricao() {return descricao;}
}
