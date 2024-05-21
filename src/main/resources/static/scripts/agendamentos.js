var agendamentos = document.querySelector(".horarios_container").dataset.agendamentos;
let container = document.querySelector(".horarios_container");

container.innerHTML = "";

let agendamentosLista = JSON.parse(agendamentos);

for (let item of agendamentosLista) {
    let linha = `
    <div class="horario">
    <p class="horario_data">Data: ${item.data}</p>
    <p>Hora: ${item.hora}</p>
    <p>Nome: ${item.nome}</p>
    <p>Serviços: Barba,Tesoura</p>
    <p>Telefone: 81982748007</p>
    <span class="container_btn">
        <button type="button">Editar</button>
        <button type="button">Deletar</button>
    </span>
</div>
    `;
    container.innerHTML += linha;
}



