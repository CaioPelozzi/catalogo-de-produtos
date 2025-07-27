package application;

import model.entities.Produto;
import utils.ArquivoProdutoReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo: ");
        String caminho = sc.next();

        List<Produto> produtos = new ArrayList<>(ArquivoProdutoReader.lerArquivoProdutos(caminho));

        //System.out.println(produtos);



    }
}
