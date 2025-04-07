package com.example.PilhaImplementacao;

public class PilhaVetor {
    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite){
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public boolean estaVazia(){
        if(info == null || this.tamanho == 0){
            return true;
        }

        return false;
    }

    public Object peek(){
        if(this.tamanho == 0){
            throw new RuntimeException("Pilha está vazia");
        }

        return info[this.limite -1];
    }


}
