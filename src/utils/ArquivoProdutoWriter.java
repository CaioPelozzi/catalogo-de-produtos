package utils;

import model.entities.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoProdutoWriter {
    public static void gerarArquivoProdutos(List<Produto> produtos, String caminho) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (Produto p : produtos) {
                bw.write(p.toString());
                bw.newLine();
            }
            System.out.println("Arquivo gerado com suceso!");


        }
        catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
