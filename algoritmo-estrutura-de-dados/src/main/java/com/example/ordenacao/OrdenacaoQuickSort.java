package com.example.ordenacao;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(inicio, fim);
            quickSort(inicio, pivo - 1);
            quickSort(pivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T[] vetor = getInfo();
        T pivo = vetor[inicio];
        int a = inicio;
        int b = fim + 1;

        while (true) {
            while (a <= fim && vetor[a].compareTo(pivo) < 0) {
                a++;
            }
            while (b >= inicio && vetor[b].compareTo(pivo) > 0) {
                b--;
            }
            if (a >= b) {
                break;
            }
            trocar(a, b);
        }

        trocar(inicio, b);
         return b;
    }
}
