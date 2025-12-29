public class Modelo {
    private int id;
    private String descricao;
    // Relacionamento uniderional com Marca
    private Marca marca;
    // Relacionamento uniderional com ECategoria
    ECategoria categoria;
    // Relacionamento de Agreagção com Motor
    private Motor motor;

    public Modelo(int id, String descricao,Marca marca, ECategoria categoria, int potencia, ETipoCombustivel tipoCombustivel) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.motor = new Motor(potencia,tipoCombustivel);
    }

    public ECategoria getCategoria() {
        return categoria;
    }
    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Motor getMotor() {
        return motor;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", marca=" + marca +
                ", categoria=" + categoria +
                ", motor=" + motor +
                '}';
    }
}
