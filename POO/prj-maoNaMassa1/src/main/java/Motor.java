public class Motor {
    private int potencia;
    // Relacionamento Unidirecional com ETipoCombustivel
    ETipoCombustivel tipoCombustivel;
    // Métodos construtores

    // Método construtor completo
    public Motor(int potencia, ETipoCombustivel tipoCombustivel) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    // Métodos getters e setters
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public ETipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }
    public void setTipoCombustivel(ETipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    // Método de apresentação do objeto - Reescreve o método toString();
    @Override
    public String toString() {
        return "Motor{" +
                "potencia=" + potencia +
                ", tipoCombustivel=" + tipoCombustivel +
                '}';
    }
}
