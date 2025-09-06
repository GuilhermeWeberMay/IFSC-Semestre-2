<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="Exerc5.css">
 <title> Fundamentos do PHP </title>
</head>
<body>
 <h1> Fundamentos do PHP - Exerc5 - resposta servidor </h1>
 <?php
 $valorCompra = $_POST["valor-compra"];
 // Teste se os botões de rádio foram marcados
 if (!isset($_POST["cartao"])){// PHP aceita um metodo dentro de if se retornar um valor booleano
 // Se o PHP entrar dentro deste IF, significa que o usuário não selecionou nenhum dos dois botões relacionados ao pagamento com cartão. Erro fatal: encerramos a aplicação com uma mensagem adequada.
 exit("<p><span> Erro fatal </span>: A forma de pagamento deve ser fornecida. Aplicação encerrada! </p>");
 }
 // Validação do segundo botão
 if (!isset($_POST["entrega"])){
 exit("<p><span> Erro fatal </span>: A entrega deve ser fornecida. Aplicação encerrada! </p>");
 }
 // Declaração de uma constante
 define("TAXA_DESCONTO", 5/100);
 define("TAXA_ACRESCIMO", 0.02);

 // Descobrindo se o cliente pagou com cartão ou não
 $pagouComCartao = $_POST['cartao'];
 // PHP diferencia letras maiusculas de minusculas - Sensetive Case
 $desconto = 0;
 // SE houver desconto o valor muda na variavel 
 if($pagouComCartao == 'sim'){
  $desconto = $valorCompra * TAXA_DESCONTO;
 }

 // Descobrindo se o cliente solicitou entrega a domicilio ou não
 $solicitouEntrega = $_POST['entrega'];
 $acrescimo = 0;
 // SE houver desconto o valor muda na variavel 
 if($solicitouEntrega == 'sim'){
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