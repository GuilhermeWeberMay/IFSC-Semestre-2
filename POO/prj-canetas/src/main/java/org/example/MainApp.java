package org.example;
public class MainApp {
    public static void main(String[] args) {
        /* Aula 01
        Caneta c1 = new Caneta();
        c1.cor = "Azul";
        c1.carga = 100;
        c1.tampada = true;
        c1.espessura = 0.07f;
        // Inserção do objeto caneta
        Caneta c2 = new Caneta();
        c2.cor = "Verde";
        c2.carga = 100;
        c2.tampada = false;
        c2.espessura = 0.05f;
        System.out.println(c1.espessura);
        System.out.println(c1.cor);
        System.out.println(c1.carga);
        System.out.println(c1.tampada);
        System.out.println("=======");
        System.out.println(c2.espessura);
        System.out.println(c2.cor);
        System.out.println(c2.carga);
        System.out.println(c2.tampada);
        System.out.println("===FIM===");*/

        Caneta canetaAzul = new Caneta("Azul", 0.7f, true);
        Caneta canetaVermelha = new Caneta("Vermelha", 0.5f, true);

        System.out.println("Cor da caneta: "+canetaAzul.getCor());
        System.out.println("Espessura da caneta: "+canetaAzul.getEspessura());
        System.out.println("Carga da caneta: "+canetaAzul.getCarga());
        canetaAzul.escrever("Olá mundo!");
        canetaAzul.destampar();
        canetaAzul.escrever("Olá mundo!");
        canetaAzul.tampar();
        System.out.println("Carga da caneta: "+canetaAzul.getCarga());
        System.out.println("------------------------------------------");
        System.out.println("Cor da caneta: "+canetaVermelha.getCor());
        System.out.println("Espessura da caneta: "+canetaVermelha.getEspessura());
        System.out.println("Carga da caneta Vermelha: "+canetaVermelha.getCarga());
        canetaAzul.pintar();
        canetaAzul.destampar();
        canetaAzul.pintar();
        canetaAzul.tampar();
        System.out.println("Carga da caneta: "+canetaVermelha.getCarga());
    }
}