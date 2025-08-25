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
 <h1> Fundamentos do PHP - Exerc4 - Respota servidor </h1>
 <?php 
 $fahrenheit = $_POST["fahrenheit"];
 $celsius = ($fahrenheit - 32) * 5 / 9;
 $celsiusFormatado = number_format("$celsius", 1, ".");
 echo "<p> Resultado final: <br>
       $celsiusFormatado </p>";
 ?>
</body>
</html>