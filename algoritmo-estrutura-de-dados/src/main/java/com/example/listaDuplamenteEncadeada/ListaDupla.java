package com.example.listaDuplamenteEncadeada;

public class ListaDupla<T>{
    private NoListaDupla<T> primeiro;

    public ListaDupla(){
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro(){
        return this.primeiro;
    }

    public void inserir(T info){
        NoListaDupla<T> novo = new NoListaDupla<T>();
        novo.setInfo(info);
        novo.setProximo(this.primeiro);
        novo.setAnterior(null);

        if(this.primeiro != null)
            this.primeiro.setAnterior(novo);

        this.primeiro = novo;
    }
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = this.primeiro;
        while(p != null) {
            if(p.getInfo().equals(valor)) {
                return p;
            } 
            
            p = p.getProximo();
        }
        return null;
    }
    
    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);
        
        if(p != null) {
            if(this.primeiro.equals(p)) {
                this.primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    } 

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = this.primeiro;
        if (p != null) {
            while (p.getProximo() != null) {
                p = p.getProximo();
            }
        
            while (p != null) {
                System.out.print(p.getInfo());
                if (p.getAnterior() != null) {
                    System.out.print(", ");
                }
                p = p.getAnterior();
            }
        }
    }

    public void liberar() {
        NoListaDupla<T> p = this.primeiro;
        while (p != null) {
            NoListaDupla<T> outro = p.getProximo();
            p.setProximo(null); 
            p.setAnterior(null); 
            p = outro;
        }
        this.primeiro = null; 
    }
    public String toString(){
        String resultado = "";
        NoListaDupla<T> p = this.primeiro;

        while(p != null){
            if(!p.equals(this.primeiro)){
                resultado += ", ";
            }

            resultado += p.getInfo();
            p = p.getProximo();
        }

        return resultado;
    }
}