package com.example.pilhaImplementacao;

import com.example.listaEncadeada.ListaEncadeada;

public class PilhaLista<T> implements IPilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();

        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia())
            throw new PilhaVaziaException();

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();

        try{
            while (true) {
                pop();
            }
        }catch (PilhaVaziaException e){

        }
    }

    public String toString(){
        return lista.toString();
    }

    
    
}
