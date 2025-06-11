package com.example.buscas.buscaArvoreBinaria;

import com.example.arvoreBinaria.NoArvoreBinaria;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(this.raiz, info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }
        if (no.getInfo().equals(info)) {
            return no;
        }
        NoArvoreBinaria<T> esquerda = buscar(no.getEsquerda(), info);
        if (esquerda != null) {
            return esquerda;
        }
        return buscar(no.getDireita(), info);
    }
}
