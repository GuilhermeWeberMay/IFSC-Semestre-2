<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="Exerc2.css">
 <title> Fundamentos do PHP </title>
</head>
<body>
 <h1> Fundamentos do PHP - Exerc2 - Resposta Servidor</h1>
 <?php
 $consumo = $_POST["consumo"];
 $distancia = $_POST["distancia"];
 $precoLitro = $_POST["precoLitro"];
 $qtdLitros; $valorFinal;

 $qtdLitros = $distancia / $consumo;
 $valorFinal = $precoLitro * $qtdLitros;
 // Formatação das saídas
 $valorFinalFormatado = number_format($valorFinal, 2, ",");
 $qtdLitrosFormatado = number_format($qtdLitros, 1, ",");

 echo "<p> Você tera um  gasto de <span> $valorFinalFormatado </span> e o total de litros de gasolina consumido ira ser de <span> $qtdLitrosFormatado </span> e o valor pago por litro é de <span> $$precoLitro </span> </p>"

 ?>
 </form>
</body>
</html>