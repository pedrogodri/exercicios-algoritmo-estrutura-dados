package com.example.listaEncadeada;

public class ListaEncadeada {
    
    public NoLista primeiro;


    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista getPrimeiro(){
        return this.primeiro;
    }

    public boolean estaVazia(){
        if (this.primeiro == null){
            return true;
        }

        return false;
    }
    
    public void inserir(NoLista info){
        NoLista novo = new NoLista();
        novo.setInfo(info.getInfo());
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }
}
