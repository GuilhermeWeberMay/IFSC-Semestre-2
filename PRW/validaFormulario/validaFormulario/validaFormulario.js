function validarDados(quebraEvento) {
 let nome = document.getElementById("nome1").value;
 let salario = document.getElementById("salario").value;

 // Acessando os dois labels que mostram erros de preenchimento do formulário
 let objErroNome = document.getElementById("erroNome");
 let objErroSalario = document.getElementById("erroSalario");

 // Vamos criar a variavel de controle que indica se houve erros ou não na validação de campos do formulário
 let erro = false;

 // Deste ponto em diante, começa a validação propriamente dita.Para campos de texto, as duas validações mais comuns são: retirar espaços em branco inúteis e contar número de caracteres
 nome = nome.trim();
 salario = salario.trim();

 // Contando número de caracteres do nome usuário
 if (nome.length == 0) {
  erro = true;
  objErroNome.innerHTML = "<span> ERRO: Nome inválido. </span>";
 }else{
  objErroNome.innerHTML = "";
 }

 // Tratamento de campos numéricos de um formulário. A primeira coisa a ser feita é converter a string numérica para número
 let salarioConvertido = parseFloat(salario);

 if (salarioConvertido != salario){
  erro = true;
  objErroSalario.innerHTML = "<span> ERRO: Salário inválido. </span>";
 }else{
  objErroSalario.innerHTML = "";
 }

 // Testamos se houve erro no fomrulario SE SIM o JavaScript desativa o evento submit, impedindo o navegador de enviar os dados ao Back-end
 if (erro){
  quebraEvento.preventDefault();
 }

}
// Acessando o formulário por meio do DOOM
let objForm = document.getElementById("formulario");

// O evento correto que o JavaScript usa para simular o envio de dados, por formulário, ao servidor, é o evento "submit", associado ao formulário
objForm.addEventListener("submit", validarDados);