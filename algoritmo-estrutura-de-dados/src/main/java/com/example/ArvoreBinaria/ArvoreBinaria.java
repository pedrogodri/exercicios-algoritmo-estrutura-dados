package com.example.ArvoreBinaria;

public class ArvoreBinaria<T> {
    
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {}

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public boolean pertence(T info) {
        return false;
    }

    private boolean pertence(NoArvoreBinaria<T> no, T infp) {
        return false;
    }

    public String toString(){
        String resultado = "";
        return resultado;
    }

    private String arvorePre(ArvoreBinaria<T> no) {
        return null;
    }

    public int contarNos() {
        return 0;
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        return 0;
    }
}
