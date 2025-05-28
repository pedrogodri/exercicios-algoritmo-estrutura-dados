package com.example.arvoreBinaria;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
    
    public boolean estaVazia() {
        return raiz == null;
    }
    
    public boolean pertence(T info) {
        return pertence(raiz, info);
    }
    
    public boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }
        else {
            return (no.getInfo() == info) 
                || pertence(no.getEsquerda(), info) 
                || pertence(no.getDireita(), info);
        }
    }
    
    @Override
    public String toString() {
        return arvorePre(raiz);
    } 
    
    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        else {
            return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
        }
    }
    
    public Integer contarNos() {
        return contarNos(raiz);
    }
    
    private Integer contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        else {
            return contarNos(no.getEsquerda()) + contarNos(no.getDireita()) + 1;
        }
    }
}
