let dataTime = document.querySelector('.data_e_hora input[type="date"]');

 let min = dataFormat(new Date(Date.now()), "yyyy-mm-dd");
 let max = dataFormat(new Date(Date.now()),"yyyy-mm-dd");

 function dataFormat(dataAgora, format){
     let dataFormatada = format.replace("dd", dataAgora.getDate())
     .replace("mm", dataAgora.getMonth() + 1)
     .replace("yyyy", dataAgora.getFullYear())
     
     return dataFormatada;
    }

