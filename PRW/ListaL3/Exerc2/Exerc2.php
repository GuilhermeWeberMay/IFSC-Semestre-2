<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Matrizes em PHP </title>
 <link rel="stylesheet" href="Exerc2.css">
</head>
<body>
 <h3> Matrizes em PHP - ListaL3 - Exerc1 </h3>
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
 
 // Vamos calcular a média de notas da turma. Antes disso criaremos um vetor auxiliar, contendo apenas as notas dos alunos, para podermos utilizar o comando array_sum();
 
 foreach($matrizAlunos as $matricula => $vetorInterno){
  $vetorAux[] = $vetorInterno[1];
  // O número 1 está ali para ele pegar somente a coluna da matriz 1
 }

 $media = array_sum($vetorAux) / count($vetorAux);

 $mediaFormatada = number_format($media, 1 , ",", ".");

 echo"<p> De acordo com as notas fornecidas, a média geral da turma é <span> $mediaFormatada </span> </p>";

  echo"<table>
       <caption> Rendimento semestral do aluno de PRW-I</caption>
       <tr>
        <th> Matricula do aluno </th>
        <th> Nome do aluno </th>
        <th> Média do aluno </th>
       </tr>";
 foreach ($matrizAlunos as $matricula => $vetorInterno){
  echo "<tr>
         <td>$matricula</td>
         <td>$vetorInterno[0]</td>
         <td>$vetorInterno[1]</td>
        </tr>";
 }
 
 echo "</table>";


 ?>
</body>
</html>