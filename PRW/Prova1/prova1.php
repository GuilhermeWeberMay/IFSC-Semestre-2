<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Prova 1 </title>
 <link rel="stylesheet" href="prova1.css">
</head>
<body>
 <form action="prova1.php" method="post">
  <fieldset>
   <fieldset>
    <legend> CTDS - PRW1 - Carro 1 </legend>

    <label for="codigo1" class="alinha"> Código: </label>
    <input type="number" name="codigo1" id="codigo1" autofocus><br>

    <label for="fabricante1" class="alinha"> Marca: </label>
    <input type="text" name="fabricante1" id="fabricante1"> <br>

    <label for="preco1" class="alinha"> Preço: </label>
    <input type="number" name="preco1" id="preco1" min="0" step="0.01"> <br>

    </fieldset>

    <fieldset>
    <legend> CTDS - PRW1 - Carro 2 </legend>

    <label for="codigo2" class="alinha"> Código: </label>
    <input type="number" name="codigo2" id="codigo2"><br>

    <label for="fabricante2" class="alinha"> Marca: </label>
    <input type="text" name="fabricante2" id="fabricante2"> <br>

    <label for="preco2" class="alinha"> Preço: </label>
    <input type="number" name="preco2" id="preco2" min="0" step="0.01"> <br>

    </fieldset>

    <fieldset>
    <legend> CTDS - PRW1 - Carro 3 </legend>

    <label for="codigo3" class="alinha"> Código: </label>
    <input type="number" name="codigo3" id="codigo3"><br>

    <label for="fabricante3" class="alinha"> Marca: </label>
    <input type="text" name="fabricante3" id="fabricante3"> <br>

    <label for="preco3" class="alinha"> Preço: </label>
    <input type="number" name="preco3" id="preco3" min="0" step="0.01"> <br>

    </fieldset>
    <button name="enviar" > Cadastrar dados do carro </button>
  </fieldset>
 </form>

 <?php
 function saidaVetor($nomeVetor){
  echo"<pre>";
  print_r($nomeVetor);
  echo"</pre>";
 }

 function apresentacaoMatriz($nomeMatriz){
  echo"<table>
       <caption> Tabela de apresentação dos carros</caption>
       <tr>
        <th> Código </th>
        <th> Marca </th>
        <th> Valor </th>
       </tr>";
 foreach ($nomeMatriz as $codigo => $vetorInterno){
  echo "<tr>
         <td>$codigo</td>
         <td>$vetorInterno[0]</td>
         <td>$vetorInterno[1]</td>
        </tr>";
 }
 
 echo "</table>";
 }

 function saidaPadrao ($valorVariavel){
  echo"<p> $valorVariavel </p>";
 }

 if(isset($_POST["enviar"])){

  // Criação da matriz com o código como indice associativo
  $codigo1 = $_POST['codigo1'];
  $codigo2 = $_POST['codigo2'];
  $codigo3 = $_POST['codigo3'];

  $fabricante1 = $_POST['fabricante1'];
  $fabricante2 = $_POST['fabricante2'];
  $fabricante3 = $_POST['fabricante3'];

  $preco1 = $_POST['preco1'];
  $preco2 = $_POST['preco2'];
  $preco3 = $_POST['preco3'];


  $matrizCarros = [
   $codigo1 => array($fabricante1, $preco1),
   $codigo2 => array($fabricante2, $preco2),
   $codigo3 => array($fabricante3, $preco3)
 ];

 apresentacaoMatriz($matrizCarros);

 foreach ($matrizCarros as $codigoCarro => $vetorInterno){
  $vetorAuxPrecos[$codigoCarro] = $vetorInterno[1];
 }
 // Acha menor valor do carro
 $menorPreco = min($vetorAuxPrecos);
 $indice = array_search($menorPreco,$vetorAuxPrecos);
 
 $fabricanteMenor = $matrizCarros[$indice][0];

 echo"<p> O código do veículo mais BARATO é: $indice <br>
          A marca do veículo mais BARATO é : $menorPreco<br>
          O valor do veículo mais BARATO é : $fabricanteMenor<br>
 </p>";
 }
 ?>
 
</body>
</html>