import java.util.ArrayList;
import java.util.List;

public class RegistroConsulta {
    private String descricao;

    // Composição que esta na classe associativa
    private List<HistoricoMedicacao> historicoMedicacoes = new ArrayList<>();

    public RegistroConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<HistoricoMedicacao> getHistoricoMedicacoes() {
        return historicoMedicacoes;
    }
    public void setHistoricoMedicacoes(List<HistoricoMedicacao> historicoMedicacoes) {
        this.historicoMedicacoes = historicoMedicacoes;
    }

    public void adicionarMedicamento(HistoricoMedicacao historicoMedicacao){
        historicoMedicacoes.add(historicoMedicacao);
    }

    @Override
    public String toString() {
        return "RegistroConsulta{" +
                "descricao='" + descricao +
                '}';
    }
}
