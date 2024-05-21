var agendamentos = document.querySelector(".horarios_container").dataset.agendamentos;
let container = document.querySelector(".horarios_container");

container.innerHTML = "";

let agendamentosLista = JSON.parse(agendamentos);

for (let item of agendamentosLista) {
    let linha = `
    <div class="horario">
    <p class="horario_data">Data: <br> ${item.data}</p>
    <p>Hora: ${item.hora}</p>
    <p>Nome: <br> ${item.nome}</p>
    <p>Serviços: <br> Barba,Tesoura</p>
    <p>Telefone: 81982748007</p>
    <span class="container_btn">
        <a href="#"><img src="/images/editt.png" alt="no" class="btn_edit"></img></a>
        <a href="#"><img src="/images/delete.png" alt="no" class="btn_delete"></img></a>
    </span>
</div>
    `;
    container.innerHTML += linha;
}



