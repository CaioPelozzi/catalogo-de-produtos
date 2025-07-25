package controller;

import model.entities.Produto;
import model.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProdutos {
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(int id,String nome ,double preco ,Categoria categoria ,boolean emEstoque) {
        produtos.add(new Produto(nome, preco, categoria, emEstoque));
    }

    public List<Produto> imprimirLista() {
        return produtos;
    }

}
