let dataTime = document.querySelector('.data_e_hora input[type="date"]');
let listaServicos = document.querySelectorAll(".lista_servicos fieldset input[type='checkbox']");

 let min = dataFormat(new Date(Date.now()), "yyyy-mm-dd");
 let max = dataFormat(new Date(Date.now()),"yyyy-mm-dd");

 //formata a data recebida do calendario
 function dataFormat(dataAgora, format){
     let dataFormatada = format.replace("dd", dataAgora.getDate())
     .replace("mm", dataAgora.getMonth() + 1)
     .replace("yyyy", dataAgora.getFullYear())
     return dataFormatada;
    }

//verifica o click no serviço
//e pinta o background ou tira a tinta do background
for(let item of listaServicos){
    item.addEventListener("change", (event) => {
        let imgEdit = document.querySelector(`.${item.name} figure img`);
        if(item.checked == true){
            imgEdit.style.background = "chocolate";
        } else {
            imgEdit.style.background = "none";
        }
    });
}


let formulario = document.querySelector(".formulario_agendar");

formulario.addEventListener("submit", (event)=>{
let user = {}
//cria um resumo das opções selecionadas antes do envio
user.nome = document.querySelector("#nome").value;
user.numero = document.querySelector("#numero").value;
user.data = document.querySelector("#data").value;
user.hora = document.querySelector("#hora").value;
user.servicos = servicosSelecionados();

    confirm(`Agendar ?? \n {
        Nome: ${user.nome}"
        Numero: ${user.numero}
        Servico: ${user.servicos}
        Data: ${user.data}
        Hora: ${user.hora}
    }`);
   // let data = new FormData(formulario);
});

//retorna uma lista de servicos selecionados pelo usuario
function servicosSelecionados(){
    let servicos = [];
    for(let item of listaServicos){
        if(item.checked == true){
            servicos.push(item.name);
        }
    }
    return servicos;
}