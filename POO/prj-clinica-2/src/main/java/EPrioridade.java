public enum EPrioridade {
    ALTA ("Alta"), MEDIA ("Média"), BAIXA ("Baixa");
    private String descricao;
     private EPrioridade (String descricao){
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
