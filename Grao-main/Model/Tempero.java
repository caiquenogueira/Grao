package Model;

// Classe Tempero, subclasse de Produto
public class Tempero extends Produto {

    public Tempero(int id, String nome, double preco, int estoque) {
        super(id, nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Tempero ID: " + getId() + ", Nome: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}
