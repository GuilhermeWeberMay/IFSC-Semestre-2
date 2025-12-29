import java.util.*;

public class Medico extends Pessoa implements IAgendavel{
    // Atributos
    private String especialidade;
    private String crm;
    // Associação de agregação com Consulta
    List<Consulta> listaConsultas =  new ArrayList<>();

    // Construtores
    public Medico(String nome, String cpf, String especialidade, String crm){
        super(nome, cpf);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    // Métodos de acesso - getters e setters
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

    // Métodos
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Especialidade: " + this.getEspecialidade());
        System.out.println("CRM..........: " + this.getCrm());
    }

    // Método reescrito que vem da Interface Agendavel
    @Override
    public void agendarConsulta(Consulta consulta){
        this.listaConsultas.add(consulta);
        consulta.setMedico(this);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidade='" + especialidade + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }
}
