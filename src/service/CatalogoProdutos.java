/*package service;

import model.entities.Produto;
import model.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProdutos {
    private final List<Produto> produtos;

    public CatalogoProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String nome ,double preco ,Categoria categoria ,boolean emEstoque) {
        produtos.add(new Produto(nome, preco, categoria, emEstoque));

    }

    public List<Produto> imprimirLista() {
        return produtos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produto p : produtos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}*/
