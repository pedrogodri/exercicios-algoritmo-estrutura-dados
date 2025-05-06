package main.java.com.example.ArvoresNArias;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public String toString() {
        return obterRepresentacao(raiz);
    }

    private String obterRepresentacao(NoArvore<T> no) {
        if (no == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(no.getInfo());
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            sb.append(obterRepresentacao(filho));
            filho = filho.getProximo();
        }
        sb.append(">");
        return sb.toString();
    }

    public boolean pertence(T valor) {
        return pertence(raiz, valor);
    }

    private boolean pertence(NoArvore<T> no, T valor) {
        if (no == null) return false;
        if (no.getInfo().equals(valor)) return true;
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            if (pertence(filho, valor)) return true;
            filho = filho.getProximo();
        }
        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) return 0;
        int total = 1;
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            total += contarNos(filho);
            filho = filho.getProximo();
        }
        return total;
    }
}
