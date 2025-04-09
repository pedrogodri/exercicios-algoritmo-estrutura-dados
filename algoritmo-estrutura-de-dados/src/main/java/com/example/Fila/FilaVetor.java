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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public Object retirar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retirar'");
    }

    @Override
    public void liberar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'liberar'");
    }
    
}
