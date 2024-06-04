let login = document.querySelector(".login");
let criarConta = document.querySelector(".sign");
let btnCriar = document.querySelector("#criar_conta");
let btnLogin = document.querySelector("#login");
let error = new URLSearchParams(window.location.search).get("error");
let errorMessage = document.querySelector("#error_message");


/*btnCriar.addEventListener("click", () => {
    login.style.display = "none";
    criarConta.style.display = "flex";
});*/

btnLogin.addEventListener("click", () => {
    criarConta.style.display = "none";
    login.style.display = "flex";
});


let inputsEmail = document.querySelector("#email");
let inputsSenha = document.querySelector("#senha");
if(error == "true"){
    errorMessage.style.display = "block";
    inputsEmail.style.outline = "4px solid red";
    inputsSenha.style.outline = "4px solid red";
}