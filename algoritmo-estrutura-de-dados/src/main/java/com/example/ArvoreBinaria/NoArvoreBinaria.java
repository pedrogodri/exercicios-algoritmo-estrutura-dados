package com.example.ArvoreBinaria;

public class NoArvoreBinaria<T> {
    private Object info;
    private Object esquerda;
    private Object direita;

    public NoArvoreBinaria(Object info) {
        this.info = info;
    }

    public NoArvoreBinaria(Object info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        this.esquerda = esq;
        this.direita = dir;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Object esquerda) {
        this.esquerda = esquerda;
    }

    public Object getDireita() {
        return direita;
    }

    public void setDireita(Object direita) {
        this.direita = direita;
    }
    
}
