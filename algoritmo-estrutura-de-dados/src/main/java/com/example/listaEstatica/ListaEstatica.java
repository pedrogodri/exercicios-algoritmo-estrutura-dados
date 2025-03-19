package com.example.listaEstatica;

public class ListaEstatica {
    int[] info;
    int tamanho;

    public ListaEstatica(){
        info = new int[10];
        tamanho=0;
    }
    private void redimensionar(){
        int[] novo = new int[info.length + 10];
        for(int i = 0; i<info.length; i++){
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(int valor){
        if(tamanho == info.length){
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir(){
        for(int i=0;i<tamanho;i++){
            System.out.println(info[i]);
        }
    }

    public int buscar(int valor){
        for(int i=0; i < tamanho; i++){
            if(info[i]==valor){
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int posicao = buscar(valor);

        if (posicao > -1) {
            for(int i=posicao+1;i<tamanho;i++){
                info[i-1] = info[i];
            }
            tamanho--;
        }
    }

    public void liberar(){
        info = new int[10];
        tamanho=0;
    }



    public int obterElemento(int posicao){
        for(int i =0; i <= tamanho; i++){
            if(info[i] == info[posicao]){
                return info[posicao];
            }
        }
        if(posicao > tamanho){
            throw new IndexOutOfBoundsException("a posicao nao existe");
        }
        return -1;
    }

    

    public boolean estaVazia(){
        return tamanho==0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String resultado = "" ;
        for(int i=0;i<tamanho;i++){
            if(i>0){
                resultado += ",";
            }
            resultado+=info[i];
        }
        return resultado;
    }
}



// TIRAR DUVIDA COM PROFESSOR SOBRE OS TESTES!!!!!!!!!!!!!!!!!!!!!!!!!!