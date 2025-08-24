<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
 <link rel="stylesheet" href="Exerc1.css">
 <title> Fundamentos do PHP</title>
</head>
<body>
 <h1> Fundamentos do PHP - Resposta do servidor </h1>
 
 <?php
  # Recebendo os dados do formulário no servidor
  // Colocar entre [] o que esiver no atributo name no HTML5
  $aluno = $_POST["aluno"];
  $nota1 = $_POST["nota1"];
  $peso1 = $_POST["peso1"];
  $nota2 = $_POST["nota2"];
  $peso2 = $_POST["peso2"];
  $media;
  
  // Apresentação das notas e pesos individuais 
  /*
  echo "<p> Nome do aluno: $aluno </p> ";
  echo "<p> Nome do aluno: $nota1 </p> ";
  echo "<p> Nome do aluno: $peso1 </p> ";
  echo "<p> Nome do aluno: $nota2 </p> ";
  echo "<p> Nome do aluno: $peso2 </p> ";
  */
  // Calculo da média ponderada
  $media =  ($nota1 * $peso1 + $nota2 * $peso2) / ($peso1 + $peso2);
  // Utilizando formatação numérica em PHP
  $mediaFormatada = number_format($media, 1, ",",);
  // Se pode fazer calculos com a media formatada então é uma boa pratica formatar ela somente no final 
  // Retorno para o site 
  echo "<p> Resultado do processamento das notas do aluno: <br>
  Nome do aluno: <span> $aluno </span> <br>
  Primeira nota: $nota1 <br>
  Segunda nota: $nota2 <br>
  Media final do aluno: <span> $mediaFormatada </span>
  </p>";
 ?>

</body>
</html>