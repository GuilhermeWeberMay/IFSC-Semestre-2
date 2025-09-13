<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Matrizes em PHP </title>
 <link rel="stylesheet" href="Exerc4.css">
</head>
<body>
 <h3> Matrizes em PHP - ListaL3 - Exerc3 </h3>
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
 
 $alunoPesquisado = $_POST['aluno-pesquisado'];
 $alunoPesquisado = strtoupper($alunoPesquisado);

 // Criando um vetor auxiliar para os nome
 foreach($matrizAlunos as $matricula => $vetorInterno){
  // Aqui o vetor auxiliar recebe como indice associativo a matricula do aluno e como valor o nome do aluno
  $vetorAuxiliar[$matricula] = $vetorInterno[0];
 }

 // Vamos pesquisar pelo nome do aluno no vetor auxiliar com array_search()
 $matriculaEncontrada = array_search($alunoPesquisado, $vetorAuxiliar);

 // Vamos perguntar ao PHP se ele NÃO encontrou o aluno pesquisado no vetor auxiliar
 if(!$matriculaEncontrada){
  exit("<p> Caro usuário o aluno pesquisado de nome <span> $alunoPesquisado </span> NÃO foi encontrado na matriz de alunos. Aplicação encerrada! </p>");
 }
  // Encontramos o aluno na matriz. Vamos acessá-la e recuperar a sua média de PWR1
  $mediaProcurada = $matrizAlunos[$matriculaEncontrada][1];

  // Mostrando resultados
  echo"<p> Resultado da busca do aluno na matriz: <br>
           Aluno procurado: <span> $alunoPesquisado </span> <br>
           Matrícula deste aluno: <span> $matriculaEncontrada </span> <br>
           Média deste aluno: <span> $mediaProcurada </span> <br>
  </p>";
 ?>
</body>
</html>