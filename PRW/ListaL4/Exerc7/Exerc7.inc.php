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
