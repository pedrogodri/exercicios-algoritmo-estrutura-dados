package com.example;

import com.example.PilhaImplementacao.PilhaCheiaException;
import com.example.PilhaImplementacao.PilhaVaziaException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Hello world!");
        } catch (PilhaVaziaException | PilhaCheiaException  e) {
            System.out.println("oi");
        }
    }
}