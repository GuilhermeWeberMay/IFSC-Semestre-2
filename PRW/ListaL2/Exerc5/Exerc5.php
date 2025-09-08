<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc5.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc5 </h1>
 <?php

 $idade1 = $_POST['idade1'];
 $idade2 = $_POST['idade2'];
 $idade3 = $_POST['idade3'];
 // Criando o vetor com indices numéricos
 $vetorIdade = [$idade1, $idade2, $idade3];

 // Somando as três notas do vetor
 $soma = array_sum($vetorIdade);

 // Calculando a média de notas do vetor
 $media = $soma / count($vetorIdade);

 $mediaFormatada = number_format($media, 1, ",", ".");
 echo "<p> A média de nota das 3 idades = <span> $mediaFormatada </span> </p>"; 
 ?>
</body>
</html>