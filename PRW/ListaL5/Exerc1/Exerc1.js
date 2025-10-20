function criarVetor(){
 // Criando o vetor de idades - primeira forma
 let vetorIdades = [48, 72, 61, 89, 26, 33, 27, 21, 60, 94]; 

 // Criando o vetor de idades - segunda forma
 vetorIdades = new Array(48, 72, 61, 89, 26, 33, 27, 21, 60, 94);

 let objDis = document.getElementById("container");

 let tabela = "<table> <tr> <th> Idades aleatórias </th> </tr>";

 let i;
 for(i = 0; i < vetorIdades.length; i++){
  tabela = tabela + "<tr> <td>"+ vetorIdades[i] +" </tr> </td> ";
 }
 tabela = tabela + "</table>";

 objDis.innerHTML = tabela;


}






let objButao = document.getElementById("butao");
objButao.addEventListener("click", criarVetor);