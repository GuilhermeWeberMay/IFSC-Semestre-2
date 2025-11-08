import java.util.Date;

public class Fatura {
    private int id;
    private int agendamentoId;
    private double valorFinal;
    private Date dataEmissao;
    private static int proximoId = 1;

    public Fatura(int agendamentoId, double valorFinal) {
        this.id = proximoId++;
        this.agendamentoId = agendamentoId;
        this.valorFinal = valorFinal;
        this.dataEmissao = new Date();
    }

    @Override
    public String toString() {
        return String.format("Fatura{id=%d, agendamentoId=%d, valorFinal=R$%.2f, data=%s}", id, agendamentoId, valorFinal, dataEmissao);
    }
}