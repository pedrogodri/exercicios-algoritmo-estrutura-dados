package com.example.mapaDispersao;

import com.example.fila.ListaEncadeada;

public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>> info[];

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T valor) {
        
    }

    public void remover(int chave) {

    }

    public T buscar(int chave) {

    }

    public double calcularFatorCarga() {

    }
}
