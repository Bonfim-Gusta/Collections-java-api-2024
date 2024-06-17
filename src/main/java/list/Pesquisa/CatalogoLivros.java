package main.java.list.Pesquisa;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    void adicionarLivro(String titulo, String autor, int ano){
        livros.add(new Livro(titulo, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosAutorX = new ArrayList<>();
        if (!livros.isEmpty()){
            for (Livro livro : livros){
                if (livro.getAutor().equalsIgnoreCase(autor)){
                    livrosAutorX.add(livro);
                }
            }
        }
        return livrosAutorX;
    }

    public List<Livro> pesquisarPorIntervalosAnos(int anoInicial, int anoFinal){
        List<Livro> livrosNoIntervalo = new ArrayList<>();

        if (!livros.isEmpty()){
            for (Livro livro : livros){
                if (livro.getAno() >= anoInicial && livro.getAno() <= anoFinal){
                    livrosNoIntervalo.add(livro);
                }
            }
        }

        return livrosNoIntervalo;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroTitulo = null;
        for (Livro livro : livros){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                livroTitulo = livro;
            }
        }
        return livroTitulo;
    }

    int qtdLivros()
    {
       return livros.size();
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Olhos que sangram", "Joaquim", 2022);
        catalogoLivros.adicionarLivro("Como enriquecer", "Pedro", 2023);
        catalogoLivros.adicionarLivro("A lenda", "Jéssica", 2024);
        catalogoLivros.adicionarLivro("O código perfeito", "Gustavo", 2024);
        catalogoLivros.adicionarLivro("A origem", "Adriana", 2006);
        catalogoLivros.adicionarLivro("Como escrever um livro", "Adriana", 2019);


//        System.out.println(catalogoLivros.qtdLivros());
//        System.out.println(catalogoLivros.pesquisarPorAutor("Gustavo"));
//        System.out.println(catalogoLivros.pesquisarPorIntervalosAnos(2000,2010));

        //System.out.println(catalogoLivros.pesquisarPorTitulo("A origem"));
    }
}
