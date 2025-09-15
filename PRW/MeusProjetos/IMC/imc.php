<!DOCTYPE html>
<html lang="pt-BR">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title> Calcule seu IMC </title>
</head>
<body>
 <h3> Calculadora de IMC - Respota servidor</h3>
 <?php

 // ÍNICIO - VETOR
 /*$nome = $_POST['nome'];
 $peso = $_POST['peso'];
 $altura = $_POST['altura'];

 // Caluclo IMC
 $imc = $peso / ($altura * $altura);

 echo"$imc";*/
 // FIM - VETOR

 // ÍNICIO - MATRIZ
 // Pegando informações dos input's

 $nome1 = $_POST['nome1'];
 $nome2 = $_POST['nome2'];
 $nome3 = $_POST['nome3'];

 $peso1 = $_POST['peso1'];
 $peso2 = $_POST['peso2'];
 $peso3 = $_POST['peso3'];

 $altura1 = $_POST['altura1'];
 $altura2 = $_POST['altura2'];
 $altura3 = $_POST['altura3'];

 // Criando a matriz
 $matrizIMC = [$nome1 => array($peso1, $altura1),
               $nome2 => array($peso2, $altura2),
               $nome3 => array($peso3, $altura3),
                                                 ];
 
 foreach($matrizIMC as $matrizNome => $vetorInterno){
   $vetorAuxPeso[$matrizNome] = $vetorInterno[0];
   $vetorAuxAltura[$matrizNome] = $vetorInterno[1];
 }
 // Usar os dois vetores auxiliares para calcular 
 // foreach para qualquer um dos dois com terceiro vetor
 // Pode calcular tudo dentro de um foreach somente 
 echo"<pre>";
 print_r($vetorAuxAltura);
 echo"</pre>";
 echo"<pre>";
 print_r($vetorAuxPeso);
 echo"</pre>";

 // FIM - MATRIZ
 ?>
</body>
</html>