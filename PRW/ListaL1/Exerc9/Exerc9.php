<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos PHP </title>
</head>
<body>
 <h1> Fundamentos do PHP - Exerc9 - Resposta Servidor </<?php
 $valorDolar = $_POST['dolar'];
 define('TAXA_CONVERSAO', 5.41);
 $valorReais = $valorDolar * TAXA_CONVERSAO;
 $valorDolarFormatado = number_format($valorDolar, 2, ',', '.');
 $valorReaisFormatado = number_format($valorReais, 2, ',', '.');
 echo "<p>O valor convertido é: $valorReaisFormatado <br> 
       E a taxa de conversão é: ",TAXA_CONVERSAO,"</p>";

 ?>
</body>
</html>