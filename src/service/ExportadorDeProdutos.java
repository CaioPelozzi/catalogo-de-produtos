package service;

import model.entities.Produto;
import utils.ArquivoProdutoWriter;

import java.util.List;
import java.util.Scanner;

public class ExportadorDeProdutos {
        static Scanner sc = new Scanner(System.in);
    public static void exportarPorOpção(List<Produto> produtos, String caminho, int opcao) {
        switch (opcao) {
            case 1:
                List<Produto> produtosDisponivelEstoque = FiltroCatalogoProdutos.produtosDisponivelEstoque(produtos);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtosDisponivelEstoque, caminho);

            case 2:
                List<Produto> produtosSemEstoque = FiltroCatalogoProdutos.buscarProdutoSemEstoque(produtos);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtosSemEstoque, caminho);

            case 3:
                System.out.print("Digite o nome do produto: ");
                String nome = sc.nextLine();
                sc.next();
                List<Produto> produtosPorNome = FiltroCatalogoProdutos.buscarProdutoPorNome(produtos, nome);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtosPorNome, caminho);

            case 4:
                System.out.print("Digite o valor mínimo:");
                double min = sc.nextInt();
                System.out.print("Digite o valor máximo: ");
                double max = sc.nextInt();
                List<Produto> produtoFaixaPreco = FiltroCatalogoProdutos.buscarPorFaixaPreco(produtos, min, max);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtoFaixaPreco, caminho);

            case 5:
                System.out.print("Digite a categoria: ");
                String categoria = sc.nextLine();
                sc.next();
                List<Produto> produtoPorCategoria = FiltroCatalogoProdutos.buscarPorCategoria(produtos, categoria);
                ArquivoProdutoWriter.gerarArquivoProdutos(produtoPorCategoria, caminho);

        }
    }

}
