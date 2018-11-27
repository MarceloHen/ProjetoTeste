package model;

public class Produtos {

    private int codigo;
    private String nome;
    private double preco;
    private String pesquisa;

    public Produtos() {
    }

    public Produtos(int codigo, String nome, double preco) {
        
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
    
     public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /*  public Produtos(int codigo, String nome, double preco) {

        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String toString() {
        return "Codigo: " + getCodigo() + "Nome: " + getNome() + "Preço: " + getPreco();
    }*/   
}
