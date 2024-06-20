package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrariaOnlineMap;

    public LivrariaOnline() {
        this.livrariaOnlineMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrariaOnlineMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        List<String> chavesRemover = new ArrayList<>();
        if (!livrariaOnlineMap.isEmpty()){
            for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    chavesRemover.add(entry.getKey());
                }
            }
        }

        for (String chave : chavesRemover){
            livrariaOnlineMap.remove(chave);
        }
    }

    public void exibirLivros(){
        System.out.println(livrariaOnlineMap.values());
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaOnlineMap.entrySet());
        livrosParaOrdenarPorPreco.sort(new CompararPorPreco());

        Map<String, Livro> livrosPorPreco = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco){
            livrosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosAutorX = new HashMap<>();

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if ((entry.getValue().getAutor().equalsIgnoreCase(autor))){
                livrosAutorX.put(entry.getKey(), entry.getValue());
            }
        }

        return livrosAutorX;
    }

    public Map<String, Livro> obterLivroMaisCaro(){
        Map<String, Livro> livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if (entry.getValue().getPreco() > maiorPreco){
                maiorPreco = entry.getValue().getPreco();
                livroMaisCaro = new HashMap<>();
                livroMaisCaro.put(entry.getKey(), entry.getValue());
            }
        }

        return livroMaisCaro;
    }

    public Map<String, Livro> obterLivroMaisBarato(){
        Map<String, Livro> livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaOnlineMap.entrySet()){
            if (entry.getValue().getPreco() < menorPreco){
                menorPreco = entry.getValue().getPreco();
                livroMaisBarato = new HashMap<>();
                livroMaisBarato.put(entry.getKey(), entry.getValue());
            }
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("www.livro1.com", "Livro 1", "Autor X", 29.90d);
        livrariaOnline.adicionarLivro("www.livro2.com", "Livro 2", "Autor X", 125.90d);
        livrariaOnline.adicionarLivro("www.livro3.com", "Livro 3", "Autor Y", 49.90d);
        livrariaOnline.adicionarLivro("www.livro4.com", "Livro 4", "Autor Z", 65.90d);
        livrariaOnline.adicionarLivro("www.livro5.com", "Livro 5", "Autor Z", 35.90d);

        livrariaOnline.removerLivro("Livro 1");

        //livrariaOnline.exibirLivros();

//        if (livrariaOnline.pesquisarLivrosPorAutor("Autor aa").isEmpty()){
//            System.out.println("O autor pesquisado não foi encontrado");
//        }else {
//            System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Autor aa"));
//        }

        System.out.println(livrariaOnline.obterLivroMaisBarato());
    }
}

class CompararPorPreco implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
    }
}