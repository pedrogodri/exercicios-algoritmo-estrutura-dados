package com.example.listaDuplamenteEncadeada;

public class NoListaDupla<T>{
    private T info;
    private NoListaDupla<T> anterior;
    private NoListaDupla<T> proximo;

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return this.info;
    }

    public void setProximo(NoListaDupla<T> proximo){
        this.proximo = proximo;
    }

    public NoListaDupla<T> getProximo(){
        return this.proximo;
    }

    public void setAnterior(NoListaDupla<T> anterior){
        this.anterior = anterior;
    }

    public NoListaDupla<T> getAnterior(){
        return this.anterior;
    }

}