package br.edu.ifsc.fln.domain;

import br.edu.ifsc.fln.exception.*;
import br.edu.ifsc.fln.domain.*;

import java.time.LocalDate;
import java.util.*;

public class OrdemServico {
    // Atributos
    private long numero;
    private double total;
    private LocalDate agenda;
    private double desconto;
    // Associação Unidirecional com EStatus
    private EStatus status;
    // Relação de agregação com a classe br.edu.ifsc.fln.domain.Veiculo
    private Veiculo veiculo;
    // Classe associativa
    private List<ItemOS> itensOS = new ArrayList<>(); // Isso já garante a composição? Porque?

    // Construtor
    public OrdemServico(long numero, double desconto, EStatus status, Veiculo veiculo) {
        this.numero = numero;
        this.agenda = LocalDate.now();
        this.desconto = desconto;
        this.status = status;
        this.veiculo = veiculo;
    }

    // Métodos getters e setters
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() throws ExceptionLavacao {
        if (total < 0){
            throw new ExceptionLavacao("Não há valor total pois não há serviço vinculado");
        }else {
            for (ItemOS itemOS : itensOS) {
                total += itemOS.getServico().getValor();
            }
            return total;
        }
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getAgenda() {
        return agenda;
    }

    public void setAgenda(LocalDate agenda) {
        this.agenda = agenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<ItemOS> getItensOS() throws ExceptionLavacao{
        if (itensOS.isEmpty()){
            throw new ExceptionLavacao("Não há serviços na lista para serem calculados");
        }else {
            return itensOS;
        }
    }

    public void setItensOS(List<ItemOS> itensOS) {
        this.itensOS = itensOS;
    }

    public double calcularServico() throws ExceptionLavacao {
        if (itensOS.isEmpty()) {
            throw new ExceptionLavacao("Não há serviços na lista para serem calculados");
        }else{
            return total -= total * (getDesconto() / 100);
        }
    }

    public void add(ItemOS itemOS) throws ExceptionLavacao{
        if(itensOS.contains(itemOS)){
            throw new ExceptionLavacao("Esse serviço já está na ordem de serviço");
        }else {
            itensOS.add(itemOS);
        }
    }

    public void remove(ItemOS itemOS) throws  ExceptionLavacao{
        if(!itensOS.contains(itemOS)){
            throw new ExceptionLavacao("Esse serviço não está na ordem de serviço");
        }else {
            itensOS.add(itemOS);
        }
    }

    //Método para calcular os pontos aos clientes
    public int calcularPontos() throws ExceptionLavacao {
        int pontos = 0;
        for ( ItemOS itemOS : getItensOS()){
            pontos += itemOS.getServico().getPontos();
        }
        this.getVeiculo().getCliente().getPontuacao().adicionar(pontos);
        return pontos;
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "veiculo=" + veiculo +
                ", status=" + status +
                ", desconto=" + desconto +
                ", agenda=" + agenda +
                ", total=" + total +
                ", numero=" + numero +
                '}';
    }
}
