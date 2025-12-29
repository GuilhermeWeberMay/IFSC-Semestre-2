public enum ECategoria {
    PEQUENO("Pequeno"), MEDIO("Médio"), GRANDE("Grande"), MOTO("Moto"), PADRAO("Padrão");
    private String descricao;
    private ECategoria(String descricao) {this.descricao = descricao;}
    public String getDescricao() {return descricao;}
}
