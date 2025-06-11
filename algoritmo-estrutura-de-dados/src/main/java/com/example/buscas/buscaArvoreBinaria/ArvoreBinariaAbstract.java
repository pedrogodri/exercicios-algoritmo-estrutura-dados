package com.example.buscas.buscaArvoreBinaria;

import com.example.arvoreBinaria.NoArvoreBinaria;

public abstract class ArvoreBinariaAbstract<T> {
    protected NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    public String toString() {
        return imprimirPreOrdem(this.raiz);
    }

    private String imprimirPreOrdem(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "";
        }
        return no.getInfo() + " " + imprimirPreOrdem(no.getEsquerda()) + imprimirPreOrdem(no.getDireita());
    }

    public int contarNos() {
        return contarNos(this.raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
}
