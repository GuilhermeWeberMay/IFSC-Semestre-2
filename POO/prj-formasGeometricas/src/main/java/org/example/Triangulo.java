package org.example;

public class Triangulo {
    public double base;
    public double altura;
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    public void desenhar() {
        System.out.println("Desenhando um triângulo");
    }
    public double calcularArea(){
        return (base * altura) / 2;
    }
}
