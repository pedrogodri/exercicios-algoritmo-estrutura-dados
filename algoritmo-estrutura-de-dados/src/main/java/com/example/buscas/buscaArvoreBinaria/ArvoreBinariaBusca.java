package com.example.buscas.buscaArvoreBinaria;

import com.example.arvoreBinaria.NoArvoreBinaria;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        this.raiz = inserir(this.raiz, info);
    }

    private NoArvoreBinaria<T> inserir(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return new NoArvoreBinaria<>(info);
        }
        if (info.compareTo(no.getInfo()) < 0) {
            no.setEsquerda(inserir(no.getEsquerda(), info));
        } else if (info.compareTo(no.getInfo()) > 0) {
            no.setDireita(inserir(no.getDireita(), info));
        }
        return no;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(this.raiz, info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null || no.getInfo().equals(info)) {
            return no;
        }
        if (info.compareTo(no.getInfo()) < 0) {
            return buscar(no.getEsquerda(), info);
        }
        return buscar(no.getDireita(), info);
    }
}
