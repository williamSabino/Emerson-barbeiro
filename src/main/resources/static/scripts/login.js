let login = document.querySelector(".login");
let criarConta = document.querySelector(".sign");
let btnCriar = document.querySelector("#criar_conta");
let btnLogin = document.querySelector("#login");

btnCriar.addEventListener("click", () => {
    login.style.display = "none";
    criarConta.style.display = "flex";
});

btnLogin.addEventListener("click", () => {
    criarConta.style.display = "none";
    login.style.display = "flex";
});