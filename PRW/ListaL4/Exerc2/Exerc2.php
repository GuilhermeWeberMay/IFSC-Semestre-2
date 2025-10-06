<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
 <link rel="stylesheet" href="Exerc2.css">
</head>
<body>
 <h1> Funções de usuário em PHP - Exercicio 2</h1>
 <form action="Exerc2.php" method="post">
  <fieldset>
    <legend> Cadastro de idades </legend>

    <label for="idade" class="alinha"> Idade: </label>
    <input type="number" name="idade" id="idade" autofocus step='1' ><br>

    <button name="cadastrar" > Cadastrar </button>
   </fieldset>
 </form>

 <?php
 function validarIdade ($idade){
  // Aqui usamos a função para validar a idade 
  $valorTestado = filter_var($idade, FILTER_VALIDATE_INT);

  // Testando o erro na validação
  if($valorTestado === false OR $idade < 0){
   exit("<p> Caro usuário, forneça uma idade válida. Aplicação encerrada! </p>");
  }
 }
 //===================================================================================================
 function podeVotar($idade){
  if($idade >= 16){
   echo"<p> A pessoa tem <span> $idade </span> anos e pode votar. </p>";
  }else{
   echo"<p> A pesso tem <span> $idade </span> anos e NÃO pode votar. </p>";
  }
 }

 if(isset($_POST['cadastrar'])){
  $idade = $_POST['idade'];
  validarIdade($idade);
  podeVotar($idade);
 }
 ?>
</body>
</html>