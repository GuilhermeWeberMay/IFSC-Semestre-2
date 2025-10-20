function criarVetor(){

 // Inicializar um vetor null com três posições de memória
 let vetorPessoas = new Array();

 // Vamos criar um laço que se repete 3 vezes para capturarmos os dados de três pessoas da janela de prompt do JavaScript
 for(let i = 0; i < 3; i++){
  let nome = prompt("Digite o nome da "+(i+1)+"ª pessoas");
  let idade = prompt("Digite a idade da "+(i+1)+"ª pessoas");
  vetorPessoas[nome] = idade;
 }

 let objDis = document.getElementById("container");

 let tabela = "<table> <tr> <th> Nome </th> <th> Idade </th> </tr>";

 // Laço especifico em JavaScript para percorrer um vetor com indice associativo
 for(let nomePessoa in vetorPessoas){
  idade = vetorPessoas[nomePessoa];
  tabela = tabela + "<tr> <td>"+ nomePessoa + "</td> <td>"+ idade +"</td> </tr>";
 }
 tabela = tabela + "</table>";

 objDis.innerHTML = tabela;
}
let objButao = document.getElementById("butao");
objButao.addEventListener("click", criarVetor);