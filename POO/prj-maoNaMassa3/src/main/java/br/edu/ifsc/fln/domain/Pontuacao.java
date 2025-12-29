package br.edu.ifsc.fln.domain;

import br.edu.ifsc.fln.exception.ExceptionLavacao;

public class Pontuacao {
    // Atributos
    private int quantidade;

    // Construtores
    public Pontuacao(int quantidade) {
        this.quantidade = quantidade;
    }

    // Métodos
    public int saldo() {
        return quantidade;
    }
    public void subtrair(int quantidade) throws ExceptionLavacao {
        if (quantidade <= this.quantidade){
            this.quantidade -= quantidade;
        }else {
            throw new ExceptionLavacao("Você não tem todos esses pontos");
        }
    }
    public void adicionar(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public String toString() {
        return "Pontuacao: " +
                quantidade;
    }
}
