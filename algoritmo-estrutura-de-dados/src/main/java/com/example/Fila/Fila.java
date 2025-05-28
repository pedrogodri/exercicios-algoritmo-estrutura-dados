package com.example.fila;

public interface Fila<T> {
    void inserir(T info);
    boolean estaVazia();
    T peek();
    T retirar();
    void liberar();
}
