<!DOCTYPE html>
<html lang="pt-BR">

<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title> Fundamentos do PHP </title>
      <link rel="stylesheet" href="exerc10.css">
</head>

<body>
      <h1> Fundamentos do PHP - resposta do servidor </h1>

      <?php

      $percentual = $_POST['comissao'];

      $valorCompra = $_POST['valor-compra'];

      //cálculos
      $percentual = $percentual / 100;
      $comissao = $percentual * $valorCompra;


      //mostrando resultados das variáveis e da constante

      echo "<p> Resultado da venda: <br>
        TOTAL DA COMPRA DO CLIENTE = <span> R$$valorCompra </span> <br>

        <p> PERCENTUAL DE COMISSÃO DO VENDEDOR: <span> $percentual </span> <br>

        <p> VALOR TOTAL DA COMISSÃO DO VENDEDOR: <span> $comissao
        </p>";

      ?>
</body>

</html>