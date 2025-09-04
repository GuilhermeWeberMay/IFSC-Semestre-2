<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc2.css">
 <title> Vetores em PHP </title>
</head>
<body>
 <h1> Vetores em PHP - ListaL2 - Exerc1 </h1>
 <?php

 $nota1 = $_POST['nota1'];
 $nota2 = $_POST['nota2'];
 $nota3 = $_POST['nota3'];
 $aluno1 = $_POST['aluno1'];
 $aluno2 = $_POST['aluno2'];
 $aluno3 = $_POST['aluno3'];

 // Criando um vetor de notas dos alunos, armazenando seus nomes no indice associativo, só funciona com uma tabela de duas colunas
 $vetorNotas = [$aluno1 => $nota1, 
                $aluno2 => $nota2, 
                $aluno3 => $nota3];
 // Indice associativo => Conteudo dentro da célula

 /* 
 - Exibindo o conteúdo do vetor na página web - mas somente para desenvolvedores não para usuários

 echo "<pre>";
 print_r($vetorNotas);
 echo "</pre>";

 - Esta tag faz como se fosse o PRINTLN do java, ele quebra uma linha depois de expor o vetor, um <br> do HTML 
 */

 // Percorrendo o vetor com o laço especial FOREACH e mostrar os dados no formato tabulado
 // Criação do cabeçalho - antes do laço para não repetir durante o laço 
 echo"<table>
       <caption> Rendimento semestral do aluno de PRW-I</caption>
       <tr>
        <th> Nome do aluno </th>
        <th> Nota do aluno </th>
       </tr>
      ";

 foreach ($vetorNotas as $aluno => $nota){
 // Não é necessário informar um valor limite para o PHP ele calcula isso sozinho e para sozinho
 // O primeiro valor guarda o indice do vetor
 // O segundo valor guarda o conteudo do vetor
  echo "<tr>
         <td>$aluno</td>
         <td>$nota</td>
        </tr>";
        // Dentro do laço somente colocar as linhas da tabela 
 }
 // Finalizado a tag table depois do laço
 echo "</table>";

 /* 
 Vamos utilizar a função pronta do PHP para encontrar a maior nota dentro do vetor

 $maiorNota = max($vetorNotas);
 
 Nós já temos a maior nota dos alunos cadastrados. Queremos que o PHP descubra o nome deste aluno. Para isso, usamos a função abaixo

 $alunoCaxias = array_search($maiorNota, $vetorNotas)
 */

 // Forma resumida misturando os dois comandos 
 $nomeMaiorNota = array_search($maiorNota = max($vetorNotas), $vetorNotas);

 echo "<p>Resultado da busca no vetor: <br>
          Aluno com maior nota cadastrada = <span> $nomeMaiorNota </span><br> 
          Nota: <span> $maiorNota </span> </p>"
 
 ?>
</body>
</html>