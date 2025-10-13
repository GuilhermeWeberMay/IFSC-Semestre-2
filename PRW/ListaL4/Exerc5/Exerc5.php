<!DOCTYPE html>
<html lang="pt-BR">

<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Funções de usuário na linguagem PHP - subprogramação </title>
 <link rel="stylesheet" href="Exerc5.css">
</head>

<body>
 <h1> Funções de usuário em PHP - Exercício 5 </h1>

 <form action="Exerc5.php" method="post">
  
  <label for="nota1">Nota 1:</label>
  <input type="number" id="nota1" name="nota1" step="0.1" required min="0" max="10"> <br>

  <label for="nota2">Nota 2:</label>
  <input type="number" id="nota2" name="nota2" step="0.1" required min="0" max="10"> <br>

  <button name="calcular"> Calcular média </button>
 </form>
 <?php

 if (isset($_POST['calcular'])) {

  include "calculaMedia.inc.php";
  include "validaSituacao.inc.php";

  $nota1 = $_POST['nota1'];
  $nota2 = $_POST['nota2'];

  $media =  calcularMedia($nota1, $nota2);
  $situacao = validaSituacao($media);
  $media = number_format($media, 1, ",", ".");
  echo "<p class=resultado>$situacao e $media</p>";
 }
 ?>
</body>

</html>