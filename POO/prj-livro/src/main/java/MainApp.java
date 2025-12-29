public class MainApp {
    public static void main(String[] args) {
        // Criação e instanciação do objeto e carregamento do objeto
        Livro livro = new Livro(15.99f,0.5f);
        // Criação e instanciação do objeto e carregamento do objeto completo
        Livro livro2 = new Livro (1, "A Psicologia Financeira", "9786555111101", "Morgan Housel","Braspor",12.75f, 0.35f);

        System.out.println("\nInformações do livro 1 ");
        System.out.println("Id do livro: "+livro.getId());
        System.out.println("Título do livro: "+livro.getTitulo());
        System.out.println("ISBN do livro: "+livro.getIsbn());
        System.out.println("Autor do livro: "+livro.getAutor());
        System.out.println("Editora do livro: "+livro.getEditora());
        System.out.println("Preço de custo: "+livro.getPrecoCusto());
        System.out.println("Margem de lucro: "+livro.getMargemLucro());
        System.out.println("Valor de venda: "+livro.getPrecoVenda()+"\n");

        System.out.println("Informações do livro 2 ");
        System.out.println("Id do livro: "+livro2.getId());
        System.out.println("Título do livro: "+livro2.getTitulo());
        System.out.println("ISBN do livro: "+livro2.getIsbn());
        System.out.println("Autor do livro: "+livro2.getAutor());
        System.out.println("Editora do livro: "+livro2.getEditora());
        System.out.println("Preço de custo do livro: "+livro2.getPrecoCusto());
        System.out.println("Margem de lucro do livro: "+livro2.getMargemLucro());
        System.out.println("Preço de venda do livro: "+livro2.getPrecoVenda());
    }
}
