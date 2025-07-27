package service;

import model.entities.Produto;
import utils.ArquivoProdutoWriter;

import java.util.List;
import java.util.Scanner;

public class ExportadorDeProdutos {
        static Scanner sc = new Scanner(System.in);
    public static void exportarPorOpcao(List<Produto> produtos, int opcao) {
        switch (opcao) {
            case 1:
                List<Produto> produtosDisponivelEstoque = FiltroProdutoService.produtosDisponivelEstoque(produtos);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtosDisponivelEstoque);
                break;

            case 2:
                List<Produto> produtosSemEstoque = FiltroProdutoService.buscarProdutoSemEstoque(produtos);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtosSemEstoque);
                break;

            case 3:
                System.out.print("Digite o nome do produto: ");
                String nome = sc.nextLine();
                List<Produto> produtosPorNome = FiltroProdutoService.buscarProdutoPorNome(produtos, nome);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtosPorNome);
                break;

            case 4:
                System.out.print("Digite o valor mínimo:");
                double min = sc.nextDouble();
                System.out.print("Digite o valor máximo: ");
                double max = sc.nextDouble();
                List<Produto> produtoFaixaPreco = FiltroProdutoService.buscarPorFaixaPreco(produtos, min, max);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtoFaixaPreco);
                break;

            case 5:
                System.out.print("Digite a categoria: ");
                String categoria = sc.nextLine();
                List<Produto> produtoPorCategoria = FiltroProdutoService.buscarPorCategoria(produtos, categoria);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtoPorCategoria);
                break;

        }
    }

}
