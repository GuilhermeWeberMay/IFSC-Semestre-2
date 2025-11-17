function clicarButao() {

 let objDiv = document.getElementById("div");

 // Pegando as informações do formulário e colocando em variaveis
 const objPlaca1 = document.getElementById("placa1");
 const objFabricante1 = document.getElementById("fabricante1");
 const objPreco1 = document.getElementById("preco1");

 const objPlaca2 = document.getElementById("placa2");
 const objFabricante2 = document.getElementById("fabricante2");
 const objPreco2 = document.getElementById("preco2");

 // Colocando os valores que foram pegos em variaveis
 let placa1 = objPlaca1.value;
 let fabricante1 = objFabricante1.value;
 let preco1 = parseFloat(objPreco1.value);

 let placa2 = objPlaca2.value;
 let fabricante2 = objFabricante2.value;
 let preco2 = parseFloat(objPreco2.value);

 // Vetor com as informações para colocarmos dentro da matriz
 let vetorCarro1 = [fabricante1, preco1];
 let vetorCarro2 = [fabricante2, preco2];

 let matrizCarros = [];

 // Item A da prova
 matrizCarros[placa1] = vetorCarro1;
 matrizCarros[placa2] = vetorCarro2;

 // Apresentação da matriz em formato tabular - ITEM B
 let cabecalhoTabela = "<table> <caption> Relação dos carros cadastrados na matriz </caption> <tr> <th> Placa </th> <th> Fabricante </th> <th> Preço </th> </tr>";

 let corpoTabela = "";
 let placa, fabricante, preco;

 for (placa in matrizCarros) {
  fabricante = matrizCarros[placa][0];
  preco = matrizCarros[placa][1];
  corpoTabela = corpoTabela + "<tr> <td> " + placa + " </td> <td> " + fabricante + " </td> <td> " + preco + " </td> </tr> ";
 }

 corpoTabela += "</table>";

 // Agora vamos procurar o carro mais barato na matriz - ITEM C
 let menorPreco = matrizCarros[placa1][1];
 let nomeMenorPreco, fabricanteMenorPreco;
 for (let placaMenorPreco in matrizCarros) {
  if (matrizCarros[placaMenorPreco][1] <= menorPreco) {
   menorPreco = matrizCarros[placaMenorPreco][1];
   fabricanteMenorPreco = matrizCarros[placaMenorPreco][0];
   nomeMenorPreco = placaMenorPreco;
  }
 }

 let msgMenorPreco = "<p> O carro com o menor preço é: "+ nomeMenorPreco +" com o valor de: "+menorPreco+" e seu fabricante é "+ fabricanteMenorPreco +"</p>";

 objDiv.innerHTML = cabecalhoTabela + corpoTabela + msgMenorPreco;
}
let objButao = document.getElementById("butao");
objButao.addEventListener("click", clicarButao);