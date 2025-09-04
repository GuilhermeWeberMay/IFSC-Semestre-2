<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc4.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc4 - Servidor</h1>

 <?php
 // Vamos criar o vetor de preços manualmente
 $vetorPrecos = ['impressora' => 1000,
                 'placaVideo' => 1500,
                 'teclado' => 100     ];

 // Começando o processamento para calcular o valor total da compra efetuada pelo cliente

 // Testando se o cliente não comprou nada
 $valorTotalCompra = 0;
 if (!isset($_POST['produtos'])){
  exit("<p> Caro usuário, você não adquiriu nenhum produto de nossa loja virtual e, portanto, o valor total de sua compra é de <span> R$0,00 </span></p>");
 }

 // Agora precisamos descobrir quais produtos foram adquiridos pelo cliente. Vamos receber os produtos selecionados nos checkbox e guardá-los em uma variável

 $produtosComprados = $_POST['produtos'];

 // Para obtermos o valor total da compra, precisamos percorrer, inicialemente, o vetor de produtos comprados, com foreach

 foreach($produtosComprados as $indice => $produto){
  $valorTotalCompra += $vetorPrecos[$produto];
 }
 echo"<p> Caro usuário, de acordo com os produtos adquiridos, o valor final da sua compra é de R$$valorTotalCompra <br>
 Confira, abaixo, a lista de produtos comprados <br><ul>";

 // Para mostrar os produtos adquiridos, basta usar o foreach no vetor de produtos comprados 

 foreach($produtosComprados as $produto){
  echo"<li> $produto </li>";
 }
 echo"</ul></p>";
 ?>
</body>
</html>