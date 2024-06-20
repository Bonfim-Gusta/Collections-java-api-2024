package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario(){
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String denificao){
        dicionarioMap.put(palavra,denificao);
    }

    public void removerPalavra(String palavra){
        if (!dicionarioMap.containsKey(palavra)){
            System.out.println("Palavra não existe no dicionário");
        }
        else {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra){
        String definicao = dicionarioMap.get(palavra);
        if (!dicionarioMap.isEmpty()){
            if (dicionarioMap.containsKey(palavra)){
                definicao = dicionarioMap.get(palavra);
            }
            else {
                definicao = "A palavra " + palavra + " não foi encontrada!";
            }
        }
        else {
            definicao = "Dicionário não contém palavras";
        }

        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Gustavo", "Nome muito lindo");
        dicionario.adicionarPalavra("Adriana", "Pessoa maravilhosa");
        dicionario.removerPalavra("Gustavo");
        dicionario.removerPalavra("Adriana");

        dicionario.exibirPalavras();
        System.out.println(dicionario.pesquisarPorPalavra("Luciano"));
    }
}
