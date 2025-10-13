<!DOCTYPE html>
<html lang="en">

<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
 <link rel="stylesheet" href="Exerc8.css">
</head>

<body>
 <h1> Matrizes em PHP - ListaL4 - Exerc8 </h1>
 <form action="Exerc8.php" method="post">

  <legend> Calculo de média com includes em PHP</legend>

  <label for="nota1"> Nota 1: </label>
  <input type="number" name="nota1" id="nota1" autofocus required step="0.1"><br>

  <label for="nota2"> Nota 2: </label>
  <input type="number" name="nota2" id="nota2" required><br>

  <label for="nota3"> Nota 3: </label>
  <input type="number" name="nota3" id="nota3" required><br>

  <input type="radio" name="opcao" id="" value="0"> <label for=""> Média aritmética </label> <br>

  <input type="radio" name="opcao" id="" value="1"> <label for=""> Média ponderada </label> <br>

  <button name="calcular"> Calcular média</button>


  <?php
  require "Exerc8.inc.php";
  if (isset($_POST['calcular'])) {
   $nota1 = $_POST['nota1'];
   $nota2 = $_POST['nota2'];
   $nota3 = $_POST['nota3'];

   $opcao = $_POST['opcao'];

   if ($opcao == '1') {
    $media = mediaPonderada($nota1, $nota2, $nota3);
   } else {
    $media = mediaAritmetica($nota1, $nota2, $nota3);
   }

   $situacao = situacaoAluno($media);
   $media = number_format($media, 1, ",", ".");

   echo "<p> Primeira nota: $nota1 <br>
   Segunda nota: $nota2 <br>
   Terceira nota: $nota3 <br>
   Sua média é: $media <br>
   Situação do aluno: $situacao
   </p>";
  }
  ?>
</body>

</html>