<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Matrizes em PHP </title>
 <link rel="stylesheet" href="Exerc6.css">
</head>
<body>
 <h3> Matrizes em PHP - ListaL3 - Exerc6 </h3>
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

  // Vamos criar a matriz, lembrando que matrícula é o índice do vetor
  $matrizAlunos = [$matricula1 => array($aluno1, $media1),
                  $matricula2 => array($aluno2, $media2),
                  $matricula3 => array($aluno3, $media3)
 ];

 // Vamos criar um vetor auxiliar, contendo as notas de cada aluno e o seu número de matrícula como índice
 foreach($matrizAlunos as $matricula => $vetorInterno){
  $vetorAux[$matricula] = $vetorInterno[1];
 }

 // Ordenamos o vetor auxiliar com a função arsort()
 arsort($vetorAux);

  echo"<table>
       <caption> Ordenação dos dados do aluno de PRW-I</caption>
       <tr>
        <th> Matricula do aluno </th>
        <th> Nome do aluno </th>
        <th> Média do aluno </th>
       </tr>";
 foreach ($vetorAux as $matricula => $mediaPRW1){
  $aluno = $matrizAlunos[$matricula][0];
  echo "<tr>
         <td>$matricula</td>
         <td>$aluno</td>
         <td>$mediaPRW1</td>
        </tr>";
 }
 
 echo "</table>";

 ?>
</body>
</html>