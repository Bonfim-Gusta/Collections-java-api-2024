package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> listaNumeros;

    public OrdenacaoNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listaNumeros.add(numero);
    }

    public List<Integer> ordenarCrescente(){
        List<Integer> ordemCrescente = listaNumeros;
        Collections.sort(ordemCrescente);

        return ordemCrescente;
    }

    public List<Integer> ordenarDecrescente(){
        List<Integer> ordemDecrescente = listaNumeros;
        ordemDecrescente.sort(new OrdenandoDecrescente());

        return ordemDecrescente;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(8);
        numeros.adicionarNumero(6);
        numeros.adicionarNumero(7);
        numeros.adicionarNumero(3);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(2);

        System.out.println(numeros.listaNumeros);
        System.out.println(numeros.ordenarCrescente());
        System.out.println(numeros.ordenarDecrescente());
    }
}


class OrdenandoDecrescente implements Comparator<Integer> {
    @Override
    public int compare(Integer p1, Integer p2) {
        return Integer.compare(p2, p1);
    }
}