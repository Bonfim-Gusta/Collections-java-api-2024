package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> setPalavras;

    public ConjuntoPalavrasUnicas() {
        this.setPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        setPalavras.add(palavra);
    }

    public void removerPalavra(String palavra){
        if (!setPalavras.isEmpty()){
            if (setPalavras.contains(palavra)){
                setPalavras.remove(palavra);
            }
            else {
                System.out.println("Palavra não encontrada no conjunto");
            }
        }
        else {
            System.out.println("O conjunto está vázio");
        }
    }

    public boolean verificarPalavra(String palavra){
        return setPalavras.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        System.out.println(setPalavras);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Correr");
        conjuntoPalavrasUnicas.adicionarPalavra("Gritar");
        conjuntoPalavrasUnicas.adicionarPalavra("Andar");
        conjuntoPalavrasUnicas.adicionarPalavra("Berrar");

        //conjuntoPalavrasUnicas.removerPalavra("Gritar");


        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Andar"));
    }
}
