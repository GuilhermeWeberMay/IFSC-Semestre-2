public class Livro {
    // Atributos do objeto - o que o objeto É
    private int id;
    private String titulo;
    private String isbn;
    private String autor;
    private String editora;
    private float precoCusto;
    private float precoVenda;
    private float margemLucro;

    // Métodos do objeto - o que o objeto FAZ
    public Livro(){
        // Método construtor padrão do JAVA
    }
    // Sobrecarga do método construtor - com parametro para os atributos
    public Livro(int id, String titulo, String isbn, String autor, String editora,
                 float precoCusto, float margemLucro){
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.precoCusto = precoCusto;
        this.margemLucro = margemLucro;
    }
    // Método construtor com somente margem lucro e preco custo
    public Livro(float precoCusto, float margemLucro){
        this.precoCusto = precoCusto;
        this.margemLucro = margemLucro;
    }

    // Métodos getter's e setter's dos atributos
    // Métodos SETTER'S presisam de parametro mas podem ser void pois não retornam valor
    // Métodos GETTER'S não precisam de parametros mas precisam identificar qual o tipo do return - int, float, String, bollean etc.

    public int getId(){
        // Aqui não seria melhor usar um THIS?
        return id;
    }
    // Métodos setter's precisam ter parametros
    public void setId(int id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getEditora(){
        return editora;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }

    public float getPrecoCusto(){
        return precoCusto;
    }
    public void setPrecoCusto(float precoCusto){
        this.precoCusto = precoCusto;
    }

    public float getPrecoVenda(){
        return calcularPrecoVenda();
    }

    public float getMargemLucro(){
        return margemLucro;
    }
    public void setMargemLucro(int margemLucro){
        this.margemLucro = margemLucro;
    }

    public float calcularPrecoVenda(){
        return precoCusto + (precoCusto * margemLucro);
    }
}

