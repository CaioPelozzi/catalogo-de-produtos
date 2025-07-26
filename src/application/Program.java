package application;


import service.CatalogoProdutos;
import model.enums.Categoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        CatalogoProdutos produtos = new CatalogoProdutos();

        try(FileReader fr = new FileReader("C:/Users/caiop/in.txt");
            BufferedReader bf = new BufferedReader(fr)) {

            String linha;
            while((linha = bf.readLine()) != null) {
                String[] linhasArquivo = linha.split(", ");
                String categoriaUpperCase = linhasArquivo[2].toUpperCase();
                produtos.adicionarProduto(linhasArquivo[0], Double.parseDouble(linhasArquivo[1]),
                        Categoria.valueOf(categoriaUpperCase), Boolean.parseBoolean(linhasArquivo[3]));
            }
            //System.out.println(produtos);

        }
        catch (FileNotFoundException e){
            System.out.println("Erro ao encontrar o arquivo " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + e.getMessage());
        }
a


    }
}
