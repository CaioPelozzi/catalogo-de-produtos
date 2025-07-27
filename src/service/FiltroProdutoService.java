package service;

import model.entities.Produto;
import model.enums.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroProdutoService {

    public static double calcularValorTotalProdutos(List<Produto> produtos) {
        return produtos.stream().filter(Produto::isEmEstoque).mapToDouble(Produto::getPreco).sum();
    }

    public static List<Produto> produtosDisponivelEstoque(List<Produto> produtos) {
        return produtos.stream()
                .filter(Produto::isEmEstoque)
                .collect(Collectors.toList());
    }


    public static double calcularValorTotalPorCategoria(List<Produto> produtos, String categoria) {

        String categoriaUpperCase = categoria.toUpperCase();
        Categoria categoriaFormat = Categoria.valueOf(categoriaUpperCase);
        return produtos.stream()
                .filter(Produto::isEmEstoque)
                .mapToDouble(p -> {
                    if(p.getCategoria() == categoriaFormat) {
                        return p.getPreco();
                    }
                    else {return 0.0;}
                }).sum();
    }

    public static List<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
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

    public static List<Produto> buscarPorCategoria(List<Produto> produtos, String categoria) {
        String catUpperCase = categoria.toUpperCase();
        Categoria categoriaValor = Categoria.valueOf(catUpperCase);
        return produtos.stream()
                .filter(p -> categoriaValor.equals(p.getCategoria())).collect(Collectors.toList());

    }

    public static List<Produto> buscarProdutoSemEstoque(List<Produto> produtos) {
        return produtos.stream()
                .filter(p -> !p.isEmEstoque())
                .collect(Collectors.toList());
    }
}
