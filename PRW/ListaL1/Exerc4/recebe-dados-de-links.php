<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Fundamentos do PHP </title>
 <link rel="stylesheet" href="Exerc4.css">
 <title> Fundamentos do PHP </title>
</head>
<body>
 <h1> Fundamentos do PHP - Exerc4 - Respota servidor, tratando dados de links </h1>
 <?php 
 // O recebimento de dados de um link sempre é feito por meio de $_GET
 $fahrenheit = $_GET["fahrenheit"];

 $celsius = ($fahrenheit - 32) * 5 / 9;

 $celsiusFormatado = number_format("$celsius", 1, ",");
 $fahrenheiFormatado = number_format("$fahrenheit", 1, ",");

 echo "<p> Resultado final: <br>
       Temperatura fornecida, em ºF = <span> $fahrenheiFormatado ºF </span> <br>
       Temperatura fornecida, em ºC = <span> $celsiusFormatado ºC </span> </p>";
 ?>
</body>
</html>