package com.example.mapaDispersao;

import com.example.fila.ListaEncadeada;
import com.example.listaEncadeada.NoLista;

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
        int indice = calcularHash(chave);

        if(info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> novoNo = new NoMapa<>();
        novoNo.setChave(chave);
        novoNo.setValor(valor);

        info[indice].inserir(novoNo);
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        if(info[indice] != null) {
            NoMapa<T> noParaRemover = new NoMapa<>();
            noParaRemover.setChave(chave);
            info[indice].retirar(noParaRemover);
        }
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);

        if(info[indice] != null) {
            NoMapa<T> noParaBuscar = new NoMapa<>();
            noParaBuscar.setChave(chave);

            NoLista<NoMapa<T>> resultado = info[indice].buscar(noParaBuscar);
            if(resultado != null) {
                return resultado.getInfo().getValor();
            }
        }
        return null;
    }

    public double calcularFatorCarga() {
        int totalElementos = 0;
        int tamanhoMapa = info.length;

        for(int i = 0; i < tamanhoMapa; i++) {
            if(info[i] != null) {
                totalElementos += info[i].obterComprimento();
            }
        }

        return (1.0) * totalElementos / tamanhoMapa;
    }
}
