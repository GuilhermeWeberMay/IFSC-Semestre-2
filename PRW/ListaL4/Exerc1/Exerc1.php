<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Funções de usuário - PHP - Subprogramação </title>
 <link rel="stylesheet" href="formata-form.css">
</head>
<body>
 <h1> Funções de usuário em PHP - Exerc1 - ListaL4</h1>

 <form action="Exerc1.php" method="post">
  <fieldset>
   <legend> CTDS - PRW1 - Rendimento semestral do aluno </legend>

   <label for="nome" class="alinha"> Nome: </label>
   <input type="text" name="nome" id="nome" autofocus><br>

   <label for="nota1" class="alinha"> Nota 1: </label>
   <input type="number" name="nota1" id="nota1" min="0" max="10" step="0.01"> <br>

   <label for="nota2" class="alinha"> Nota 2: </label>
   <input type="number" name="nota2" id="nota2" min="0" max="10" step="0.01"> <br>

   <button name="enviar" > Cadastrar dados do aluno usando funções </button>
  </fieldset>
 </form>

 <?php
 
 // Vamos definir, nesse local do arquivo, devemos fazer o PHP testar se o botão submit foi precissionado
 function saida ($variavel1){
  echo"<p>$variavel1</p>";
 }
 // Smepre usado nos INPUT'S com tipo TEXT ou similares
 function testarNome($subNome){
  // Vamos retirar espaços em branco adicionados na caixa nome do formulário
  $subNome = trim($subNome); // Retira os espaços em branco 

  // Vamos contar o número da carateres restantes dentro da variável aluno
  if(strlen($subNome) == 0){
   exit("<p> Nome de aluno inválido, aplicação encerrada! </p>");
  }

 }

 function calcularMedia ($subNota1, $subNota2){
  $subMedia = ($subNota1 + $subNota2) / 2;
  $subMediaFormatada = number_format($subMedia, 1, ",", ".");
  return $subMediaFormatada;
 }

 function situacaoAluno ($subMedia){
  if ($subMedia >= 6){
   echo"<p> Aluno APROVADO! Com média <span> $subMedia </span> </p>";
  }else {
   echo"<p> Aluno REPROVADO! Com média <span> $subMedia </span> </p>";
  }
 }
 //========================================================================================

 // Como estamos misturando formulário com processamento em PHP em um único arquivo, devemos fazer o PHP testar se o botão submit foi pressionado
 if(isset($_POST["enviar"])){
  
  $nome = $_POST['nome'];
  $nota1 = $_POST['nota1'];
  $nota2 = $_POST['nota2'];
  
  // Invocar a função se o nome fornecido no formulário é válido
  testarNome($nome); // Nome de funções o PHP não é sensetive case
  
  // Invocar a função para calcular a média do aluno
  $media = calcularMedia($nota1, $nota2);

  // Invocar uma função que para mostrar a média e se o aluno está aprovado ou não
  situacaoAluno($media);
 }
 
 ?>
</body>
</html>