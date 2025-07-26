package model.entities;
import controller.CatalogoProdutos;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public String emEstoqueString() {
        if (this.isEmEstoque()) {
            return "Sim";
        }
        else {
            return "Não";
        }
    }
    @Override
    public String toString() {
        return "ID: " + this.getId() + " Nome: " + this.getNome() + " Preço: " + this.getPreco()
            + " Cateogoria: " + this.getCategoria() + " Em estoque: " + this.emEstoqueString();
    }
}
