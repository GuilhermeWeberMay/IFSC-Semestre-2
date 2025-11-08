import java.util.List;

public class Agendamento {
    private int id;
    private int clienteId;
    private int veiculoId;
    private int servicoId;
    private String estagio;
    private static int proximoId = 1;

    public Agendamento(int clienteId, int veiculoId, int servicoId) {
        this.id = proximoId++;
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.servicoId = servicoId;
        this.estagio = "Na Fila";
    }

    public double calcularPreco(List<Preco> tabelaPrecos, Veiculo veiculo, Servico servico) {
        for (Preco p : tabelaPrecos) {
            if (p.getTipoVeiculo() == veiculo.getTipo() && p.getTipoServico() == servico.getTipo()) {
                return p.getValor();
            }
        }
        throw new RuntimeException("Preço não encontrado para a combinação.");
    }

    public int getId() {
        return id;
    }

    public String getEstagio() {
        return estagio;
    }

    public void setEstagio(String estagio) {
        this.estagio = estagio;
    }

    @Override
    public String toString() {
        return String.format("Agendamento{id=%d, clienteId=%d, estagio='%s'}", id, clienteId, estagio);
    }
}