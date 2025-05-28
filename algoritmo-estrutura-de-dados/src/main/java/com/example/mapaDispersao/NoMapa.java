package com.example.mapaDispersao;

public class NoMapa<T> {
    private int chave;
    private T valor;

    public int getChave() {
        return chave;
    }
    
    public void setChave(int chave) {
        this.chave = chave;
    }
    
    public T getValor() {
        return valor;
    }
    
    public void setValor(T valor) {
        this.valor = valor;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        NoMapa outro = (NoMapa) o;
        if(chave != outro.chave) return false;
        return true;
    }
}
