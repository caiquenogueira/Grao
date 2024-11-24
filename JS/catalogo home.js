function toggleDetails(itemId) {
    var details = document.getElementById('details' + itemId);
    details.style.display = details.style.display === 'block' ? 'none' : 'block';
  }