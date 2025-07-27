package application;

import model.entities.Produto;
import service.ExportadorDeProdutos;
import service.FiltroProdutoService;
import utils.ArquivoProdutoReader;
import utils.ArquivoProdutoWriter;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Bem Vindo! ----");

        System.out.print("Digite o caminho do arquivo: ");
        String caminhoArquivo = sc.next();

        List<Produto> produtos = ArquivoProdutoReader.lerArquivoProdutos(caminhoArquivo);

        System.out.println("O que deseja fazer?");
        System.out.println("1- Filtrar");
        System.out.println("2- Gerar relatório");
        int opcaoDesejo = sc.nextInt();

        if(opcaoDesejo == 1) {
            System.out.println();
            System.out.println("1- Valor total dos produtos");
            System.out.println("2- Valor total dos produtos por categoria");
            System.out.println("3- Buscar produto por ID");
            System.out.println("O que quer filtrar?");
            int opcaoFiltro = sc.nextInt();
            sc.nextLine();

            switch (opcaoFiltro) {
                case 1:
                    double valorTotalProdutos = FiltroProdutoService.calcularValorTotalProdutos(produtos);
                    System.out.println("O valor total é de: " + valorTotalProdutos);
                    break;

                case 2:
                    System.out.println("Informe a categoria: ");
                    String categoriaString = sc.nextLine();
                    double valorTotalPorCategoria = FiltroProdutoService.calcularValorTotalPorCategoria(produtos, categoriaString);
                    System.out.println("O valor total dos produtos da categoria " + categoriaString + " é de: " + valorTotalPorCategoria);
                    break;

                case 3:
                    System.out.print("Informe o ID:");
                    int idFiltro = sc.nextInt();
                    Produto produtoFiltroID = FiltroProdutoService.buscarPorId(produtos, idFiltro);
                    System.out.println("O produto do ID " + idFiltro + " é: " + produtoFiltroID);
                    break;
            }

        } else if(opcaoDesejo == 2) {
            //ArquivoProdutoWriter.gerarArquivoProdutos(produtos);
            System.out.println();
            System.out.println("1- Produtos em estoque");
            System.out.println("2- Produtos sem estoque");
            System.out.println("3- Produtos por nome");
            System.out.println("4- Produtos entre uma faixa de preço");
            System.out.println("5- Produtos de uma categoria");
            System.out.print("O que deseja exportar?");
            int opcaoExportacao = sc.nextInt();

            //final String caminhoDownload = "exportado.txt";

            ExportadorDeProdutos.exportarPorOpcao(produtos, opcaoExportacao);

        }


        sc.close();
    }
}
