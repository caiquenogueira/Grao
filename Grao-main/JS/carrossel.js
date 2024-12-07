var radio = document.querySelector('.manual-btn') /*Seleciona o primeiro elemento com a classe CSS "manual-btn" e armazena-o na variável 'radio'*/
var cont = 1 /* Inicializa a variável 'cont' com o valor 1 para rastrear a imagem atual*/

document.getElementById ('radio1').checked = true; /* Marca o botão de rádio correspondente à primeira imagem como selecionado por padrão*/

setInterval(()=>{ /*// Inicia um intervalo que chama a função 'proximaImg()' a cada 5000 milissegundos (5 segundos)*/
    proximaImg()
},5000)

function proximaImg(){ /*// Função para avançar para a próxima imagem no carrossel*/
    cont++

    if(cont > 4){ /* Verifica se 'cont' ultrapassou o número máximo de imagens (assumindo 4 imagens)*/
        cont = 1 /* Se sim, reinicia 'cont' para 1, permitindo um loop circular entre as imagens*/

    }

    document.getElementById('radio'+cont).checked =true /*Marca o botão de rádio correspondente à imagem atual como selecionado*/

}