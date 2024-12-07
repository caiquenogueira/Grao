// Classe Suplementos, subclasse de Produto
public class Suplemento extends Produto {

    public Suplemento(String nome, double preco, int estoque) {
        super(nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Suplemento: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}