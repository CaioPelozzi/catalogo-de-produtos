package utils;

import model.entities.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ArquivoProdutoWriter {
    static LocalDate dataDownload = LocalDate.now();
    public static void gerarArquivoProdutos(List<Produto> produtos) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\caiop\\saidaProjeto\\"
                + dataDownload + "saida.txt"))) {

            for (Produto p : produtos) {
                bw.write(p.toString());
                bw.newLine();
            }


        }
        catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
