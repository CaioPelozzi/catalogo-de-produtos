package service;

import model.entities.Produto;
import model.enums.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroCatalogoProdutos {

    public static double calcularValorTotalProdutos(List<Produto> produtos) {
        return produtos.stream().filter(Produto::isEmEstoque).mapToDouble(Produto::getPreco).sum();
    }

    public static List<String> produtosDisponivelEstoque(List<Produto> produtos) {
        return produtos.stream()
                .filter(Produto::isEmEstoque)
                .map(p -> "ID: " + p.getId() + " - " + p.getNome() + " (" + p.getCategoria() + ")")
                .collect(Collectors.toList());
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

    public static List<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {

        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome.trim()))
                .filter(p -> p.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Produto> buscarPorFaixaPreco(List<Produto> produtos, double min, double max) {
        if (min < max){
            return produtos.stream()
                    .filter(p -> p.getPreco() >= min && p.getPreco() <= max)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("O valor mínimo não pode ser maior que o valor máximo");
        }
    }

    public static Produto buscarPorId(List<Produto> produtos, int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static List<String> buscarPorCategoria(List<Produto> produtos, String categoria) {
        String catUpperCase = categoria.toUpperCase();
        Categoria categoriaValor = Categoria.valueOf(catUpperCase);
        return produtos.stream()
                .filter(p -> categoriaValor.equals(p.getCategoria()))
                .map(p -> p.getNome() + " - " + p.getPreco()).collect(Collectors.toList());

    }

    public static List<String> buscarProdutoSemEstoque(List<Produto> produtos) {
        return produtos.stream()
                .filter(p -> !p.isEmEstoque())
                .map(p -> "ID: " + p.getId() + " - " + p.getNome() + " (" + p.getCategoria() + ")")
                .collect(Collectors.toList());
    }
}
