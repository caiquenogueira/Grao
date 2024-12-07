package Model;

// Classe Suplementos, subclasse de Produto
public class Suplemento extends Produto {

    public Suplemento(int id, String nome, double preco, int estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Suplemento ID: " + getId() + ", Nome: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}
