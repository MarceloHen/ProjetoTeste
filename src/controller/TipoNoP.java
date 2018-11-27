package controller;

import model.Produtos;

public class TipoNoP {

    public TipoNoP proximo;
    public TipoNoP anterior;
    public Produtos item;

    public TipoNoP(int codigo, String nome, double preco) {

        item = new Produtos(codigo, nome, preco);
        this.proximo = null;
        this.anterior = null;
    }

    public String toString() {
        return item.toString();
    }
}
