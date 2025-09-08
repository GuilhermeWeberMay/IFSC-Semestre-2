<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc6.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc6 </h1>
 <?php

 $idade1 = $_POST['idade1'];
 $idade2 = $_POST['idade2'];
 $idade3 = $_POST['idade3'];
 $aluno1 = $_POST['aluno1'];
 $aluno2 = $_POST['aluno2'];
 $aluno3 = $_POST['aluno3'];

 // Criando um vetor de notas dos alunos, armazenando seus nomes no indice associativo, só funciona com uma tabela de duas colunas
 $vetorIdade = [$aluno1 => $idade1, 
                $aluno2 => $idade2, 
                $aluno3 => $idade3];

 // Percorrendo o vetor com o laço especial FOREACH e mostrar os dados no formato tabulado
 // Criação do cabeçalho - antes do laço para não repetir durante o laço 
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

 // Achando a menor idade e seu indice associativo
 $nomeMenorIdade = array_search($menorIdade = min($vetorIdade), $vetorIdade);

 echo "<p>Resultado da busca no vetor: <br>
          Aluno com menor nota cadastrada<br>
          Aluno: $nomeMenorIdade <br>
          Idade: <span> $menorIdade </span> anos </p>"
 
 ?>
</body>
</html>