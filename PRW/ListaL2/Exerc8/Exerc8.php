<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc4.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc8 </h1>

 <?php
 define("TAXA_DESCONTO", 0.05);

 $vetorPrecos = ['Dexilant' => 329.59,
                 'Paracetamol' => 9.89,
                 'Loratadina' => 27.67];

 if(!isset($_POST['remedios'])){
  exit("<p> Caro usuário, você não adquiriu nenhum medicamento de nossa farmácia virtual e, portanto, o valor total de sua compra é de R$0,00 </p>");
 }

 $remediosComprados = $_POST['remedios'];

 $valorTotalCompra = 0;
 foreach($remediosComprados as $remedio){
   $valorTotalCompra += $vetorPrecos[$remedio];
  }
  $desconto = 0;
 if(isset($_POST['faixa-etaria'])){
   $desconto = $valorTotalCompra * TAXA_DESCONTO;
  }
 $valorTotalCompra = $valorTotalCompra - $desconto;
 $valorTotalCompraFormatada = number_format($valorTotalCompra, 2, ",", ".");
 $valorDesconto = number_format($desconto, 2, ",", ".");

 echo"<p> Caro usuário, de acordo com os remédios comprados, temos o seguinte relatório: <br> 
 Valor final da compra = R$$valorTotalCompraFormatada <br>
 Valor total do desconto = R$$valorDesconto
 ";
 
 ?>

</body>
</html>