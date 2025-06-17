package com.example.buscas.buscaArvoreBinaria;

import com.example.arvoreBinaria.NoArvoreBinaria;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    /**
     * Insere um novo elemento na árvore binária de busca utilizando um algoritmo iterativo.
     * Este método localiza a posição correta para adicionar o novo nó.
     * Algoritmo: inserir(int valor) - Iterativo
     *
     * @param info O elemento a ser inserido.
     */
    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info); // NoArvoreBinaria novo = new NoArvoreBinaria(valor);

        // Se a árvore estiver vazia, o novo nó se torna a raiz.
        if (this.raiz == null) { // Se (raiz = null) então
            this.raiz = novo; // raiz ← novo;
            return; // retornar;
        }

        NoArvoreBinaria<T> p = this.raiz; // p ← raiz;
        NoArvoreBinaria<T> pai = null; // pai ← null; (Usado para manter o nó pai de 'p')

        // Loop infinito que é quebrado quando o nó é inserido
        while (true) { // enquanto (verdadeiro) faça
            pai = p; // pai ← p;

            // Compara o valor a ser inserido com o valor do nó atual 'p'.
            int cmp = info.compareTo(p.getInfo());

            if (cmp < 0) { // se (valor < p.info) então (Vai para a subárvore esquerda)
                p = p.getEsquerda(); // p ← pai.esquerda; (p recebe o filho esquerdo do pai)

                // Se o filho esquerdo for nulo, encontramos o local de inserção.
                if (p == null) { // se (p = null) então
                    pai.setEsquerda(novo); // pai.esquerda ← novo;
                    return; // retornar;
                }
            } else { // senão (Valor é maior ou igual, vai para a subárvore direita)
                p = p.getDireita(); // p ← pai.direita; (p recebe o filho direito do pai)

                // Se o filho direito for nulo, encontramos o local de inserção.
                if (p == null) { // se (p = null) então
                    pai.setDireita(novo); // pai.direita ← novo;
                    return; // retornar;
                }
            }
        } // fim-enquanto;
    }

    /**
     * Busca um nó que contém a informação especificada na árvore binária de busca.
     * Este método utiliza um algoritmo recursivo.
     * Algoritmo: buscar(NoArvore no, int valor) - Recursivo
     *
     * @param info A informação a ser buscada.
     * @return O NoArvoreBinaria<T> contendo a informação se encontrado, caso contrário, null.
     */
    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscarRecursivo(this.raiz, info);
    }

    /**
     * Método auxiliar recursivo para buscar um elemento na subárvore enraizada em 'no'.
     *
     * @param no   O nó atual sendo examinado.
     * @param info A informação a ser buscada.
     * @return O NoArvoreBinaria<T> contendo a informação se encontrado, caso contrário, null.
     */
    private NoArvoreBinaria<T> buscarRecursivo(NoArvoreBinaria<T> no, T info) {
        // se (no = null) então retornar null;
        if (no == null) {
            return null;
        }

        // se (valor = no.info) então retornar no;
        if (info.equals(no.getInfo())) {
            return no;
        }

        // se (valor < no.info) então retornar buscar(no.esquerda, valor);
        // senão retornar buscar(no.direita, valor);
        if (info.compareTo(no.getInfo()) < 0) {
            return buscarRecursivo(no.getEsquerda(), info);
        } else {
            return buscarRecursivo(no.getDireita(), info);
        }
    }

    /**
     * Busca um nó que contém a informação especificada na árvore binária de busca.
     * Este método utiliza um algoritmo iterativo.
     * Algoritmo: buscar(int valor) - Iterativo
     *
     * @param info A informação a ser buscada.
     * @return O NoArvoreBinaria<T> contendo a informação se encontrado, caso contrário, null.
     */
    public NoArvoreBinaria<T> buscarIterativo(T info) {
        NoArvoreBinaria<T> p = this.raiz; // p ← raiz;

        // enquanto (p ≠ null) e (p.info ≠ valor) faça
        while (p != null && !p.getInfo().equals(info)) {
            if (info.compareTo(p.getInfo()) < 0) { // se (valor < p.info) então
                p = p.getEsquerda(); // p ← p.esquerda;
            } else { // senão
                p = p.getDireita(); // p ← p.direita;
            }
        } // fim-se; fim-se;

        return p; // retornar p;
    }

    /**
     * Remove um nó com o valor fornecido da árvore binária de busca.
     * Este método implementa o algoritmo de remoção iterativo conforme os slides.
     *
     * @param valor O valor do nó a ser removido.
     */
    public void remover(T valor) {
        NoArvoreBinaria<T> p = this.raiz; // p ← raiz;
        NoArvoreBinaria<T> pai = null; // pai ← null;
        boolean filhoEsquerda = false; // Flag para indicar se 'p' é filho esquerdo do 'pai'

        // 1) Localizar o nó a ser removido
        // enquanto (p ≠null) e (p.info ≠ valor) faça
        while (p != null && !p.getInfo().equals(valor)) {
            pai = p; // pai ← p;
            if (valor.compareTo(p.getInfo()) < 0) { // se (valor < p.info) então
                filhoEsquerda = true; // filhoEsquerda ← verdadeiro;
                p = p.getEsquerda(); // p ← p.esquerda;
            } else { // senão
                filhoEsquerda = false; // filhoEsquerda ← falso;
                p = p.getDireita(); // p ← p.direita;
            }
        } // fim-enquanto;

        // Se p for null, o valor não foi encontrado na árvore
        if (p == null) { // se (p ≠ null) então
            return; // O valor não foi encontrado, então não há o que remover.
        }

        // Ao encontrar o nó (p), considera os três casos.
        // Caso 1: O nó a ser removido é uma folha (não tem filhos).
        if (p.getEsquerda() == null && p.getDireita() == null) { // se (p.esquerda = null) e (p.direita = null) então
            if (p == raiz) { // se (p = raiz) então
                raiz = null; // raiz ← null;
            } else { // senão
                if (filhoEsquerda) { // se (filhoEsquerda = verdadeiro) então
                    pai.setEsquerda(null); // pai.esquerda ← null;
                } else { // senão
                    pai.setDireita(null); // pai.direita ← null;
                }
            }
        }
        // Caso 2: O nó a ser removido tem apenas um filho.
        // se (p.direita = null) então (Nó tem apenas filho esquerdo)
        else if (p.getDireita() == null) {
            if (p == raiz) { // se (p = raiz) então
                raiz = p.getEsquerda(); // raiz ← p.esquerda;
            } else { // senão
                if (filhoEsquerda) { // se (filhoEsquerda = verdadeiro) então
                    pai.setEsquerda(p.getEsquerda()); // pai.esquerda ← p.esquerda;
                } else { // senão
                    pai.setDireita(p.getEsquerda()); // pai.direita ← p.esquerda;
                }
            }
        }
        // senão se (p.esquerda = null) então (Nó tem apenas filho direito)
        else if (p.getEsquerda() == null) {
            if (p == raiz) { // se (p = raiz) então
                raiz = p.getDireita(); // raiz ← p.direita;
            } else { // senão
                if (filhoEsquerda) { // se (filhoEsquerda = verdadeiro) então
                    pai.setEsquerda(p.getDireita()); // pai.esquerda ← p.direita;
                } else { // senão
                    pai.setDireita(p.getDireita()); // pai.direita ← p.direita;
                }
            }
        }
        // Caso 3: O nó a ser removido tem dois filhos.
        else { // Senão // nó com dois filhos
            NoArvoreBinaria<T> sucessor = extrairSucessor(p); // NoArvoreBinaria sucessor ← extrairSucessor(p);

            if (p == raiz) { // se (p = raiz) então
                raiz = sucessor; // raiz ← sucessor;
            } else { // senão
                if (filhoEsquerda) { // se (filhoEsquerda = verdadeiro) então
                    pai.setEsquerda(sucessor); // pai.esquerda = sucessor;
                } else { // senão
                    pai.setDireita(sucessor); // pai.direita = sucessor;
                }
            }
            sucessor.setEsquerda(p.getEsquerda()); // sucessor.esquerda ← p.esquerda;
            // A linha abaixo é crucial para o caso em que o sucessor NÃO é o filho direito direto do nó 'p'.
            // O `extrairSucessor` já cuida do sucessor.direita quando ele não é o filho direito direto.
            // Quando o sucessor *é* o filho direito direto, o `sucessor.direita` já é o correto.
            if (sucessor != p.getDireita()) { // Só precisa redefinir o direito se o sucessor não era o filho direito direto
                sucessor.setDireita(p.getDireita()); // Isso garante que a subárvore direita original (excluindo o sucessor) seja conectada.
            }
        }
    }

    /**
     * Localiza e extrai o sucessor em ordem de um nó (o menor nó na subárvore direita).
     * Este método é utilizado no caso de remoção de um nó com dois filhos.
     * O sucessor é o nó mais à esquerda da subárvore direita.
     *
     * @param p O nó para o qual se deseja encontrar o sucessor.
     * @return O nó sucessor em ordem.
     */
    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita(); // atual ← p.direita; (Acessar o primeiro nó à direita)
        NoArvoreBinaria<T> paiSucessor = p; // paiSucessor ← p; (Começa com o nó 'p' como pai do sucessor, no caso de sucessor ser p.direita)
        NoArvoreBinaria<T> sucessor = p; // sucessor ← p; (Inicializa sucessor com p, será atualizado na primeira iteração)

        // Caminhar até encontrar o último nó à esquerda na subárvore direita.
        while (atual != null) { // enquanto (atual ≠ null) faça
            paiSucessor = sucessor; // paiSucessor ← sucessor;
            sucessor = atual; // sucessor ← atual;
            atual = atual.getEsquerda(); // atual ← atual.esquerda;
        } // fim-enquanto

        // Ajusta os ponteiros se o sucessor não for o filho direito direto do nó original (p).
        // Isso significa que o sucessor tem um pai diferente de 'p' na subárvore direita.
        if (sucessor != p.getDireita()) { // se (sucessor ≠ p.direita) então
            // O filho esquerdo do pai do sucessor recebe o filho direito do sucessor.
            // Isso "remove" o sucessor de sua posição original.
            paiSucessor.setEsquerda(sucessor.getDireita());
            // A linha abaixo garante que o sucessor mantenha a subárvore direita original do nó 'p'.
            // Se o sucessor já fosse o filho direito de 'p', essa linha não seria necessária
            // ou seria redundante, mas é essencial para o caso geral.
            sucessor.setDireita(p.getDireita());
        }

        return sucessor; // retornar sucessor;
    }
}