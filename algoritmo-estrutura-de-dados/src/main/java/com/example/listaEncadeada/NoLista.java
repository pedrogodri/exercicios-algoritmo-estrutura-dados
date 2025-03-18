package com.example.listaEncadeada;

public class NoLista<T> {
    private T info;
    private NoLista<T> proximo;
    
    public NoLista() {
    }

    public T getInfo(){
        return this.info;
    }

    public void setInfo(T alteraInfo){
        this.info = alteraInfo;
    }

    public NoLista<T> getProximo(){
        return this.proximo;
    }

    public void setProximo(NoLista<T> info){
        this.proximo = info;
    }
}
