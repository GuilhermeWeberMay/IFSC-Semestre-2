<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Document</title>
 <link rel="stylesheet" href="Exerc3.css">
</head>
<body>
 <h1> Funções de usuário em PHP - Exercicio 3 </h1>
 <form action="Exerc3.php" method="post">
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
 function converteDeFparaC ($temp){
  $tempConvertida = ($temp - 32) * 5 / 9;
  echo"<p> Resultado da conversão termométrica: <br>
           Temperatura ºF = <span> $temp ºF </span> <br>
           Temperatura convertida em °C = <span> $tempConvertida °C </span>
           </p>";
 }
 function converteDeCparaF ($temp){
  $tempConvertida = ($temp * 9 / 5) + 32;
  echo"<p> Resultado da conversão termométrica: <br>
           Temperatura °C = <span> $temp °C </span> <br>
           Temperatura convertida em ºF = <span> $tempConvertida °C </span>
           </p>";
 }


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