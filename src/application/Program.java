package application;

import model.entities.Produto;
import service.ExportadorDeProdutos;
import service.FiltroProdutoService;
import utils.ArquivoProdutoReader;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Bem Vindo! ----");

        System.out.print("Digite o caminho do arquivo: ");
        String caminhoArquivo = sc.next();

        List<Produto> produtos = ArquivoProdutoReader.lerArquivoProdutos(caminhoArquivo);
        try {
            System.out.println("O que deseja fazer?");
            System.out.println("1- Filtrar");
            System.out.println("2- Gerar relatório");
            int opcaoDesejo = sc.nextInt();

            if (opcaoDesejo == 1) {
                System.out.println();
                System.out.println("1- Valor total dos produtos");
                System.out.println("2- Valor total dos produtos por categoria");
                System.out.println("3- Buscar produto por ID");
                System.out.print("O que quer filtrar? ");
                int opcaoFiltro = sc.nextInt();
                sc.nextLine();

                switch (opcaoFiltro) {
                    case 1:
                        double valorTotalProdutos = FiltroProdutoService.calcularValorTotalProdutos(produtos);
                        System.out.printf("O valor total é de: %.2f%n", valorTotalProdutos);
                        System.out.println("----- FIM! -----");
                        break;

                    case 2:
                        System.out.println("Informe a categoria: ");
                        String categoriaString = sc.nextLine();
                        double valorTotalPorCategoria = FiltroProdutoService.calcularValorTotalPorCategoria(produtos, categoriaString);
                        System.out.printf("O valor total dos produtos da categoria %s é de: %.2f%n", categoriaString, valorTotalPorCategoria);
                        System.out.println("----- FIM! -----");
                        break;

                    case 3:
                        System.out.print("Informe o ID:");
                        int idFiltro = sc.nextInt();
                        Produto produtoFiltroID = FiltroProdutoService.buscarPorId(produtos, idFiltro);
                        if (produtoFiltroID == null) {
                            System.out.println("O ID informado não existe!");
                            break;
                        } else {
                            System.out.println("O produto do ID " + idFiltro + " é: " + produtoFiltroID);
                            System.out.println("----- FIM! -----");
                            break;
                        }
                    default:
                        throw new IllegalArgumentException("A opção " + opcaoFiltro + " é inválida!");
                }
            } else if (opcaoDesejo == 2) {
                System.out.println();
                System.out.println("1- Produtos em estoque");
                System.out.println("2- Produtos sem estoque");
                System.out.println("3- Produtos por nome");
                System.out.println("4- Produtos entre uma faixa de preço");
                System.out.println("5- Produtos de uma categoria");
                System.out.print("O que deseja exportar? ");
                int opcaoExportacao = sc.nextInt();

                ExportadorDeProdutos.exportarPorOpcao(produtos, opcaoExportacao);
                System.out.println("----- FIM! -----");
            } else {
                throw new IllegalArgumentException("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Por favor! Entre com números");
        }
        sc.close();
    }
}
