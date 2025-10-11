<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aplicação de Vendas</title>
    <link rel="stylesheet" href="Exerc4.css">
</head>
<body>
 <h1>Registro de Venda</h1>

 <form action="#" method="post">
  <fieldset>
   <legend>Lojas GWM</legend>

    <label for="valor-compra">Informe o valor da compra: (R$):</label>
    <input type="number" id="valor-compra" name="valor-compra" step="0.01" min="0" required> <br>

    <label for="percent-comissao">Informe o percenual de comissão do vendedor (%):</label>
    <input type="number" id="percent-comissao" name="percent-comissao" step="0.1" min="0" required> <br> <br>
 
    <input type="checkbox" name="fidelidade"> 
    <label>Marque esta opção se o cliente está pagando com o cartão de fidelidade da loja</label> <br>

    <button name="cadastrar">Calcular Venda</button>
   </fieldset>
 </form>

 <?php
 function calcularComissao ($fValorCompra, $fPercentualComissao){
  return $valorComissao = $fValorCompra * ($fPercentualComissao / 100);
 }
 //=======================================================================
 function calcularDesconto ($fValorCompra){
  define("TAXA_DESC", 5/100);
  $desconto = 0;

  if(isset($_POST["fidelidade"])){
   $desconto = $fValorCompra * TAXA_DESC;
  }
  return $desconto;
 }
 //=======================================================================
 function calcularFinalCompra ($fValorCompra, $fValorDesconto){
  return $valorFinal = $fValorCompra - $fValorDesconto;
 }
 //=======================================================================
 function mostrarResultados($fValorCompra, $fPercentComissao, $fValorComissao, $fValorDesconto, $fValorFinalCompra){
  $fValorCompra = number_format($fValorCompra, 2, ",", ".");
  $fPercentComissao = number_format($fPercentComissao, 2, ",", ".");
  $fValorComissao = number_format($fValorComissao, 2, ",", ".");
  $fValorDesconto = number_format($fValorDesconto, 2, ",", ".");
  $fValorFinalCompra = number_format($fValorFinalCompra, 2, ",", ".");
  
  echo"<p>
  Resultados finais do processamento da compra: <br>
  Valor incial da compra: <span> R$$fValorCompra </span> <br> 
  Percentual de comissão do vendedor: <span> {$fPercentComissao}% </span> <br>
  Valor da comissão do vendedor: <span> R$$fValorComissao </span> <br>
  Valor do desconto do cliente: <span> R$$fValorDesconto </span> <br>
  Valor final da compra: <span> R$$fValorFinalCompra </span> <br>
  </p>";
 }
 //=======================================================================
 if(isset($_POST['cadastrar'])){
  $valorCompra = $_POST['valor-compra'];
  $percentComissao = $_POST['percent-comissao'];

  $valorComissao = calcularComissao($valorCompra, $percentComissao);

  $valorDesconto = calcularDesconto($valorCompra);

  $valorFinalCompra = calcularFinalCompra($valorCompra, $valorDesconto);

  mostrarResultados($valorCompra, $percentComissao, $valorComissao, $valorDesconto, $valorFinalCompra);
 }
 ?>
</body>
</html>
