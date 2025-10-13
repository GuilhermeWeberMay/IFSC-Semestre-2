<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
 <link rel="stylesheet" href="Exerc2.css">
</head>
<body>
 <h1> Funções de usuário em PHP - Exercicio 6</h1>
 <form action="Exerc6.php" method="post">
  <fieldset>
    <legend> Cadastro de idades </legend>

    <label for="idade" class="alinha"> Idade: </label>
    <input type="number" name="idade" id="idade" autofocus step='1' ><br>

    <button name="cadastrar" > Cadastrar </button>
   </fieldset>
 </form>

 <?php
 require "Exerc6.inc.php";
 if(isset($_POST['cadastrar'])){
  $idade = $_POST['idade'];
  validarIdade($idade);
  podeVotar($idade);
 }
 ?>
</body>
</html>