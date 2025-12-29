package br.edu.ifsc.fln.domain;

public class ItemOS {
    private double valorServico;
    private String observacoes;
    // Classe associativa com as duas classes
    private OrdemServico ordemServico;
    private Servico servico;

    public ItemOS(String observacoes, OrdemServico ordemServico, Servico servico) {
        this.valorServico = servico.getValor();
        this.observacoes = observacoes;
        this.ordemServico = ordemServico;
        this.servico = servico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "ItemOS{" +
                "valorServico=" + valorServico +
                ", observacoes='" + observacoes + '\'' +
                ", ordemServico=" + ordemServico +
                ", servico=" + servico +
                '}';
    }
}
