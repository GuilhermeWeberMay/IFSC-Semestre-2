<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc7.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc7 </h1>
 <?php

 $idade1 = $_POST['idade1'];
 $idade2 = $_POST['idade2'];
 $idade3 = $_POST['idade3'];
 $aluno1 = $_POST['aluno1'];
 $aluno2 = $_POST['aluno2'];
 $aluno3 = $_POST['aluno3'];

 $vetorIdade = [$aluno1 => $idade1, 
                $aluno2 => $idade2, 
                $aluno3 => $idade3];

 ksort($vetorIdade);
 echo"<table>
       <caption> Idade e nomes das pessoas</caption>
       <tr>
        <th> Nome da pessoa </th>
        <th> Idade da pessoa </th>
       </tr>";

 foreach ($vetorIdade as $aluno => $idade){
  echo "<tr>
         <td>$aluno</td>
         <td>$idade</td>
        </tr>";
 }
 // Finalizado a tag table depois do laço
 echo "</table>";
 
 ?>
</body>
</html>