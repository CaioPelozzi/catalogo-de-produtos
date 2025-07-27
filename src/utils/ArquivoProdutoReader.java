package utils;

import model.entities.Produto;
import model.enums.Categoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoProdutoReader {

    public static List<Produto> lerArquivoProdutos(String caminhoArquivo) {
        List<Produto> produtos = new ArrayList<>();
        try (FileReader fr = new FileReader(caminhoArquivo); BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] linhasArquivo = linha.split(", ");
                String categoriaUpperCase = linhasArquivo[2].toUpperCase();
                produtos.add(new Produto(linhasArquivo[0], Double.parseDouble(linhasArquivo[1]),
                        Categoria.valueOf(categoriaUpperCase), Boolean.parseBoolean(linhasArquivo[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível encontrar o arquivo" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo" + e.getMessage()) ;
        }
        return produtos;
    }
}
