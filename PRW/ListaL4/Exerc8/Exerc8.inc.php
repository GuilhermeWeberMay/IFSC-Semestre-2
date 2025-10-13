<?php
function mediaAritmetica ($nota1, $nota2, $nota3){
 return ($nota1 + $nota2 + $nota3) / 3;
}
//=================================================
function mediaPonderada ($nota1, $nota2, $nota3){
 return ($nota1 * 5 + $nota2 * 3 + $nota3 * 2) / 10;
}
//=================================================
function situacaoAluno($media){
 if($media > 6){
  $situacao = "Aluno aprovado!";
 }else{
  $situacao = "Aluno reprovado!";
 }
 return $situacao;
}