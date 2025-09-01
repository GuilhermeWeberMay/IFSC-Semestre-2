<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc1.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc1 </h1>
 <?php

 $nota1 = $_POST['nota1'];
 $nota2 = $_POST['nota2'];
 $nota3 = $_POST['nota3'];

 // Criando um vetor em PHP a partir das três variáveis escalares
 $vetorNotas = [$nota1, $nota2, $nota3];
 // Misturar os tipos de dados NÃO é uma boa prática, por mais que a linguagem permita

 // Somando as três notas do vetor
 $soma = array_sum($vetorNotas);
 // O PHP somente irá usar o array_sum quando os todas as casas forem números 

 // Calculando a média de notas do vetor
 $media = $soma / count($vetorNotas);
 // COUNT é responsavel por contar quantos indices tem o vetor 

 $mediaFormatada = number_format($media, 1, ",", ".");
 echo "<p> A média de nota dos 3 alunos = <span> $mediaFormatada </span> </p>"
 ?>
</body>
</html>