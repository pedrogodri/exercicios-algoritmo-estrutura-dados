package com.example.listaEncadeada;

public class NoLista {
    private int info;
    private NoLista proximo;
    
    public NoLista() {
    }

    public int getInfo(){
        return this.info;
    }

    public void setInfo(int alteraInfo){
        this.info = alteraInfo;
    }

    public NoLista getProximo(){
        return this.proximo;
    }

    public void setProximo(NoLista info){
        this.proximo = info;
    }
}
