function criarMatriz() {
 // Criando a matriz em JavaScript. Primeiramente, vamos definir 4 vetores temporários, que armazenam os dados de cada produto. São os vetores internos da matriz. Após isso, inserimos cada vetor dentro das células da matriz.
 const vetorPlacaSom = [20, 5, 520];
 const vetorPlacaVideo = [60, 5, 730];
 const vetorProcessador = [12, 10, 840.12];
 const vetorMemoriaRam = [10, 10, 376.14];

 // Agora que já temos os vetores internos, criamos a matriz, cujo índice será o nome de cada produto e conterá, dentro de suas células, cada um dos vetores internos
 let matrizProdutos = [];
 // Para inserir os valores na matriz ela deve ser declara antes 
 matrizProdutos["Placa de Som"] = vetorPlacaSom;
 matrizProdutos["Placa de Video"] = vetorPlacaVideo;
 matrizProdutos["Processador"] = vetorProcessador;
 matrizProdutos["Memoria RAM"] = vetorMemoriaRam;

 console.log(matrizProdutos);

 // Criando a variabel String que ira armazenar todos os resultados para serem exibidos na tag div
 let msgResposta = "<p> Produtos com estoque mínimo a baixo de 10 unidades: ";

 // Percorrer a matriz e descobrindo os produtos com estoque minimo a baixo de 10 unidades
 let nomesProdutosAbaixo10 = "";

 // Laço para percorrer a matriz associativa
 let produto;
 for (produto in matrizProdutos) {
  if (matrizProdutos[produto][1] < 10) {
   nomesProdutosAbaixo10 += produto + " - ";
  }
 }

 // Antes de o JavaScript escrever os nomes dos produtos, na página web, com estoque mínimo abaixo de 10 unidades, devemos testar se nenhum produto está nessa condição
 if (!nomesProdutosAbaixo10) {
  nomesProdutosAbaixo10 = "- nenhum produto com estoque mínimo abaixo de 10 unidades";
 }

 // Atualizar a mensagem de resposta
 msgResposta += nomesProdutosAbaixo10 + "<br>";

 // Agora, vamos calcular o total faturado com a venda do estoque de todas as memórias RAM's

 let totalVendaMemoriaRam = matrizProdutos["Memoria RAM"][0] * matrizProdutos["Memoria RAM"][2];

 // Vamos aproveitar a oportunidade e aprender como o JavaScript formata valores monetários em reais
 totalVendaMemoriaRam = totalVendaMemoriaRam.toLocaleString("pt-BR",
  {
   minimumFractionDigits: 2, maximumFractionDigits: 2
  }
 );
 msgResposta += "Valor total fatura com a venda de mémoria RAM: R$" + totalVendaMemoriaRam + "<br>";

 // Vamos calcular o valor total faturado com a venda de todos os produtos da matriz, Para isso, vamos utilizar o laço for para percorrer a matriz, multiplicando a quantidade em estoque pelo preço unitário
 let faturaTotal = 0;
 for (produto in matrizProdutos) {
  faturaTotal += matrizProdutos[produto][0] * matrizProdutos[produto][2];
 }

 faturaTotal = faturaTotal.toLocaleString("pt-BR",
  {
   minimumFractionDigits: 2, maximumFractionDigits: 2
  }
 );

 msgResposta += "Valor total fatura com a venda de todos os itens: R$" + faturaTotal + "<br>";

 // Vamos percorrer a matriz e descobrir o nome do produto mais caro cadastrado. Vamos inicializar a variável de controle com o preço do primeiro produto na matriz
 let maiorPreco = matrizProdutos["Placa de Som"][2];
 let nomeProdutoMaiorPreco;
 for (produto in matrizProdutos) {
  if (matrizProdutos[produto][2] > maiorPreco) {
   maiorPreco = matrizProdutos[produto][2];
   nomeProdutoMaiorPreco = produto;
  }
 }

 maiorPreco = maiorPreco.toLocaleString("pt-BR",
  {
   minimumFractionDigits: 2, maximumFractionDigits: 2
  }
 );

 msgResposta += "O produto mais caro é: "+ nomeProdutoMaiorPreco + " e seu valor é: R$" + matrizProdutos[nomeProdutoMaiorPreco][2];

 let objDiv = document.getElementById("container");
 objDiv.innerHTML = msgResposta + "</p>";


}
let objButao = document.getElementById("butao");
objButao.addEventListener("click", criarMatriz);