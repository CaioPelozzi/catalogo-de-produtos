package utils;

import model.entities.Produto;
import model.enums.Categoria;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProdutosParaMapa {

    public static Map<Categoria, List<Produto>> listaParaMapa(List<Produto> produtos) {
        return produtos.stream().collect(Collectors.groupingBy(Produto::getCategoria));
    }

    /*public static String imprimirMapa(Map<Categoria, List<Produto>> mapa) {
        return mapa.forEach(
                p ->
        );
    }*/
}
