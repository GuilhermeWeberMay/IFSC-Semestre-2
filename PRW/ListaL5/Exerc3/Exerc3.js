function criarVetor(){

 const objSumir = document.getElementById("sumir");

 objSumir.style.display = "none";
 // Criando o vetor de idades - primeira forma
 let vetorPrecos = [12750.60, 28720.97, 145000.00, 879678.56]; 

 let objDis = document.getElementById("container");

 let tabela = "<table> <tr> <th> Preços de automóveis aleatórios </th> </tr>";

 let i;
 for(i = 0; i < vetorPrecos.length; i++){
  tabela = tabela + "<tr> <td> R$"+ vetorPrecos[i] +" </tr> </td> ";
 }
 tabela = tabela + "</table>";

 objDis.innerHTML = tabela;

}

let objButao = document.getElementById("butao");
objButao.addEventListener("click", criarVetor);