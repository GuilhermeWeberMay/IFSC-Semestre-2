<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="exerc8.css">
</head>

<body>
 <h1> Fundamentos do PHP - resposta do servidor </h1>

 <?php
    $valorCompra = $_POST['valor-compra'];

    if(!isset($_POST["idade"]))
    {
      die("<p> <span> Erro fatal: a idade deve ser ser fornecida. Aplicação encerrada! </span> </p>");
    }
    
    $idade = $_POST["idade"];

    $desconto = 0;
    

    if ($idade == "entre-55-70")
    {
      $desconto = 0.05 * $valorCompra;
    }

    else if ($idade == "mais-70")
    {
      $desconto = 0.07 * $valorCompra;
    }

    if (isset($_POST["cartao"]))
    {
      $desconto = $desconto + 0.05 * $valorCompra;
    }

    //calculando o valor final da compra
    $valorFinal = $valorCompra - $desconto;

    $valorCompraFormatada    = number_format($valorCompra, 2, ",", ".");
    $valorFinalFormatado     = number_format($valorFinal, 2, ",", ".");
    $valorDescontoFormatado  = number_format($desconto, 2, ",", ".");

    echo "<p> Resultado do processamento da compra: <br>
            Valor inicial da compra = <span> R$$valorCompraFormatada </span> <br>
            Valor do desconto = <span> R$$valorDescontoFormatado </span> <br>
            Valor final da compra = <span> R$$valorFinalFormatado </span> 
            </p>";

 ?> 
</body>
</html>