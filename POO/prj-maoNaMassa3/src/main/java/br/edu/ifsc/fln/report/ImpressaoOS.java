package br.edu.ifsc.fln.report;

import br.edu.ifsc.fln.domain.*;
import br.edu.ifsc.fln.exception.*;

public class ImpressaoOS {

    public static String imprimirOS(OrdemServico os) {

        StringBuilder dados = new StringBuilder();

        dados.append("============================================================\n");
        dados.append("                        CUPOM FISCAL                        \n");
        dados.append("============================================================\n");

        dados.append(
                String.format(
                        "Número: %-6d Dia: %-12s Status: %s\n",
                        os.getNumero(),
                        os.getAgenda(),
                        os.getStatus()
                )
        );

        dados.append("Cliente: ").append(os.getVeiculo().getCliente().getNome()).append("\n");

        dados.append(
                String.format(
                        "Veiculo: %-12s Modelo: %s\n",
                        os.getVeiculo().getPlaca(),
                        os.getVeiculo().getModelo().getDescricao()
                )
        );

        dados.append("============================================================\n");
        dados.append(String.format("%-5s %-35s %10s\n", "ITEM", "DESCRICAO", "VALOR"));
        dados.append("============================================================\n");

        try {
            int nItem = 1;
            for (ItemOS itemOS : os.getItensOS()) {

                dados.append(
                        String.format(
                                "%-5d %-35s %10.2f\n",
                                nItem,
                                itemOS.getServico().getDescricao(),
                                itemOS.getServico().getValor()
                        )
                );

                nItem++;
            }
        } catch (ExceptionLavacao e) {
            dados.append(e.getMessage()).append("\n");
        }

        dados.append("============================================================\n");

        try {

            // SUBTOTAL
            dados.append(
                    String.format("%-20s %30.2f\n",
                            "SUBTOTAL",
                            os.getTotal()
                    )
            );

            // DESCONTO (%) sem casas decimais
            dados.append(
                    String.format("%-20s %30.0f\n",
                            "DESCONTO (%)",
                            os.getDesconto()
                    )
            );

            dados.append("============================================================\n");

            // TOTAL FINAL
            dados.append(
                    String.format("%-20s %30.2f\n",
                            "TOTAL",
                            os.calcularServico()
                    )
            );

        } catch (ExceptionLavacao e) {
            dados.append(e.getMessage()).append("\n");
        }

        // >>>>>>> PONTOS GERADOS FORMATADOS <<<<<<<<
        try {
            dados.append(
                    String.format("%-20s %30d\n",
                            "PONTOS GERADOS",
                            os.calcularPontos()
                    )
            );
        }
        catch (ExceptionLavacao e) {
            dados.append(e.getMessage()).append("\n");
        }

        return dados.toString();
    }
}
