package org.example;

public class Quadrado {
    public double lado;
    public Quadrado(double lado){
        this.lado = lado;
    }
    public void desenhar() {
        System.out.println("Desenhando um quadrado");
    }
    public double calcularArea(){
        return lado * lado;
    }
}
