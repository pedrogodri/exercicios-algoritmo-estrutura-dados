package com.example.ordenacao;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {

        T[] vetor = getInfo();
        for (int i = vetor.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
