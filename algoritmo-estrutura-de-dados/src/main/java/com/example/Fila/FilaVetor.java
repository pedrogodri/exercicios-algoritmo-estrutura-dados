package com.example.Fila;

public class FilaVetor implements Fila {
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
    public void inserir(Object info) {
        if(this.tamanho == this.limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir;
        posicaoInserir = (this.inicio + this.tamanho) % this.limite;
        this.info[posicaoInserir] = info;
        this.tamanho += 1;
    }

    @Override
    public boolean estaVazia() {
        if(info == null || this.tamanho == 0){
            return true;
        }

        return false;
    }

    @Override
    public Object peek() {
        if(estaVazia())
            throw new FilaVaziaException();
        return this.info[this.inicio];
    }

    @Override
    public Object retirar() {
        int valor = (int) peek();
        this.inicio = (this.inicio + 1) % this.limite;
        this.tamanho = this.tamanho - 1;
        return valor;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }
    
    public String toString(){
        String resultado = "";

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];

            if(i > 0)
                resultado += ", ";
        }

        return resultado;
    }
}
