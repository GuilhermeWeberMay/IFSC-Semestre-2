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
   corpoTabela = corpoTabela +"<tr> <td> " + produto + " </td> <td> " + estoque + " </td> <td> " + preco + " </td> </tr> ";
  }
   corpoTabela += "</table>";

   // Para calcular o valor total da venda de todos os produtos, vamos percorrer a matriz e multiplicar o preço de cada produto pela quantidade em estoque
   let soma = 0;

   for(produto in matrizProdutos){
    estoque = matrizProdutos[produto][0];
    preco = matrizProdutos[produto][1];
    soma += estoque * preco;
   }
   soma = soma.toLocaleString("pt-BR", {style: "currency", currency: "BRL", 
    minimumFractionDigits: 2, maximumFractionDigits: 2
   });

   const msgVendaTotal = "<p> O faturamento com a venda de todos os produtos da matriz é igual a "+ soma + "</p>";

   // Descobrir os dados do produto mais barato guardado na matriz. Vamos supor que o primeiro produto já é o mais barato e vamos colocar seu preço na varaiável de controle
   let menorPreco = matrizProdutos[produto][1];
   let nomeMenorPreco, estoqueMenorPreco;
   for(produto in matrizProdutos){
    if(matrizProdutos[produto][1] <= menorPreco){
      menorPreco = matrizProdutos[produto][1];
      estoqueMenorPreco = matrizProdutos[produto][0];
      nomeMenorPreco = produto;
    }
   }

   menorPreco = menorPreco.toLocaleString("pt-BR", {style: "currency", currency: "BRL", 
    minimumFractionDigits: 2, maximumFractionDigits: 2
   });

   let msgMenorPreco = "<p> O produto com o menor preço é: "+ nomeMenorPreco +" com o valor de: "+menorPreco+" e estoque de "+ estoqueMenorPreco +"</p>";


   // Apresentação dos resultados
   objDiv.innerHTML = cabecalhoTabela + corpoTabela + msgVendaTotal + msgMenorPreco;

 }
 let objButao = document.getElementById("butao");
 objButao.addEventListener("click", criarMatriz);
