package model.utils;

import model.entities.Produto;
import model.enums.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroCatalogoProdutos {

    public static double calcularValorTotalProdutos(List<Produto> produtos) {
        return produtos.stream().filter(Produto::isEmEstoque).mapToDouble(Produto::getPreco).sum();
    }

    public static List<String> produtosDisponivelEstoque(List<Produto> produtos) {
        return produtos.stream().filter(Produto::isEmEstoque).map(Produto::getNome).collect(Collectors.toList());
    }

    /* Como eu fiz sozinho */
    public static double calcularValorTotalPorCategoria(List<Produto> produtos, Categoria categoria) {
        return produtos.stream()
                .filter(Produto::isEmEstoque)
                .mapToDouble(p -> {
                    if(p.getCategoria() == categoria) {
                        return p.getPreco();
                    }
                    else {return 0.0;}
                }).sum();
    }

    /* Perguntei se o metodo a cima estava bom para o IA e falou que está bom só faltava refinar um pouco e me deu
    essa solução, porem não vou usar ja que a minha está certa mas entendi o que devo melhorar!

    public static double calcularValorTotalPorCategoria(List<Produto> produtos, Categoria categoria) {
        return produtos.stream()
                .filter( p -> p.isEmEstoque() && p.getCategoria() == categoria)
                .mapToDouble(Produto::getPreco).sum();
    }
    */
}
