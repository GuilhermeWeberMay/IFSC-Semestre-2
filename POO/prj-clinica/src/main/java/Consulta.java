public class Consulta {
    private String dataConsulta;
    private String horario;
    // Associação da classe Consulta no objeto Medico - Associação Bidirecional
    private Medico medico;
    // Associação da classe Paciente no objeto Consulta - Associação Unidirecional
    private Paciente paciente;
    private EPrioridade prioridade;


    public Consulta(String dataConsulta, String horario, Medico medico, Paciente paciente, EPrioridade prioridade) {
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.prioridade = prioridade;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public EPrioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(EPrioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "dataConsulta='" + dataConsulta + '\'' +
                ", horario='" + horario + '\'' +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", prioridade=" + prioridade +
                '}';
    }
}
