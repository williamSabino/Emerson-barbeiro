var agendamentos = document.querySelector(".horarios_container").dataset.agendamentos;
let container = document.querySelector(".horarios_container");

container.innerHTML = "";

let agendamentosLista = JSON.parse(agendamentos);

for (let item of agendamentosLista) {
    let linha = `
    <div class="horario">
    <p class="horario_data">Data: <br> ${dataFormat(item.data, "dd-mm-yyyy")}</p>
    <p>Hora: ${item.hora}</p>
    <p>Nome: <br> ${item.nome}</p>
    <p>Serviços: ${servicos(item)} </p>
    <p>Telefone: ${item.numero == null ? "" : item.numero}</p>
    <span class="container_btn">
        <a href="#"><img src="/images/editt.png" alt="no" class="btn_edit"></img></a>
        <a href="#"><img src="/images/delete.png" alt="no" class="btn_delete"></img></a>
    </span>
</div>
    `;
    container.innerHTML += linha;
}


function servicos(agendamento){
    let servicos = [];
    for (const [key, value] of Object.entries(agendamento)){
        if(value === true){
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
 function dataFormat(data, format){
    let dataAgora = new Date(data);
    let dataFormatada = format.replace("dd", dataAgora.getDate() + 1)
    .replace("mm", dataAgora.getMonth() + 1)
    .replace("yyyy", dataAgora.getFullYear())
    return dataFormatada;
   }



