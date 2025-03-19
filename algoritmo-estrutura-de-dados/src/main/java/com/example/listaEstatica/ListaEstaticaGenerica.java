package com.example.listaEstatica;

public class ListaEstaticaGenerica {
    Object[] info;
    int tamanho;

    public ListaEstaticaGenerica(){
        info = new Object[10];
        tamanho=0;
    }
    private void redimensionar(){
        Object[] novo = new Object[info.length + 10];
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

    public int buscar(Object valor){
        for(int i=0; i < tamanho; i++){
            if(info[i].equals(valor)){
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
        info = new Object[10];
        tamanho=0;
    }



    public Object obterElemento(int posicao){
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

    public void inverter(){
        int esquerda = 0;
        int direita = tamanho - 1;
        int qtdTrocas = tamanho / 2;
        Object backup;
        while(qtdTrocas > 0){
            backup = info[esquerda];
            info[esquerda] = info[direita];
            info[direita] = info[esquerda];

            esquerda ++;
            direita--;

            qtdTrocas--;
        }
    } 
}



// TIRAR DUVIDA COM PROFESSOR SOBRE OS TESTES!!!!!!!!!!!!!!!!!!!!!!!!!!