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

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        NoMapa outro = (NoMapa) obj;
        if(chave != outro.chave) return false;
        return true;
    }
}
