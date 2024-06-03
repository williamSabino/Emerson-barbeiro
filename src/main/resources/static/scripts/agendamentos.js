var agendamentos = document.querySelector(".horarios_container").dataset.agendamentos;
let container = document.querySelector(".horarios_container");
let agendamentosLista = JSON.parse(agendamentos);

montarLista(agendamentosLista);

//filtro
let filtroData = document.querySelector("#dataInicial");

filtroData.addEventListener("change", (evt) => {
    let lista = [];
    let data = evt.target.value;
    for (let item of agendamentosLista) {
        console.log(`compara item: ${item.data} é igual a: ${data}`);
        if (item.data == data) {
            lista.push(item);
        }
    }
    montarLista(lista);
});


function montarLista(lista) {
    container.innerHTML = "";
    for (let item of lista) {
        let linha = `
    <div class="horario">
    <p class="horario_data">Data: <br> ${dataFormat(item.data, "dd-mm-yyyy")}</p>
    <p>Hora: ${item.hora}</p>
    <p>Nome: <br> ${item.nome}</p>
    <p>Serviços: ${servicos(item)} </p>
    <p>Telefone: ${item.numero == null ? "" : item.numero}</p>
    <span class="container_btn">
        <a href="#"><img src="/images/editt.png" alt="no" class="btn_edit"></img></a>
        <a href="/emerson-barbeiro/deletar/${item.id}"><img src="/images/delete.png" alt="no" class="btn_delete" id="${item.id}"></img></a>
    </span>
</div>
    `;
        container.innerHTML += linha;
    }
}

function servicos(agendamento) {
    let servicos = [];
    for (const [key, value] of Object.entries(agendamento)) {
        if (value === true) {
            servicos.push(key);
        }
    }
    let linha = "";
    servicos.forEach(element => {
        linha += ` <br> ${element} `;
    });
    return linha;
}

//formata a data recebida do calendario
function dataFormat(data, format) {
    let dataAgora = new Date(data);
    let dataFormatada = format.replace("dd", dataAgora.getDate() + 1)
        .replace("mm", dataAgora.getMonth() + 1)
        .replace("yyyy", dataAgora.getFullYear())
    return dataFormatada;
}


// delete button 

let btnDelete = document.querySelectorAll(".btn_delete");

for (let item of btnDelete) {
    item.addEventListener("click", (evt) => {
        console.log(item);
    });
}





