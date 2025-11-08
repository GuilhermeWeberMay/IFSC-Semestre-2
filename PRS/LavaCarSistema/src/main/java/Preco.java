public class Preco {
    private int tipoVeiculo;
    private int tipoServico;
    private double valor;

    public Preco(int tipoVeiculo, int tipoServico, double valor) {
        this.tipoVeiculo = tipoVeiculo;
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public int getTipoServico() {
        return tipoServico;
    }

    public double getValor() {
        return valor;
    }
}