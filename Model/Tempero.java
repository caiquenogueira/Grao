package Model;

// Classe Tempero, subclasse de Produto
public class Tempero extends Produto {

    public Tempero(String nome, double preco, int estoque) {
        super(nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Tempero: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}