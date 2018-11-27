package controller;

import model.Produtos;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class ListaP {

    TipoNoP primeiro;
    TipoNoP ultimo;
    TipoNoP atual;
    Formatter arquivo;
    Scanner arq;
    private int ultimocod;

    public ListaP() {

        primeiro = ultimo = null;
    }

    public boolean Vazia() {

        return primeiro == null;
    }

    public int inserirNoInicio(String nome, double preco) {

        ultimocod++;
        TipoNoP no = new TipoNoP(ultimocod, nome, preco);
        no.proximo = primeiro;

        if (Vazia()) {
            ultimo = no;
        } else {
            primeiro.anterior = no;
        }
        primeiro = no;
        return ultimocod;
    }

    public int inserirNoFinal(String nome, double preco) {

        ultimocod++;
        return inserirNoFinal(ultimocod, nome, preco);
    }

    public int inserirNoFinal(int codigo, String nome, double preco) {

        TipoNoP no = new TipoNoP(codigo, nome, preco);
        atual = no;

        if (Vazia()) {
            primeiro = no;
        } else {
            no.anterior = ultimo;
            ultimo.proximo = no;
        }
        ultimo = no;
        return codigo;
    }

    public Produtos primeiro() {

        if (primeiro != null) {
            atual = primeiro;
            return atual.item;

        } else {
            return null;
        }
    }

    public Produtos ultimo() {

        if (ultimo != null) {
            atual = ultimo;
            return atual.item;
        } else {
            return null;
        }
    }

    public Produtos proximo() {

        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
            return atual.item;
        } else {
            return null;
        }
    }

    public Produtos anterior() {

        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            return atual.item;
        } else {
            return null;
        }
    }

    public Produtos localizar(int codigo) {

        TipoNoP aux = primeiro;

        while (aux != null && aux.item.getCodigo() != codigo) {
            aux = aux.proximo;
        }

        if (aux == null) {
            return null;
        }

        if (aux.item.getCodigo() == codigo) {
            atual = aux;
        }
        return aux.item;
    }

    public Produtos excluir(int codigo) {

        TipoNoP aux = primeiro;

        while (aux != null && aux.item.getCodigo() != codigo) {
            aux = aux.proximo;
        }

        if (aux == null) {
            return null;
        }

        if (aux.proximo != null) {
            atual = aux.proximo;
        } else {
            atual = aux.anterior;
        }

        if (aux == primeiro) {
            if (primeiro == ultimo) {
                primeiro = ultimo = null;
            }
            primeiro = aux.proximo;
            aux.anterior = null;

        } else if (aux == ultimo) {
            ultimo.anterior.proximo = null;
            ultimo = aux.anterior;
            aux.proximo = null;

        } else {
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }
        return aux.item;
    }

    public Produtos atual() {

        return atual.item;
    }

    public void gravar() {

        TipoNoP aux = primeiro;

        try {
            arquivo = new Formatter("Produtos.txt");
        } catch (Exception Excecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }

        while (aux != null) {
            arquivo.format("%d %s\n %.2f\n", aux.item.getCodigo(), aux.item.getNome(), aux.item.getPreco());
            aux = aux.proximo;
        }
        arquivo.close();
    }

    public void ler() {

        TipoNoP aux = primeiro;

        try {
            arq = new Scanner(new File("Produtos.txt"));
        } catch (Exception Excecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }

        try {
            while (arq.hasNext()) {
                inserirNoFinal(arq.nextInt(), arq.nextLine(), arq.nextDouble());
            }
        } catch (Exception minhaExcecao) {
            System.err.println("Erro ao ler o arquivo");
            System.exit(1);
        }
        arq.close();
    }

    public void imprimir() {

        TipoNoP aux = primeiro;
        System.out.println("Outfit: ");

        while (aux != null) {
            System.out.println(aux);
            aux = aux.proximo;
        }
    }
}
