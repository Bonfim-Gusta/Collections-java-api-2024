package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros;

    public SomaNumeros(){
        listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listaNumeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for (int numero : listaNumeros){
            soma += numero;
        }

        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNum = 0;

        for (int numero : listaNumeros){
            if (numero > maiorNum){
                maiorNum = numero;
            }
        }

        return maiorNum;
    }

    public int encontrarMenorNumero(){
        int menorNum = 999999999;

        for (int numero : listaNumeros){
            if (numero < menorNum){
                menorNum = numero;
            }
        }

        return menorNum;
    }

    public List<Integer> exibirNumeros(){
        return listaNumeros;
    }

    public static void main(String[] args) {
        SomaNumeros listaNumeros = new SomaNumeros();

        listaNumeros.adicionarNumero(5);
        listaNumeros.adicionarNumero(8);
        listaNumeros.adicionarNumero(1);
        listaNumeros.adicionarNumero(3);

        System.out.println(listaNumeros.exibirNumeros());
        System.out.println(listaNumeros.encontrarMaiorNumero());
        System.out.println(listaNumeros.encontrarMenorNumero());
        System.out.println(listaNumeros.calcularSoma());
    }
}
