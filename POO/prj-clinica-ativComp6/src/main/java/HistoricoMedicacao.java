public class HistoricoMedicacao {
    private String descricao;
    private RegistroConsulta registroConsulta;
    private Medicamento medicamento;

    public HistoricoMedicacao(RegistroConsulta registroConsulta,Medicamento medicamento, String descricao) {
        this.descricao = descricao;
        this.registroConsulta = registroConsulta;
        this.medicamento = medicamento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public RegistroConsulta getRegistroConsulta() {
        return registroConsulta;
    }
    public void setRegistroConsulta(RegistroConsulta registroConsulta) {
        this.registroConsulta = registroConsulta;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "HistoricoMedicacao{" +
                "descricao='" + descricao + '\'' +
                ", registroConsulta=" + registroConsulta +
                ", medicamento=" + medicamento +
                '}';
    }
}
