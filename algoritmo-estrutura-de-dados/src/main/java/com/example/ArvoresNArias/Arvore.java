package com.example.arvoresNArias;

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

    public boolean estaVazia(){
        return raiz == null;
    }

    public String toString() {
        if(estaVazia()){
            return "";
        }
        else{
            return obterRepresentacaoTextual(raiz);
        }
        
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        // StringBuilder sb = new StringBuilder();
        // sb.append("<").append(no.getInfo());
        // NoArvore<T> filho = no.getPrimeiro();
        // while (filho != null) {
        //     sb.append(obterRepresentacaoTextual(filho));
        //     filho = filho.getProximo();
        // }
        // sb.append(">");
        // return sb.toString();

        String s = "<" + no.getInfo();

        NoArvore<T> p;
        p = no.getPrimeiro();

        while (p != null) {
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s += ">";

        return s;
    }

    public boolean pertence(T valor) {
        if(estaVazia())
            return false;
        return pertence(raiz, valor);
    }

    private boolean pertence(NoArvore<T> no, T valor) {

        if (no.getInfo().equals(valor)) 
            return true;

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            if (pertence(filho, valor))            
                return true;

            filho = filho.getProximo();
        }

        return false;
    }

    public int contarNos() {
        if(estaVazia())
            return 0;

        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {

        int total = 1;
        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            total += contarNos(filho);
            filho = filho.getProximo();
        }
        return total;
    }

}

/* 
// 2. Retorna a altura da árvore
public int altura() {
    return altura(raiz);
}

private int altura(NoArvore<T> no) {
    if (no == null) return -1;
    int maxAltura = -1;
    NoArvore<T> filho = no.getPrimeiro();
    while (filho != null) {
        maxAltura = Math.max(maxAltura, altura(filho));
        filho = filho.getProximo();
    }
    return maxAltura + 1;
}

// 3. Conta quantos nós são folhas (sem filhos)
public int contarFolhas() {
    return contarFolhas(raiz);
}

private int contarFolhas(NoArvore<T> no) {
    if (no == null) return 0;
    if (no.getPrimeiro() == null) return 1;
    int total = 0;
    NoArvore<T> filho = no.getPrimeiro();
    while (filho != null) {
        total += contarFolhas(filho);
        filho = filho.getProximo();
    }
    return total;
}

// 4. Retorna a referência para o nó que contém o valor (ou null)
public NoArvore<T> buscarNo(T valor) {
    return buscarNo(raiz, valor);
}

private NoArvore<T> buscarNo(NoArvore<T> no, T valor) {
    if (no == null) return null;
    if (no.getInfo().equals(valor)) return no;
    NoArvore<T> filho = no.getPrimeiro();
    while (filho != null) {
        NoArvore<T> resultado = buscarNo(filho, valor);
        if (resultado != null) return resultado;
        filho = filho.getProximo();
    }
    return null;
}

// 5. Percurso em largura (nível a nível)
public String percursoLargura() {
    if (raiz == null) return "";
    StringBuilder sb = new StringBuilder();
    java.util.Queue<NoArvore<T>> fila = new java.util.LinkedList<>();
    fila.add(raiz);
    while (!fila.isEmpty()) {
        NoArvore<T> atual = fila.poll();
        sb.append(atual.getInfo()).append(" ");
        NoArvore<T> filho = atual.getPrimeiro();
        while (filho != null) {
            fila.add(filho);
            filho = filho.getProximo();
        }
    }
    return sb.toString().trim();
}

// 6. Retorna o nível de um valor (0 para raiz, -1 se não encontrado)
public int nivel(T valor) {
    return nivel(raiz, valor, 0);
}

private int nivel(NoArvore<T> no, T valor, int nivelAtual) {
    if (no == null) return -1;
    if (no.getInfo().equals(valor)) return nivelAtual;
    NoArvore<T> filho = no.getPrimeiro();
    while (filho != null) {
        int resultado = nivel(filho, valor, nivelAtual + 1);
        if (resultado != -1) return resultado;
        filho = filho.getProximo();
    }
    return -1;
}

// 7. Verifica se outra árvore é igual (estrutura e valores)
public boolean igual(Arvore<T> outra) {
    return igual(this.raiz, outra.getRaiz());
}

private boolean igual(NoArvore<T> no1, NoArvore<T> no2) {
    if (no1 == null && no2 == null) return true;
    if (no1 == null || no2 == null) return false;
    if (!no1.getInfo().equals(no2.getInfo())) return false;
    return igual(no1.getPrimeiro(), no2.getPrimeiro()) &&
           igual(no1.getProximo(), no2.getProximo());
}

// 8. Retorna o maior valor (assumindo que T é Comparable)
public T maiorValor() {
    if (raiz == null) return null;
    if (!(raiz.getInfo() instanceof Comparable))
        throw new IllegalStateException("Tipo não comparável.");
    return maiorValor(raiz);
}

@SuppressWarnings("unchecked")
private T maiorValor(NoArvore<T> no) {
    T max = no.getInfo();
    NoArvore<T> filho = no.getPrimeiro();
    while (filho != null) {
        T maiorFilho = maiorValor(filho);
        if (((Comparable<T>) maiorFilho).compareTo(max) > 0) {
            max = maiorFilho;
        }
        filho = filho.getProximo();
    }
    return max;
}

// 9. Retorna uma lista com os valores por nível
public java.util.List<java.util.List<T>> listarPorNivel() {
    java.util.List<java.util.List<T>> resultado = new java.util.ArrayList<>();
    if (raiz == null) return resultado;

    java.util.Queue<NoArvore<T>> fila = new java.util.LinkedList<>();
    fila.add(raiz);

    while (!fila.isEmpty()) {
        int tamanhoNivel = fila.size();
        java.util.List<T> nivelAtual = new java.util.ArrayList<>();

        for (int i = 0; i < tamanhoNivel; i++) {
            NoArvore<T> atual = fila.poll();
            nivelAtual.add(atual.getInfo());

            NoArvore<T> filho = atual.getPrimeiro();
            while (filho != null) {
                fila.add(filho);
                filho = filho.getProximo();
            }
        }
        resultado.add(nivelAtual);
    }

    return resultado;
}

public void exibirPaisEFIlhos() {
    exibirPaisEFIlhos(raiz);
}

private void exibirPaisEFIlhos(NoArvore<T> no) {
    if (no == null) return;

    System.out.print("Pai: " + no.getInfo() + " → Filhos: ");
    NoArvore<T> filho = no.getPrimeiro();
    if (filho == null) {
        System.out.println("(nenhum)");
    } else {
        while (filho != null) {
            System.out.print(filho.getInfo());
            filho = filho.getProximo();
            if (filho != null) System.out.print(", ");
        }
        System.out.println();
    }

    // Chamada recursiva para os filhos
    filho = no.getPrimeiro();
    while (filho != null) {
        exibirPaisEFIlhos(filho);
        filho = filho.getProximo();
    }
}
*/

//a gente usa a recursidade quando precisamo voltar para o nivel alterior da arvore sem precisar implementar uma pilha

//QUANTAS VEZES É CHAMADA O METODO RECURSIVO?

/* Arvore Binaria
 * Duas chamas para cada nó + uma chamada para o nó
 * 
 * 
 * 
 * Arvore N-aria
 * Uma chamada para cada nó
 */