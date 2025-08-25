<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="Exerc6.css">
 <title> Fundamentos do PHP </title>
</head>
<body>
 <h1> Fundamentos do PHP - Exerc6 - resposta servidor </h1>
 <?php
 $valorCompra = $_POST["valor-compra"];

 // Declaração de uma constante
 define("TAXA_DESCONTO", 5/100);
 define("TAXA_ACRESCIMO", 0.02);

 $desconto = 0;
 // Descobrindo se o cliente pagou com cartão ou não - isset
 if(isset($_POST['cartao'])){
  $desconto = $valorCompra * TAXA_DESCONTO;
 }

 // Descobrindo se o cliente solicitou entrega a domicilio ou não - isset
 $acrescimo = 0; 
 if(isset($_POST['entrega'])){
  $acrescimo = $valorCompra * TAXA_ACRESCIMO;
 }

 // Calculando o valor final da compra
 $valorFinal = $valorCompra - $desconto + $acrescimo;
 $valorCompraFormatada = number_format($valorCompra, 2, ',', '.');
 $valorFinalFormatado = number_format($valorFinal, 2, ',', '.');
 $descontoFormatado = number_format($desconto, 2, ',', '.');
 $acrescimoFormatado = number_format($acrescimo, 2, ',', '.');

 echo "<p> Resultado do processamento da compra: <br>

           Valor inicial da compra = <span> R$$valorCompraFormatada </span> <br>

           Valor do desconto = <span> R$$descontoFormatado </span> <br>

           Valor do acrésimo = <span> R$$acrescimoFormatado </span> <br>

           Valor final da compra = <span> R$$valorFinalFormatado </span> <br>
 </p>";
 ?>
</body>
</html>