package com.example.buscas;

public class BuscaBinaria<T> extends BuscaAbstract {
    public int buscar(T valor){
        T[] info = (T[]) getInfo();

        int inicio = 0;
        int fim = info.length - 1;

        while(inicio <= fim){
            int meio = (inicio + fim) / 2;

            if(valor.compareTo(info[meio]) == 0) {
                return meio; // Valor encontrado
            } else if(valor.compareTo(info[meio]) < 0) {
                fim = meio - 1; // Busca na metade esquerda
            } else {
                inicio = meio + 1; // Busca na metade direita
            }
        }

        return -1; // Valor não encontrado
    }
}
