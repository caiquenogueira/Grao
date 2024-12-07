package Model;

import java.util.ArrayList;
import java.util.List;

// Classe Estoque para gerenciar produtos
public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Adiciona um produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Remove um produto do estoque por ID
    public boolean removerProdutoPorId(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }

    // Busca um produto por ID
    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    // Lista todos os produtos no estoque
    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    // Atualiza o estoque de um produto por ID
    public boolean atualizarEstoque(int id, int novoEstoque) {
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            produto.setEstoque(novoEstoque);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Estoque:\n");
        for (Produto produto : produtos) {
            builder.append(produto).append("\n");
        }
        return builder.toString();
    }
}