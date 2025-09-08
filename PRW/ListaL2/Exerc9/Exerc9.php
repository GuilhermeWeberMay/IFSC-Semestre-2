<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc4.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc9 - Servidor</h1>

 <?php
 // Vamos criar o vetor de preços manualmente
 $vetorPrecos = ['batata-frita' => 12.99,
                 'refrigerante' => 3.59,
                 'miojo' => 1.79,     
                 'bolacha-recheada' => 5.49];

 // Começando o processamento para calcular o valor total da compra efetuada pelo cliente

 // Testando se o cliente não comprou nada
 $valorTotalCompra = 0;
 if (!isset($_POST['produtos'])){
  exit("<p> Caro usuário, você não adquiriu nenhum produto de nossa loja virtual e, portanto, o valor total de sua compra é de <span> R$0,00 </span></p>");
 }

 $produtosComprados = $_POST['produtos'];

 foreach($produtosComprados as $indice => $produto){
  $valorTotalCompra += $vetorPrecos[$produto];
 }

 $desconto = 0;
 if(isset($_POST['forma-pagamento'])){
 $desconto = $valorTotalCompra * 0.05;
 }
 $valorTotalCompra = $valorTotalCompra - $desconto;
 $valorTotalCompraFormatada = number_format($valorTotalCompra, 2, ',', '.');
 echo"<p> Caro usuário, de acordo com os produtos adquiridos, o valor final da sua compra é de R$$valorTotalCompraFormatada <br>
 Confira, abaixo, a lista de produtos comprados <br><ul>";

 // Para mostrar os produtos adquiridos, basta usar o foreach no vetor de produtos comprados 

 foreach($produtosComprados as $produto){
  echo"<li> $produto </li>";
 }
 echo"</ul></p>";
 ?>
</body>
</html>