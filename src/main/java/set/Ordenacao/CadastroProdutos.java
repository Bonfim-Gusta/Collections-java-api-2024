package main.java.set.Ordenacao;

import java.util.*;

public class CadastroProdutos{
    private Set<Produto> setProdutos;

    public CadastroProdutos(){
        this.setProdutos = new HashSet<>();
    }

    public void adicionarProduto(int cod, String nome, double preco, int quant){
        setProdutos.add(new Produto(cod, nome, preco, quant));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(setProdutos);

        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(setProdutos);

        return produtosPorPreco;
    }
}

class ComparatorPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}