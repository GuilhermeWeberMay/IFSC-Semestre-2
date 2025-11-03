 function criarMatriz() {

  let objDiv = document.getElementById("container");
  // Acessar as caixas do formulario por meio do DOOM
  const objProduto1 = document.getElementById("nome1");
  const objEstoque1 = document.getElementById("estoque1");
  const objPreco1 = document.getElementById("preco1");

  const objProduto2 = document.getElementById("nome2");
  const objEstoque2 = document.getElementById("estoque2");
  const objPreco2 = document.getElementById("preco2");

  const objProduto3 = document.getElementById("nome3");
  const objEstoque3 = document.getElementById("estoque3");
  const objPreco3 = document.getElementById("preco3");

  // Guardar os valores digitados em cada campo do formulario por meio dos objetos criados acima
  let produto1 = objProduto1.value;
  let estoque1 = objEstoque1.value;
  let preco1 = objPreco1.value;

  let produto2 = objProduto2.value;
  let estoque2 = objEstoque2.value;
  let preco2 = objPreco2.value;

  let produto3 = objProduto3.value;
  let estoque3 = objEstoque3.value;
  let preco3 = objPreco3.value;

  // Vamos criar os vetores parciais armazenando o estoque e o preço de cada produto
  let vetorProduto1 = [estoque1,preco1];
  let vetorProduto2 = [estoque2, preco2];
  let vetorProduto3 = [estoque3, preco3];

  // Finalmente, criamos a estrutura da matriz
  let matrizProdutos = [];

  matrizProdutos[produto1] = vetorProduto1;
  matrizProdutos[produto2] = vetorProduto2; 
  matrizProdutos[produto3] = vetorProduto3;
  
  //console.log(matrizProdutos);

  // Criar o cabeçalho da tabela HTML
  let cabecalhoTabela = "<table> <caption> Relação de produtos cadastrados na matriz </caption> <tr> <th> Produto </th> <th> Estoque </th> <th> Preço </th> </tr>";

  let corpoTabela = "";
  let produto, estoque, preco;

  console.log(matrizProdutos);

  for(produto in matrizProdutos){
   estoque = matrizProdutos[produto][0];
   preco = matrizProdutos[produto][1];
   alert(preco);
   corpoTabela = corpoTabela +"<tr> <td> " + produto + " </td> <td> " + estoque + " </td> <td> " + preco + " </td> </tr> ";
  }

   corpoTabela += "</table>";

   objDiv.innerHTML = cabecalhoTabela + corpoTabela;
 }
 let objButao = document.getElementById("butao");
 objButao.addEventListener("click", criarMatriz);
