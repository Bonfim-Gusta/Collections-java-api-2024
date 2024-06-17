package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> listaDePessoas;

    public OrdenacaoPessoa()
    {
        this.listaDePessoas = new ArrayList<>();
    }

    void adicionarPessoa(String nome, int idade, double altura){
        listaDePessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> ordenacaoPorIdade = new ArrayList<>(listaDePessoas);
        Collections.sort(ordenacaoPorIdade);
        return ordenacaoPorIdade;
    }

    public List<Pessoa> ordenarPorAlturaCrescente(){
        List<Pessoa> ordenacaoPorAltura = new ArrayList<>(listaDePessoas);
        Collections.sort(ordenacaoPorAltura, new compararPorAlturaCrescente());

        return ordenacaoPorAltura;
    }

    public List<Pessoa> ordenarPorAlturaDecrescente(){
        List<Pessoa> ordenacaoPorAltura = new ArrayList<>(listaDePessoas);
        Collections.sort(ordenacaoPorAltura, new compararPorAlturaDecrescente());

        return ordenacaoPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();

        ordenacaoPessoa.adicionarPessoa("Joaquim", 19, 1.71);
            ordenacaoPessoa.adicionarPessoa("Pedro", 17, 1.60);
        ordenacaoPessoa.adicionarPessoa("Jéssica", 43, 1.54);
        ordenacaoPessoa.adicionarPessoa("Guilherme", 46, 1.68);

        System.out.println(ordenacaoPessoa.ordenarPorAlturaCrescente());
        System.out.println(ordenacaoPessoa.ordenarPorAlturaDecrescente());
//        System.out.println("-----------------------------------------------------------------------------");
        //System.out.println(ordenacaoPessoa.listaDePessoas);

    }
}

class compararPorAlturaCrescente implements Comparator<Pessoa>{

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}

class compararPorAlturaDecrescente implements Comparator<Pessoa>{

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p2.getAltura(), p1.getAltura());
    }
}