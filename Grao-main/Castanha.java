// Classe Castanha, subclasse de Produto
public class Castanha extends Produto {

    public Castanha(String nome, double preco, int estoque) {
        super(nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Castanha: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}
