<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos PHP </title>
</head>
<body>
 <h1> Fundamentos PHP - Exerc10 - Resposta Servidor</h1>
 <?php
 $valorCompra = $_POST['valorCompra'];
 $comissao = $_POST['comissao'];
 $comissao = $comissao / 100;
 $comissao = $valorCompra * $comissao;

 $valorCompraFormatada = number_format($valorCompra,2,",",".");
 $valorComissaoFormatada = number_format($comissao,2,",",".");

 echo "<p> Valor da compra: R$$valorCompraFormatada <br>
           Valor da comissão: R$$valorComissaoFormatada </p>";
 ?>
</body>
</html>