package com.example.ordenacao;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        mergeSort(0, getInfo().length - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(int inicio, int meio, int fim) {
        T[] vetor = getInfo();
        int tamEsq = meio - inicio + 1;
        int tamDir = fim - meio;

        T[] esq = (T[]) new Comparable[tamEsq];
        T[] dir = (T[]) new Comparable[tamDir];

        for (int i = 0; i < tamEsq; i++) {
            esq[i] = vetor[inicio + i];
        }
        for (int j = 0; j < tamDir; j++) {
            dir[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;
        while (i < tamEsq && j < tamDir) {
            if (esq[i].compareTo(dir[j]) <= 0) {
                vetor[k++] = esq[i++];
            } else {
                vetor[k++] = dir[j++];
            }
        }

        while (i < tamEsq) {
            vetor[k++] = esq[i++];
        }

        while (j < tamDir) {
            vetor[k++] = dir[j++];
        }
    }
}
