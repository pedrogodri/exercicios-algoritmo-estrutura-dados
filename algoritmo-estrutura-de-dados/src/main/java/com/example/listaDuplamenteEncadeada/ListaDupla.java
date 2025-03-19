package com.example.listaDuplamenteEncadeada;

public class ListaDupla<T>{
    private NoListaDupla<T> primeiro;


    public ListaDupla(){
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro(){
        return this.primeiro;
    }

    public void inserir(T info){
        NoListaDupla<T> novo = new NoListaDupla<T>();
        novo.setProximo(this.primeiro);
        novo.setAnterior(null);

        

    }
}