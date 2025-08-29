<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="Exerc3.css">
 <title> Fundamentos do PHP </title>
</head>
<body>
 <h1> Fundamentos do PHP - Exerc3 - Resposta Servidor </h1>

 <?php 
 // Criando constantes em PHP, na maioria das linguagens de programção é uma boa pratica escrever ela em caixa alta, uma constante so pode ser declarada uma vez e não pode ser alterada no meio do código
 define ("DESCONTO", 10/100); // O PHP tambem pode fazer operações dentro da constante 
 define ("ICMS", 0.12);
 define ("COMISSAO", 0.05);
 $valorVenda = $_GET["valorVenda"];
 $nome = $_GET["nome"];
 // Cálculos
 $desconto = $valorVenda * DESCONTO;
 $icms     = $valorVenda * ICMS    ;
 $comissao = $valorVenda * COMISSAO;
 // No PHP podemos usar o mesmo nome tanto na constante quanto na variavel, ele consegue fazer a ver a difirença.
 // Calculando o valor final da compra do cliente
 $valorFinal = $valorVenda - $desconto; 
 $valorFinalFormatado = number_format($valorFinal, 2, ",");
 $descontoFormatado = number_format($desconto, 2, ",");
 echo "<p> 
       Resultado da venda: <br>
       Valor incial da compra = <span> R$$valorVenda </span> <br>
       Desconto dado ao cliente = <span> R$$descontoFormatado </span> <br>
       ICMS = <span> R$$icms </span> <br>
       Valor da comissão = <span> R$$comissao </span> <br>
       Valor final da compra = <span> R$$valorFinalFormatado </span> <br>
       Taxa do ICMS cobrado = <span>" . ICMS , "</span> <br>
       </p>
 ";
 // ",ICMS," - é como mostrar uma constante em PHP, pode ser usado tanto . quanto ,
 ?>
</body>
</html>