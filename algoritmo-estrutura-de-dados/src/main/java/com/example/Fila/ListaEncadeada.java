package com.example.fila;

import com.example.listaEncadeada.NoLista;

public class ListaEncadeada<T> {
    
    public NoLista<T> primeiro;
    public NoLista<T> ultimo;


    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public NoLista<T> getPrimeiro(){
        return this.primeiro;
    }

    public boolean estaVazia(){
        return this.primeiro == null;
    }
    
    public void inserir(T info){
        NoLista<T> novo = new NoLista<>();

        if(estaVazia())
            ultimo = novo;

        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public NoLista<T> buscar(T info){
        NoLista<T> p = primeiro;
        while (p != null) {
            if(p.getInfo().equals(info)){
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

        while(p != null && !(p.getInfo().equals(info))){
            anterior = p;
            p = p.getProximo();
        }

        if(p != null){
            if(p == this.primeiro){
                this.primeiro = p.getProximo();
            }else{
                anterior.setProximo(p.getProximo());
            }

            if(p == ultimo){
                ultimo = anterior;
            }
        }
    }

    public int obterComprimento(){
        int comprimento = 0;
        NoLista<T> p = primeiro;

        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }

        return comprimento;
    }

    public NoLista<T> obterNo2(int index){
        //não é bom fazer assim 
        int comprimento = obterComprimento();
        NoLista<T> p = primeiro;
        NoLista<T> noEncontrado = null;

        if(index < 0 || index >= comprimento){
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

    public NoLista<T> obterNo(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException("Index não é uma posição válida na lista.");
        }

        NoLista<T> p = primeiro;
    
        while(p!= null && index > 0){
            index--;
            p = p.getProximo();
        }
      
        if(p == null){
            throw new IndexOutOfBoundsException("Index não é uma posição válida na lista.");
        }
        return p;
    }

    public void exibir(){
        NoLista<T> p = primeiro;
        while(p != null){
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }   

    public String toString(){
        String resultado = "";
        NoLista<T> p = primeiro;

        while(p != null){
            if(p != primeiro){
                resultado += ",";
            }

            resultado += p.getInfo();
            p = p.getProximo();
        }

        return resultado;
    }

    public void inserirNoFinal(T valor){
        NoLista<T> novo = new NoLista<>();

        

        novo.setInfo(valor);
        novo.setProximo(null);


        if(estaVazia())
            primeiro = novo;
        else
            ultimo.setProximo(novo);

        ultimo = novo;
    }
}
