package org.example;

public class Caneta {
    public String cor;
    public float espessura;
    public boolean tampada;
    public int carga = 100;
    public Caneta(String cor, float espessura, boolean tampada) {
        this.cor = cor;
        this.espessura = espessura;
        this.tampada = tampada;
    }
    public void escrever(String texto){
        if (tampada){
            System.out.println("Não pode escrever. A caneta está tampada.");
        }else{
            System.out.println("Escrevendo: "+ texto);
            consumirCarga(1);
        }
    }
    public void pintar(){
        if (tampada){
            System.out.println("Não pode escrever. A caneta está tampada.");
        }else{
            System.out.println("Pintando com caneta: "+ cor);
            consumirCarga(2);
        }
    }
    public void tampar(){
        tampada = true;
        System.out.println("Caneta tampada");
    }
    public void destampar(){
        tampada = false;
        System.out.println("Caneta destampada");
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public float getEspessura() {
        return espessura;
    }
    public void setEspessura(float espessura) {
        this.espessura = espessura;
    }
    public boolean isTampada() {
        return tampada;
    }
    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }
    public int getCarga() {
        return carga;
    }
    private void consumirCarga(int carga) {
        this.carga -= carga;
    }
}
