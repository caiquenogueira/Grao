// Classe Farinaceos, subclasse de Produto
public class Farinaceos extends Produto {

    public Farinaceos(String nome, double preco, int estoque) {
        super(nome, preco, estoque);
    }

    @Override
    public String toString() {
        return "Farináceo: " + getNome() + ", Preço: " + getPreco() + ", Estoque: " + getEstoque();
    }
}
