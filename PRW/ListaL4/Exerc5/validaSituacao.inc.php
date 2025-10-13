<?php
function validaSituacao ($media){
 if($media > 6){
  $situacao = "Aluno aprovado! Parabéns";
 }else{
  $situacao = "Aluno reprovado! Idiota";
 }
 return $situacao;
}
?>