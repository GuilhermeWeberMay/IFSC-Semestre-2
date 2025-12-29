package br.edu.ifsc.fln.report;
import br.edu.ifsc.fln.domain.*;
public class Relatorio {
    public static String imprimir (Cliente c) {
        StringBuilder dados = new StringBuilder();
        dados.append("Dados do print Cliente\n");
        if (c instanceof PessoaJuridica) {
            dados.append("Dados pessoa juridica\n");
        } else {
            dados.append("Dados pessoa fisica\n");
        }
        dados.append(c.getDados());
        dados.append("\nLista de carros: ").append("\n");
        for (Veiculo v : c.getListaVeiculos()) {
            dados.append(v.getDados());
            dados.append("==============================").append("\n\n");
        }
        return dados.toString();
    }
}
