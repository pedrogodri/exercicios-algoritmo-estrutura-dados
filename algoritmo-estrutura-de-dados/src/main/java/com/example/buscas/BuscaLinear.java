package com.example.buscas;

public class BuscaLinear<T extends Comparable<T>> extends BuscaAbstract{

    public int busca(T valor) {
        Object[] info = getInfo();
        int tamanho = info.length-1;

        for (int i = 0; i < tamanho; i++) {
            if(info[i].equals(valor)){
                return i; 
            }
        }

        return -1;
    }
    
}