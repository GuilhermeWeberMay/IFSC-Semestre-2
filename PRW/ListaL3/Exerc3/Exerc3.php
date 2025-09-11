<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Matrizes em PHP </title>
 <link rel="stylesheet" href="Exerc2.css">
</head>
<body>
 <h3> Matrizes em PHP - ListaL3 - Exerc3 </h3>
 <h3> Resposta Servidor </h3>
 <?php

  $matricula1 = $_POST['matricula1'];
  $matricula2 = $_POST['matricula2'];
  $matricula3 = $_POST['matricula3'];

  $aluno1 = $_POST['aluno1'];
  $aluno2 = $_POST['aluno2'];
  $aluno3 = $_POST['aluno3'];

  $media1 = $_POST['media1'];
  $media2 = $_POST['media2'];
  $media3 = $_POST['media3'];

  // Vamos criar a matriz
  $matrizAlunos = [$matricula1 => array($aluno1, $media1),
                  $matricula2 => array($aluno2, $media2),
                  $matricula3 => array($aluno3, $media3)
 ];
 
 // Vamos mostrar os dados do aluno que apresenta a maior nota. Para isso criaremos um vetor auxiliar e iremos ordenar este vetor pela nota
 foreach($matrizAlunos as $matricula => $vetorInterno){
   $vetorNotas[$matricula] = $vetorInterno[1];
 }

 //  Descobrimos a maior nota
 $maiorNota = max($vetorNotas);

 // Descobrimos a matrícula do aluno com a maior nota
 $matriculaMelhorAluno = array_search($maiorNota, $vetorNotas);
 
 // Descobrimos o nome do melhor aluno
 $alunoMaiorNota = $matrizAlunos[$matriculaMelhorAluno][0];

 $maiornotaFormatada = number_format($maiorNota, 1, ",", ".");

 echo"<p> Resultado do processamento dos dados da matriz: <br>
 Maior nota:$maiorNota <br>
 Matricula: $matriculaMelhorAluno <br>
 Aluno: $alunoMaiorNota</p>";
 ?>
</body>
</html>