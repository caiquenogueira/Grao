package Model;

// Classe Castanha, subclasse de Produto
public class Castanha extends Produto {

    public Castanha(int id, String nome, double preco, int estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Castanha ID: " + getId() + ", Nome: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}
