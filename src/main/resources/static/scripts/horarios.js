let datas = document.querySelector(".data_e_hora").dataset.text;
let selectHora = document.querySelector("#hora");
let selectData = document.querySelector("#data");

let horarios = JSON.parse(datas);
let lista = [];

selectData.addEventListener("change", (event) => {
    for(let item of horarios){
        if(event.target.value == item.data && item.agendado == false){
            lista.push(item.hora);
        }
    }
    criarLinhaData(lista);
});

function criarLinhaData(listaData){
    lista = [];
    selectHora.innerHTML = `"<option value="Selecione um Horario" disabled selected>Selecione um Horario</option>"`;
    listaData.forEach(element => {
        selectHora.innerHTML += `
        <option value="${element}">${element}</option>`;
    });
}