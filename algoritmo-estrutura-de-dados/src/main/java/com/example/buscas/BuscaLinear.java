package com.example.buscas;

public class BuscaLinear<T extends Comparable<T>> extends BuscaAbstract{

    public int busca(T valor) {
        T[] info = (T[]) getInfo();
        int tamanho = info.length;

        for (int i = 0; i < tamanho; i++) {
            if(info[i] == valor){
                return i; 
            }
        }

        return -1;
    }
    
}
