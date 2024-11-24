document.addEventListener('DOMContentLoaded', function () {
  const radio1 = document.getElementById('radio1');
  const radio2 = document.getElementById('radio2');
  const radio3 = document.getElementById('radio3');
  const depoimento1 = document.querySelector('.depoimento-1');
  const depoimento2 = document.querySelector('.depoimento-2');
  const depoimento3 = document.querySelector('.depoimento-3');

  // Ao carregar a página, exibe apenas depoimento-1 com display:flex
  depoimento1.style.display = 'flex';

  // Após 2 segundos, inicia a alternância automática
  setTimeout(() => {
    alternarDivs();
    setInterval(alternarDivs, 2000);
  }, 2000);

  function alternarDivs() {
    if (depoimento1.style.display === 'flex') {
      depoimento1.style.display = 'none';
      depoimento2.style.display = 'flex';
      depoimento3.style.display = 'none';
    } else if (depoimento2.style.display === 'flex') {
      depoimento1.style.display = 'none';
      depoimento2.style.display = 'none';
      depoimento3.style.display = 'flex';
    } else {
      depoimento1.style.display = 'flex';
      depoimento2.style.display = 'none';
      depoimento3.style.display = 'none';
    }
  }

  radio1.addEventListener('change', function () {
    depoimento1.style.display = 'flex';
    depoimento2.style.display = 'none';
    depoimento3.style.display = 'none';
  });

  radio2.addEventListener('change', function () {
    depoimento1.style.display = 'none';
    depoimento2.style.display = 'flex';
    depoimento3.style.display = 'none';
  });

  radio3.addEventListener('change', function () {
    depoimento1.style.display = 'none';
    depoimento2.style.display = 'none';
    depoimento3.style.display = 'flex';
  });
});