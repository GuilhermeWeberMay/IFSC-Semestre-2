function validaFormulario(evento) {
 let login = document.getElementById("login").value;
 let senha = document.getElementById("senha").value;

 let objErroLogin = document.getElementById("erroLogin");
 let objErroSenha = document.getElementById("erroSenha");

 // Sempre começamos com FALSE por supormos que esta tudo certo
 let erro = false;

 login = login.trim();
 senha = senha.trim();

 if (login.length == 0) {
  erro = true;
  objErroLogin.innerHTML = " O campo login é obrigatório ";
 }else{
  objErroLogin.innerHTML = "";
 }

 if (senha.length < 15) {
  erro = true;
  objErroSenha.innerHTML = "A senha deve ter no mínimo 15 caracteres ";
 }else{
  objErroSenha.innerHTML = "";
 }

 if (erro){
  evento.preventDefault();
 }
} 

let objForm = document.getElementById("formulario");
objForm.addEventListener("submit", validaFormulario);