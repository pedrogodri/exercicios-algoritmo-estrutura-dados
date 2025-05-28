package com.example.fila;

public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite){
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T info) {
        if(this.tamanho == this.limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir;
        posicaoInserir = (this.inicio + this.tamanho) % this.limite;
        this.info[posicaoInserir] = info;
        this.tamanho++;
    }

    @Override
    public boolean estaVazia() {
        if(info == null || this.tamanho == 0)
            return true;

        return false;
    }

    @Override
    public T peek() {
        if(estaVazia())
            throw new FilaVaziaException();
        return (T) this.info[this.inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();

        info[inicio] = null;
        this.inicio = (this.inicio + 1) % this.limite;
        this.tamanho--;

        return valor;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }
    
    public String toString(){
        String resultado = "";

        int posicao = inicio;
        for (int i = 0; i < tamanho; i++) {
            if(i > 0)
                resultado += ", ";

            resultado += info[posicao];
            posicao = (posicao + 1) % limite;
        }

        return resultado;
    }
    
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> fila2){
        FilaVetor<T> f3 = new FilaVetor<T>(limite + fila2.limite);

        int posicao = inicio;
        for (int i = 0; i < tamanho; i++) {
            f3.inserir((T)info[posicao]);
            posicao = (posicao +1) % limite;
        }

        posicao = fila2.inicio;
        for (int i = 0; i < fila2.tamanho; i++) {
            f3.inserir((T)fila2.info[posicao]);
            posicao = (posicao +1) % fila2.limite;
        }

        return f3;
    }
}
