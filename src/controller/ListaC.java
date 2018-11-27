/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cadastros;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Marcelo
 */
public class ListaC {

    TipoNoC primeiro;
    TipoNoC ultimo;
    TipoNoC atual;
    Formatter arquivo;
    Scanner arq;
    private int ultimoid;

    public ListaC() {

        primeiro = ultimo = null;
    }

    public boolean Vazia() {

        return primeiro == null;
    }

    public int inserirNoInicio(String nome, String sobrenome, String usuario, String senha, String confsenha, String email) {

        ultimoid++;
        
        TipoNoC no = new TipoNoC(ultimoid, nome, sobrenome, usuario, senha, confsenha, email);
        no.setProximo(primeiro);
        //no.getProximo() = primeiro;

        if (Vazia()) {
            ultimo = no;
        } else {
            primeiro.setAnterior(no);
            //primeiro.getAnterior() = no;
        }
        primeiro = no;
        return ultimoid;
    }

    public int inserirNoFinal(String nome, String sobrenome, String usuario, String senha, String confsenha, String email) {

        ultimoid++;
        return inserirNoFinal(ultimoid, nome, sobrenome, usuario, senha, confsenha, email);
    }

    public int inserirNoFinal(int id, String nome, String sobrenome, String usuario, String senha, String confsenha, String email) {

        TipoNoC no = new TipoNoC(id, nome, sobrenome, usuario, senha, confsenha, email);
        atual = no;

        if (Vazia()) {
            primeiro = no;
        } else {
            no.setAnterior(ultimo);
            //no.getAnterior() = ultimo;
            //ultimo.getProximo() = no;
            ultimo.setProximo(no);
        }
        ultimo = no;
        return id;
    }

    public Cadastros primeiro() {

        if (primeiro != null) {
            atual = primeiro;
            return atual.getCad();

        } else {
            return null;
        }
    }

    public Cadastros ultimo() {

        if (ultimo != null) {
            atual = ultimo;
            return atual.getCad();
        } else {
            return null;
        }
    }

    public Cadastros proximo() {

        if (atual != null && atual.getProximo() != null) {
            atual = atual.getProximo();
            return atual.getCad();
        } else {
            return null;
        }
    }

    public Cadastros anterior() {

        if (atual != null && atual.getAnterior() != null) {
            atual = atual.getAnterior();
            return atual.getCad();
        } else {
            return null;
        }
    }

    public Cadastros localizar(int id) {

        TipoNoC aux = primeiro;

        while (aux != null && aux.getCad().getId() != id) {
            aux = aux.getProximo();

        }

        if (aux == null) {
            return null;
        }

        if (aux.getCad().getId() == id) {
            atual = aux;
        }
        return aux.getCad();
    }

    public Cadastros excluir(int id) {

        TipoNoC aux = primeiro;

        while (aux != null && aux.getCad().getId() != id) {
            aux = aux.getProximo();
        }

        if (aux == null) {
            return null;
        }

        if (aux.getProximo() != null) {
            atual = aux.getProximo();
        } else {
            atual = aux.getAnterior();
        }

        if (aux == primeiro) {
            if (primeiro == ultimo) {
                primeiro = ultimo = null;
            }
            primeiro = aux.getProximo();
            aux.setAnterior(null);
            //aux.anterior = null;

        } else if (aux == ultimo) {
            ultimo.setAnterior(null);
            ultimo.setProximo(null);
            //ultimo.anterior.proximo = null;
            ultimo = aux.getAnterior();
            //aux.proximo = null;
            aux.setProximo(null);

        } else {
            aux.setAnterior(aux.getProximo());
            aux.setProximo(aux.getProximo());
            //aux.anterior.proximo = aux.getProximo();
            aux.setProximo(aux.getAnterior());
            aux.setAnterior(aux.getAnterior());
            //aux.proximo.anterior = aux.getAnterior();
        }
        return aux.getCad();
    }

    public Cadastros atual() {

        return atual.getCad();
    }

    public void gravar() {

        TipoNoC aux = primeiro;

        try {
            arquivo = new Formatter("Cadastros.txt");
        } catch (Exception Excecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }

        while (aux != null) {
            arquivo.format("%d %s\n %s\n %s\n %s\n %s\n", aux.getCad().getId(), aux.getCad().getNome(), aux.getCad().getSobrenome(), aux.getCad().getUsuario(), aux.getCad().getSenha(), aux.getCad().getEmail());
            aux = aux.getProximo();
        }
        arquivo.close();
    }

    public void ler() {

        TipoNoC aux = primeiro;

        try {
            arq = new Scanner(new File("Cadastros.txt"));
        } catch (Exception Excecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }

        try {
            while (arq.hasNext()) {
                inserirNoFinal(arq.nextInt(), arq.nextLine(), arq.nextLine(), arq.nextLine(), arq.nextLine(), arq.nextLine(), arq.nextLine());
            }
        } catch (Exception minhaExcecao) {
            System.err.println("Erro ao ler o arquivo");
            System.exit(1);
        }
        arq.close();
    }

    public void imprimir() {

        TipoNoC aux = primeiro;
        System.out.println("Cadastros: ");

        while (aux != null) {
            System.out.println(aux);
            aux = aux.getProximo();
        }
    }
}
