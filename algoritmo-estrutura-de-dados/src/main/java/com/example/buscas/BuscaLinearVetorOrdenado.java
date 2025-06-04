package com.example.buscas;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract {

    public int buscar(T valor) {
        T[] info = (T[]) getInfo();
        int tamanho = info.length;

        for (int i = 0; i < info.length; i++) {
            if(info[i] == valor){
                return i;
            }
            else{
                if(valor.compareTo(info[i]) < 0){
                    break;
                }
            }
        }

        return -1; // Chave não encontrada
    }
}
