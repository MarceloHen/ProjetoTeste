package controller;

import model.Cadastros;

public class TipoNoC {

    private TipoNoC proximo;
    private TipoNoC anterior;
    private Cadastros cad;

    public TipoNoC() {
    }

    public TipoNoC(TipoNoC proximo, TipoNoC anterior, Cadastros cad) {
        
        this.proximo = proximo;
        this.anterior = anterior;
        this.cad = cad;
    }

    public TipoNoC(int id, String nome, String sobrenome, String usuario, String senha, String confsenha, String email) {

        cad = new Cadastros(id, nome, sobrenome, usuario, senha, confsenha, email);
        this.proximo = null;
        this.anterior = null;
    }

    public TipoNoC getProximo() {
        return proximo;
    }

    public void setProximo(TipoNoC proximo) {
        this.proximo = proximo;
    }

    public TipoNoC getAnterior() {
        return anterior;
    }

    public void setAnterior(TipoNoC anterior) {
        this.anterior = anterior;
    }

    public Cadastros getCad() {
        return cad;
    }

    public void setCad(Cadastros cad) {
        this.cad = cad;
    }

    public String toString() {
        return getCad().toString();
    }
}
