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

    public void remover(T valor) {
        this.raiz = remover(this.raiz, valor);
    }

    private NoArvoreBinaria<T> remover(NoArvoreBinaria<T> no, T valor) {
        if (no == null) {
            return null;
        }
        int cmp = valor.compareTo(no.getInfo());
        if (cmp < 0) {
            no.setEsquerda(remover(no.getEsquerda(), valor));
        } else if (cmp > 0) {
            no.setDireita(remover(no.getDireita(), valor));
        } else {
            // Caso 1: nó folha
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }
            // Caso 2: só tem um filho
            if (no.getEsquerda() == null) {
                return no.getDireita();
            }
            if (no.getDireita() == null) {
                return no.getEsquerda();
            }
            // Caso 3: dois filhos
            // Encontrar o menor da subárvore direita
            NoArvoreBinaria<T> sucessor = no.getDireita();
            while (sucessor.getEsquerda() != null) {
                sucessor = sucessor.getEsquerda();
            }
            no.setInfo(sucessor.getInfo());
            no.setDireita(remover(no.getDireita(), sucessor.getInfo()));
        }
        return no;
    }
}
