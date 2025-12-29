public class Consulta {
    // Atributos
    private String data;
    private String horario;
    // Associação unidirecional com Prioridade
    private EPrioridade prioridade;
    // Associação bidirecional com Paciente
    private Paciente paciente;
    // Associação de agregação com Medico
    private Medico medico;

    // Construtores
    public Consulta(String data, String horario) {
        this.data = data;
        this.horario = horario;
    }

    public Consulta(String data, String horario, EPrioridade prioridade) {
        this.data = data;
        this.horario = horario;
        this.prioridade = prioridade;
    }

    // Métodos de acesso - getters e setters
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public EPrioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(EPrioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", prioridade=" + prioridade +
                ", paciente=" + paciente +
                ", medico=" + medico +
                '}';
    }
}
