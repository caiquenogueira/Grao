package Model;

// Classe Farinaceos, subclasse de Produto
public class Farinaceos extends Produto {

    public Farinaceos(int id, String nome, double preco, int estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Farináceo: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque() + ", ID: " + getId();
    }
}
