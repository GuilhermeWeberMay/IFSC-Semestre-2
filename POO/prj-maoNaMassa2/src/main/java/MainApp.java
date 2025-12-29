public class MainApp {
    public static void print(Veiculo veiculo){
        System.out.println(veiculo.getDados());
    }
    public static void print (IDados dados){
        System.out.println("Dados do print IDados");
        System.out.println(dados.getDados());
    }
    public static void print (Cliente c){
        System.out.println("Dados do print Cliente");
        if (c instanceof PessoaJuridica){
            System.out.println("Dados pessoa juridica");
        }else {
            System.out.println("Dados pessoa fisica");
        }
        System.out.print(c.getDados());
        System.out.println(c.getPontuacao());
        System.out.println();
    }
    public static void main(String[] args) {
        // Instanciacao e sobre carga do objeto Cor
        Cor cor = new Cor(1, "Prata");
        Cor cor2 = new Cor(2, "Preto");
        Cor cor3 = new Cor(3, "Branco");
        Cor cor4 = new Cor(4, "Roxo");

        // Instanciacao e sobre carga do objeto Cliente
        PessoaFisica pf = new PessoaFisica(1, "Guilherme", "48 999117218", "gui",
                "10168481960", 2025, 10, 20);
        PessoaJuridica pj = new PessoaJuridica(1, "Tela & Decor", "48", "tela", "89", "98");

        // Instanciacao e sobre carga do objeto Marca
        Marca marca = new Marca(1, "Nissan");
        Marca marca2 = new Marca(2, "Honda");
        Marca marca3 = new Marca(3, "Audi");
        Marca marca4 = new Marca(4, "BMW");

        // Instanciacao e sobre carga do objeto Modelo
        Modelo modelo = new Modelo(1,"Versa", marca, ECategoria.MEDIO,110, ETipoCombustivel.GALOSINA);
        Modelo modelo2 = new Modelo(2,"S15",marca2,ECategoria.PADRAO,250,ETipoCombustivel.FLEX);
        Modelo modelo3 = new Modelo(3, "RS6", marca3,ECategoria.GRANDE, 630, ETipoCombustivel.GNV);
        Modelo modelo4 = new Modelo(4, "S1000RR", marca4, ECategoria.MOTO, 210, ETipoCombustivel.ETANOL);

        // Instanciacao e sobre carga do objeto Veiculo
        Veiculo veiculo = new Veiculo(1,"SSF4B18","Nissan Versa", cor, modelo);
        Veiculo veiculo2 = new Veiculo(2,"GXP7D88","Esportivo importado", cor2, modelo2);
        Veiculo veiculo3 = new Veiculo(3,"WDC8J14","Veículo premium", cor3, modelo3);
        Veiculo veiculo4 = new Veiculo(4,"MAY9G06","Motocicleta esportiva de alta cilindrada", cor4, modelo4);

        // Associando os cliente aos veiculos
        pf.addVeiculo(veiculo);  // Guilherme tem Versa
        pf.addVeiculo(veiculo4); // Gabriel tem S15
        pf.addVeiculo(veiculo2); // Gabriel tem RS6
        pf.addVeiculo(veiculo3); // Guilherme tem S1000RR

        print(pj);
        print(pf);

        print((IDados)pf);
        print((IDados)pj);

        print(veiculo);
        print(veiculo2);
        print(veiculo3);
        print(veiculo4);

    }
}
