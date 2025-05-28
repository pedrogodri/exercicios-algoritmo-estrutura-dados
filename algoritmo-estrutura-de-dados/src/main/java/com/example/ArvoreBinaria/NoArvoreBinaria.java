package com.example.arvoreBinaria;

public  class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> direita;
    private NoArvoreBinaria<T> esquerda;

    public NoArvoreBinaria(T info) {
        setInfo(info);
    }
    
    public NoArvoreBinaria(
        T info, 
        NoArvoreBinaria<T> esq,
        NoArvoreBinaria<T> dir) 
    {
        setInfo(info);
        setEsquerda(esq);
        setDireita(dir);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }
    
    
}
