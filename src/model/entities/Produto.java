package model.entities;
import model.enums.Categoria;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private Categoria categoria;
    private boolean emEstoque;

    public static int idIteracao = 1;

    public Produto(String nome ,double preco ,Categoria categoria ,boolean emEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.emEstoque = emEstoque;
        this.id = idIteracao++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() { return preco; }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public String emEstoqueString() {
        if (this.isEmEstoque()) { return "Sim"; }
        else { return "Não"; }
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " | Nome: " + this.getNome() + " | Preço: " + this.getPreco()
            + " | Cateogoria: " + this.getCategoria() + " | Em estoque: " + this.emEstoqueString();
    }
}
