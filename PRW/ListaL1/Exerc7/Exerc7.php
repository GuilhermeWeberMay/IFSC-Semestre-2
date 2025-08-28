<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="Exerc7.css">
</head>
<body>
 <h1> Fundamentos do PHP - Exerc7 - Resposta Servidor </h1>

 <?php
 $valorCompra = $_POST['valor-compra'];

 // Testar se o botões de rádio foram marcados
 if(!isset($_POST['forma-pagamento'])){
 exit("<p><span> Erro fatal</span>: A forma de pagamento deve ser fornecida. Aplicação encerrada! </p>");
 }
 define("TAXA_DESCONTO", 0.05);
 define("TAXA_ACRESCIMO", 0.02);

 // Descobrindo se o cliente pagou à vista ou a prazo
 $formaPagamento = $_POST['forma-pagamento'];

 $desconto = 0;
 if($formaPagamento == 'avista'){
  $desconto = $valorCompra * TAXA_DESCONTO;
  $acresicmo = 0;
 }else{
  $acresicmo = $valorCompra * TAXA_ACRESCIMO;
  $desconto = 0;
 }

 // Calculando o valor final da compra
 $valorFinal = $valorCompra + $acresicmo - $desconto;

 // Descobrindo se o cliente pagou com o cartão
 $sorteio = " o cliente NÃO está participando do sorteio ";
 if(isset($_POST['cartaovisa'])){
  $sorteio = " o cliente está participando do sorteio ";
 }

 $valorCompraFormatada = number_format($valorCompra, 2, ',', '.');
 $valorFinalFormatado = number_format($valorFinal, 2, ',', '.');
 $descontoFormatado = number_format($desconto, 2, ',', '.');
 $acrescimoFormatado = number_format($acresicmo, 2, ',', '.');

  echo "<p> Resultado do processamento da compra: <br>

           Valor inicial da compra = <span> R$$valorCompraFormatada </span> <br>

           Valor do desconto = <span> R$$descontoFormatado </span> <br>

           Valor do acrésimo = <span> R$$acrescimoFormatado </span> <br>

           Valor final da compra = <span> R$$valorFinalFormatado </span> <br>

           Situação do sorteio = <span> $sorteio </span> <br>
 </p>";
 ?>
</body>
</html>