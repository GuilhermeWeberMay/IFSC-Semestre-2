<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos PHP </title>
 <link rel="stylesheet" href="Exerc8_2.css">
</head>
<body>
 <h1> Fundamentos do PHP - Exerc8 - Resposta Servidor</h1>
 <?php
 $valorCompra = $_POST['valorCompra'];

 // Verificação - para o servidor não aceitar os botões de rádio vazio
 if(!isset($_POST['idade'])){
  exit("<p><span>Erro fatal:</span> Você deve informar a idade do cliente </p>");
 }
 // Verificação - para saber se o cliente ganha desconto de acordo com a idade
 $idade = $_POST['idade'];
 $desconto = 0;

 if($idade == '55-70'){
  $desconto = $valorCompra * 0.05;
 }else if($idade == '70') {
  $desconto = $valorCompra * 0.07;
 }
 // Verificação - para saber se o cliente pagou com o cartão fidelidade
 $descontoCartao = 0; 
 if(isset($_POST['cartao'])){
  $descontoCartao = $valorCompra * 0.05;
 }

 // Calculo final
 $valorFinal = $valorCompra - $desconto - $descontoCartao;
 // Formatação dos valores
 $valorCompraFormatada = number_format($valorCompra, 2, ',','.');
 $descontoFormatado = number_format($desconto, 2, ',','.');
 $descontoCartaoFormatado = number_format($descontoCartao, 2, ',','.');
 $valorFinalFormatada = number_format($valorFinal, 2, ',','.');
 // Apresentação de resultados finais
 echo"<p> Valor da compra: R$$valorCompraFormatada <br>
          Desconto por idade: R$$descontoFormatado <br>
          Desconto por cartão finalidade: R$$descontoCartaoFormatado <br>
          Valor final ao cliente: <span>R$$valorFinalFormatada</span>
 </p>";
 ?>
</body>
</html>