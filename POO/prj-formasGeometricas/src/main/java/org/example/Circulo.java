package org.example;

public class Circulo {
    public double raio;
    public Circulo(double raio) {
        this.raio = raio;
    }
    public void desenhar() {
        System.out.println("Desenhando um circulo");
    }
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
