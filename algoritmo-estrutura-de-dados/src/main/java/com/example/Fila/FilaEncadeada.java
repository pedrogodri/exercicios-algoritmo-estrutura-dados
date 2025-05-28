package com.example.fila;

public class FilaEncadeada<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaEncadeada(){
        lista = new ListaEncadeada<T>();
    }


    @Override
    public void inserir(T info) {
        lista.inserirNoFinal(info);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new FilaVaziaException();
        }

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor;

        valor = peek();

        lista.retirar(valor);

        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }
    
    public String toString(){
        return lista.toString(); 
    }
}
