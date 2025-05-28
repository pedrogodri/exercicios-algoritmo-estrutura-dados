package com.example.pilhaImplementacao;

public class PilhaVetor<T> implements IPilha<T> {
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

    public T peek(){
        if(estaVazia()){
            throw new PilhaVaziaException();
        }

        return (T) this.info[this.limite - 1];
    }

    public void push(Object valor) {
        if(this.tamanho == this.limite)
            throw new PilhaCheiaException();

        this.info[tamanho] = valor;
        tamanho++;
    }

    public T pop() {
        T valor = peek(); //já verifica se está vazia

        info[tamanho-1] = null;
        tamanho--;

        return valor;
    }

    public void liberar() {
        info = new Object[limite];
        tamanho = 0;


        //usa se a linguagem nao tem um mecanismo de apagar o "lixo"
        // for (int i = 0; i < tamanho; i++) {
        //     info[i] = null;
        // }

        // tamanho = 0;
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


    public void concatenar(PilhaVetor<T> p){
        if(this.tamanho + p.tamanho > this.limite){
            throw new RuntimeException("Não há espaço para empilhar todos os dados");
        }

        for (int i = 0; i < p.tamanho; i++) {
            this.push(p.info[i]);
        }
    }

}
