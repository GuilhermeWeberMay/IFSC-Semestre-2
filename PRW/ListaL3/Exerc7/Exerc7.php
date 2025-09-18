<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Matrizes PHP </title>
</head>
<body>
 <h1> Matrizes em PHP - ListaL3 - Exerc7 </h1>
 <h2> Resposta Servidor </h2>

 <?php

 function saidaVetor($vetor){
  echo"<pre>";
  print_r($vetor);
  echo"</pre>";
 }
 function saida ($variavel1){
  echo"<p> $variavel1 </p>";
 }

 $codigo = $_POST['codigo'];
 $nome   = $_POST['nome'];
 $preco  = $_POST['preco'];

 // a)Armazene estes dados em uma estrutura matricial. Use o código do medicamento como índice associativo;
 $matrizMedicamento = [$codigo => array($nome, $preco)];

 // b) Mostre os dados de todos os medicamentos cadastrados na matriz no formato tabular;
 echo"<table>
       <tr>
        <td> Código </td>
        <td> Nome </td>
        <td> Valor </td>
       </tr>";
 foreach($matrizMedicamento as $codigoMedicamento => $vetorInterno){
  echo"<tr>
        <td>$codigoMedicamento</td>
        <td>$vetorInterno[0]</td>
        <td>$vetorInterno[1]</td>
       <tr>";
 }
 echo"</table>";

 // c) Mostre, na página web, o nome do medicamento MAIS BARATO cadastrado;
 foreach($matrizMedicamento as $codigoMedicamento => $vetorInterno){
  $vetorAuxPreco[$codigoMedicamento] = $vetorInterno[1];
 }

 // Aqui acho o menor valor do vetor e seu indice associativo
 $indiceMenorPreco = array_search(($valorMenorPreco = min($vetorAuxPreco)), $vetorAuxPreco);

 // Com esses dois valores pego o nome do meu medicamento mais barato na matriz
 $nomeMenorPreco = $matrizMedicamento[$indiceMenorPreco][0];

 // Apresentação completa do medicamento com o menor valor
 echo"O código do medicamento com o menor valor é $indiceMenorPreco nome dele é $nomeMenorPreco ele é vendido pelo valor de R$$valorMenorPreco";
 
 // d) Receba, do formulário acima, devidamente modificado, o código de um medicamento qualquer. O script em PHP deverá pesquisar este código na matriz e mostrar todas as informações do respectivo medicamento. Se o mesmo não for encontrado, mostrar uma mensagem apropriada;

 // Primeiro pego o código que foi informado no HTML
 $codigoPesquisado = $_POST['codigo-pesquisado'];

 // Só pode usar array_key_exists() pois o valor pesquisado é o indice associativo, então não precisamos fazer um vetor auxiliar
 $encontrou = array_key_exists($codigoPesquisado, $matrizMedicamento);

 // Apresentação do medicamento pesquisado
 if ($encontrou){
  $nomePesquisado = $matrizMedicamento[$codigoPesquisado][0]; // Aqui eu pego o nome do medicamento pesquisado - pego o valor direto na matriz
  $precoPesquisado = $matrizMedicamento[$codigoPesquisado][1]; // Aqui eu pego o preço do medicamento pesquisado - pego o valor direto na matriz
  echo"<p> O código pesquisado foi $codigoPesquisado o nome do medicamento deste código é $nomePesquisado, vendido por R$$precoPesquisado</p>";
 }else{
  echo"<p> O código pesquisado não está no estoque da farmacia, favor pesquisar um código válido </p>";
 }

 // e) Ordenar os dados de todos os medicamentos por meio do nome do medicamento, em ordem alfabética crescente, e exibir estes dados no formato tabular 
 # ARSORT
 // Primeiro criamos um vetor auxiliar para separarmos os nome mas mantendo o indice associativo
 foreach($matrizMedicamento as $codigoMedicamento => $vetorInterno){
  $vetorAuxNome[$codigoMedicamento] = $vetorInterno[0];
 }

 //Agora vamos organizar o vetor
 arsort($vetorAuxNome);
 
 // Agora vamos apresentar esse vetor na forma tabular
  echo"<table>
       <tr>
        <td> Código </td>
        <td> Nome </td>
        <td> Valor </td>
       </tr>";
 foreach($vetorAuxNome as $codigoMedicamento => $nomeMedicamento){
  $valorTemp = $matrizMedicamento[$codigoMedicamento][1];
  echo"<tr>
        <td>$codigoMedicamento</td>
        <td>$nomeMedicamento</td>
        <td>$valorTemp</td>
       <tr>";
 }
 echo"</table>";





 ?>
</body>
</html>