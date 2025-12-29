import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String cpf;
    private String especialidade;
    private String crm;
    // Associação da classe Medico no objeto Consulta - Associação Bidirecional
    private List<Consulta> listaDeConsultas = new ArrayList<Consulta>();

    public Medico(String nome, String cpf, String especialidade, String crm) {
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.crm = crm;
    }
    public Medico() {
    }

    public void addConsulta(Consulta consulta){
        listaDeConsultas.add(consulta);
        consulta.setMedico(this);
    }
    public List<Consulta> getListaDeConsultas() {
        return listaDeConsultas;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }
}
