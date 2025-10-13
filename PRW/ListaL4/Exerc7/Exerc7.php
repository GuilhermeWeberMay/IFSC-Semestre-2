<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
 <link rel="stylesheet" href="Exerc7.css">
</head>
<body>
 <h1> Funções de usuário em PHP - Exercicio 3 </h1>
 <form action="Exerc7.php" method="post">
  <fieldset>
    <legend> Conversão de escalas termométricas </legend>

    <label for="temperatura" class="alinha"> Informe a temperatura: </label>
    <input type="number" name="temperatura" id="temperatura" autofocus step='0.1' require><br>

    <label for="escala">Escoclha a escala de transformação: </label> <br>
    <input type="radio" name="escala" id="escala" value="0"> <label> Converter de Fahrenheit para Celsius </label><br>
    <input type="radio" name="escala" id="escala" value="1"> <label> Converter de Celsius para Fahrenheit </label>

    <button name="cadastrar" > Cadastrar </button>
   </fieldset>
 </form>

 <?php

 require "Exerc7.inc.php";

 if(isset($_POST['cadastrar'])){
  $escala = $_POST['escala'];
  $temperatura = $_POST['temperatura'];

  if($escala == "0"){
   converteDeFparaC($temperatura);
  }else{
   converteDeCparaF($temperatura);
  }
 }
 
 ?>
</body>
</html>