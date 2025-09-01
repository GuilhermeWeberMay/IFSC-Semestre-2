<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link rel="stylesheet" href="Exerc1.css">
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

 // Exibindo o conteúdo do vetor na página web - mas somente para desenvolvedores não para usuários
 print_r($vetorNotas);
 ?>
</body>
</html>