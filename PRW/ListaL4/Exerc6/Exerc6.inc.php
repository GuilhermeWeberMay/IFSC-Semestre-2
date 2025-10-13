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
// Continua funcionando sem o ? > e os autores modernos indicam para deixar sem para se tiver que adicionar uma função não precisara colocar para baixo