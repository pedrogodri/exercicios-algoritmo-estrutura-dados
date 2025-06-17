package com.example;

import com.example.buscas.BuscaBinaria;
import com.example.buscas.BuscaLinear;
import com.example.buscas.buscaArvoreBinaria.ArvoreBinariaBusca;
import com.example.mapaDispersao.MapaDispersao;
import com.example.mapaDispersao.aluno.Aluno;
import com.example.ordenacao.OrdenacaoBolha;
import com.example.ordenacao.OrdenacaoBolhaOtimizada;
import com.example.ordenacao.OrdenacaoMergeSort;
import com.example.ordenacao.OrdenacaoQuickSort;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // --- Busca Linear e Binária ---
        Integer[] vetor = {10, 20, 30, 40, 50};
        BuscaLinear<Integer> buscaLinear = new BuscaLinear<>();
        buscaLinear.setInfo(vetor);
        System.out.println("Busca Linear (30): " + buscaLinear.busca(30)); // Deve imprimir 2

        BuscaBinaria<Integer> buscaBinaria = new BuscaBinaria<>();
        buscaBinaria.setInfo(vetor);
        System.out.println("Busca Binária (40): " + buscaBinaria.buscar(40)); // Deve imprimir 3

        // --- Mapa de Dispersão ---
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        System.out.println("Aluno 12000: " + mapa.buscar(12000).getNome()); // Jean
        System.out.println("Aluno 14000: " + mapa.buscar(14000).getNome()); // Pedro

        // --- Ordenação ---
        Integer[] vetorDesordenado = {5, 2, 9, 1, 7};
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetorDesordenado.clone());
        bolha.ordenar();
        System.out.print("Bolha: ");
        for (int n : bolha.getInfo()) System.out.print(n + " ");
        System.out.println();

        OrdenacaoBolhaOtimizada<Integer> bolhaOt = new OrdenacaoBolhaOtimizada<>();
        bolhaOt.setInfo(vetorDesordenado.clone());
        bolhaOt.ordenar();
        System.out.print("Bolha Otimizada: ");
        for (int n : bolhaOt.getInfo()) System.out.print(n + " ");
        System.out.println();

        OrdenacaoMergeSort<Integer> merge = new OrdenacaoMergeSort<>();
        merge.setInfo(vetorDesordenado.clone());
        merge.ordenar();
        System.out.print("MergeSort: ");
        for (int n : merge.getInfo()) System.out.print(n + " ");
        System.out.println();

        OrdenacaoQuickSort<Integer> quick = new OrdenacaoQuickSort<>();
        quick.setInfo(vetorDesordenado.clone());
        quick.ordenar();
        System.out.print("QuickSort: ");
        for (int n : quick.getInfo()) System.out.print(n + " ");
        System.out.println();

        // --- Árvore Binária de Busca ---
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

        // Inserção
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Árvore em pré-ordem: " + arvore.toString());
        System.out.println("Total de nós: " + arvore.contarNos());

        // Busca
        System.out.println("Busca pelo valor 40: " + (arvore.buscar(40) != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Busca pelo valor 100: " + (arvore.buscar(100) != null ? "Encontrado" : "Não encontrado"));

        // Remoção de folha
        arvore.remover(20);
        System.out.println("Após remover 20: " + arvore.toString());

        // Remoção de nó com um filho
        arvore.remover(30);
        System.out.println("Após remover 30: " + arvore.toString());

        // Remoção de nó com dois filhos
        arvore.remover(50);
        System.out.println("Após remover 50: " + arvore.toString());
    }
}