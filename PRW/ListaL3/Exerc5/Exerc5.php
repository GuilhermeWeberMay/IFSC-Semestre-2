<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Matrizes em PHP </title>
 <link rel="stylesheet" href="Exerc5.css">
</head>
<body>
 <h3> Matrizes em PHP - ListaL3 - Exerc5 </h3>
 <h3> Resposta Servidor </h3>
 <?php

  $matricula1 = $_POST['matricula1'];
  $matricula2 = $_POST['matricula2'];
  $matricula3 = $_POST['matricula3'];

  $aluno1 = strtoupper($_POST['aluno1']);
  $aluno2 = strtoupper($_POST['aluno2']);
  $aluno3 = strtoupper($_POST['aluno3']);

  $media1 = $_POST['media1'];
  $media2 = $_POST['media2'];
  $media3 = $_POST['media3'];

  // Vamos criar a matriz
  $matrizAlunos = [$matricula1 => array($aluno1, $media1),
                  $matricula2 => array($aluno2, $media2),
                  $matricula3 => array($aluno3, $media3)
                  ];
 
 $matriculaPesquisada = $_POST['matricula-pesquisada'];

 // Como estamos pesquisando pela matrícula do aluno, e a matrícula é índice associativo da matriz, não há necessidade de criarmos um vetor auxiliar. Neste caso, usamos uma função pronta de PHP qur pesquisa pelo índice da matriz
 $encontrou = array_key_exists($matriculaPesquisada, $matrizAlunos);

 if($encontrou){
  $aluno = $matrizAlunos[$matriculaPesquisada][0];
  $media = $matrizAlunos[$matriculaPesquisada][1];
  echo"<p> Resultado da busca do aluno na matriz: <br>
           Matrícula procurado: <span> $matriculaPesquisada </span> <br>
           Nome deste aluno: <span> $aluno </span> <br>
           Média deste aluno: <span> $media </span> <br>
  </p>";
 }else{
  echo"<p> Caro usuário a matrícula pesquisada <span> $matriculaPesquisada </span> NÃO foi encontrado na matriz de alunos.</p>";
 }

 ?>
</body>
</html>