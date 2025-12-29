package br.edu.ifsc.fln.main;

import br.edu.ifsc.fln.report.*;
import br.edu.ifsc.fln.domain.*;
import br.edu.ifsc.fln.exception.*;

public class MainApp {
    public static void imprimir (OrdemServico os) {
        System.out.println(ImpressaoOS.imprimirOS(os));
    }

    public static void imprimir (Cliente c) {
        System.out.print(Relatorio.imprimir(c));
    }

    public static void main(String[] args) {
        // Instanciacao e sobre carga do objeto Cor
        Cor cor2 = new Cor(1, "Preto");
        Cor cor3 = new Cor(2, "Branco");
        Cor cor4 = new Cor(3, "Vermelho");

        // Instanciacao e sobre carga do objeto Cliente
        PessoaFisica pf = new PessoaFisica(1, "Guilherme", "48999117218", "guilhermewebermay@gmail.com",
                "10168481960", 2006, 10, 24);
        PessoaJuridica pj = new PessoaJuridica(1, "Tela & Decor", "48991550957", "contato@telaedecor.com",
                "10820608000116", "608000116");

        // Instanciacao e sobre carga do objeto br.edu.ifsc.fln.domain.Marca
        Marca marca = new Marca(1, "Nissan");
        Marca marca2 = new Marca(2, "Hyundai");
        Marca marca3 = new Marca(3, "Renault");
        Marca marca4 = new Marca(4, "BMW");

        // Instanciacao e sobre carga do objeto br.edu.ifsc.fln.domain.Modelo
        Modelo modelo = new Modelo(1, "Versa", marca, ECategoria.MEDIO, 110, ETipoCombustivel.GALOSINA);
        Modelo modelo2 = new Modelo(2, "HB20", marca2, ECategoria.PADRAO, 250, ETipoCombustivel.FLEX);
        Modelo modelo3 = new Modelo(3, "Sandero-Stepway", marca3, ECategoria.GRANDE, 630, ETipoCombustivel.GNV);
        Modelo modelo4 = new Modelo(4, "S1000RR", marca4, ECategoria.MOTO, 210, ETipoCombustivel.ETANOL);

        // Instanciacao e sobre carga do objeto br.edu.ifsc.fln.domain.Veiculo
        Veiculo veiculo = new Veiculo(1, "SSF4B18", "Nissan Versa", cor2, modelo);
        Veiculo veiculo2 = new Veiculo(2, "GXP7D88", "Hyundai HB20", cor2, modelo2);
        Veiculo veiculo3 = new Veiculo(3, "WDC8J14", "Renault Sandero-Stepway", cor3, modelo3);
        Veiculo veiculo4 = new Veiculo(4, "MAY9G06", "S1000RR", cor4, modelo4);

        // Instanciacao e sobrecarga do objeto Serviço
        Servico servico1 = new Servico(1, "Lavagem externa", 30f,  ECategoria.PEQUENO);
        Servico servico2 = new Servico(2, "Lavagem externa", 50f,  ECategoria.PADRAO);
        Servico servico3 = new Servico(3, "Lavação externa", 70f,  ECategoria.MEDIO);
        Servico servico4 = new Servico(4, "Lavação externa", 90f,  ECategoria.GRANDE);

        Servico servico5 = new Servico(5, "Lavação externa + interna", 50f,  ECategoria.PEQUENO);
        Servico servico6 = new Servico(6, "Lavação externa + interna", 70f,  ECategoria.PADRAO);
        Servico servico7 = new Servico(7, "Lavação externa + interna", 90f,  ECategoria.MEDIO);
        Servico servico8 = new Servico(8, "Lavação externa + interna", 110f,  ECategoria.GRANDE);

        Servico servico9 = new Servico(9, "Lavação externa + interna + cera", 70f,  ECategoria.PEQUENO);
        Servico servico10 = new Servico(10, "Lavação externa + interna + cera", 90f,  ECategoria.PADRAO);
        Servico servico11 = new Servico(11, "Lavação externa + interna + cera", 110f,  ECategoria.MEDIO);
        Servico servico12 = new Servico(12, "Lavação externa + interna + cera", 130f,  ECategoria.GRANDE);

        Servico servico13 = new Servico(13, "Lavagem externa", 20f,  ECategoria.MOTO);
        Servico servico14 = new Servico(14, "Lavação externa + cera", 40f,  ECategoria.MOTO);

        // Usa o atributo estatico, e coloca todos os serviços com a mesma pontuação
        Servico.setPontos(10);


        OrdemServico os1 = new OrdemServico(1,10f, EStatus.ABERTA, veiculo4);

        ItemOS itemOS1 = new ItemOS("", os1, servico1);
        ItemOS itemOS2 = new ItemOS("", os1, servico14);
        ItemOS itemOS3 = new ItemOS("", os1, servico8);
        try {
            os1.add(itemOS1);
            os1.add(itemOS2);
        }
        catch (ExceptionLavacao e){
            System.err.println(e.getMessage());
        }

        // Associando os cliente aos veiculos
        try {
            pf.addVeiculo(veiculo);  // Guilherme tem Versa
            pj.addVeiculo(veiculo2); // Tela e Decor tem Hyundai HB20
            pj.addVeiculo(veiculo3); // Tela e Decor tem Renault Sandero-Stepway
            pf.addVeiculo(veiculo4); // Guilherme tem S1000RR
        } catch(ExceptionLavacao e) {
            System.err.println(e.getMessage());
        }

        imprimir(pf);

        imprimir(os1);

        imprimir(pf);


        // INICIO - Funcionamento da EXCEPTIONLAVACAO

        // Exception br.edu.ifsc.fln.domain.OrdemServico - Inserção
        try{
            os1.add(itemOS1);
        } catch(ExceptionLavacao e) {
            System.err.println(e.getMessage());
        }
        // Exception br.edu.ifsc.fln.domain.OrdemServico - Remoção
        try{
            os1.remove(itemOS3);
        } catch(ExceptionLavacao e) {
            System.err.println(e.getMessage());
        }

        // Exception Cliente - Inserção
        try{
            pj.addVeiculo(veiculo4);
        }catch(ExceptionLavacao e){
            System.err.println(e.getMessage());
        }
        // Exception Cliente - Remoção
        try{
            pj.removeVeiculo(veiculo);
        }catch(ExceptionLavacao e) {
            System.err.println(e.getMessage());
        }

        // Exception Pontuação - Remoção
        try{
            pf.getPontuacao().subtrair(1000);
        }
        catch(ExceptionLavacao e){
            System.err.println(e.getMessage());
            System.err.println("Seu saldo é: "+pf.getPontuacao().saldo());
        }

        // FIM - Funcionamento da EXCEPTIONLAVACAO




    }
}
