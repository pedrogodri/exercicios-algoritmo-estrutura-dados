package com.example.listaEncadeada;

public class ListaEncadeada<T> {
    
    public NoLista<T> primeiro;


    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro(){
        return this.primeiro;
    }

    public boolean estaVazia(){
        if (this.primeiro == null){
            return true;
        }
        return false;
    }
    
    public void inserir(NoLista<T> info){
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info.getInfo());
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public NoLista<T> buscar(T info){
        NoLista<T> p = primeiro;
        while (p != null) {
            if(p.getInfo() == info){
                return p;
            }

            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info){
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        // NoLista<T> registroEncontrado = buscar(info);  

        // if(registroEncontrado != null){

        // }

        while(p != null && p.getInfo() != info){
            anterior = p;
            p = p.getProximo();
        }

        if(p != null){
            if(p == this.primeiro){
                this.primeiro = p.getProximo();
            }else{
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento(){
        int comprimento = 0;
        NoLista<T> p = primeiro;

        while (p != null) {
            comprimento++;

            if(p.getProximo() == null){
                return comprimento;
            }    
            
            p = p.getProximo();
        }

        return comprimento;
    }

    public NoLista<T> obterNo(int index){
        int comprimento = obterComprimento();
        NoLista<T> p = primeiro;
        NoLista<T> noEncontrado = null;

        if(index < 0 || index > comprimento){
            throw new IndexOutOfBoundsException("Index não é uma posição válida na lista.");
        }

        for (int i = 0; i < comprimento; i++) {
            if(index == i){
                noEncontrado = p;
                break;
            }

            p = p.getProximo();
        }
      
        return noEncontrado;
    }

}
