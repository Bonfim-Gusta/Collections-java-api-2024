package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Integer, Produto> estoqueMap;

    public EstoqueProdutos() {
        this.estoqueMap = new HashMap<>();
    }

    public void adicionarProduto(int cod, String nome, int qtd, double preco){
        estoqueMap.put(cod, new Produto(nome, qtd, preco));
    }

    public void removerProduto(int cod){
        if (estoqueMap.containsKey(cod)){
            estoqueMap.remove(cod);
        }
        else {
            System.out.println("Não foi possível remover o produto pois não encontrado no estoque");
        }
    }

    public void exibirProdutosEstoque(){
        System.out.println(estoqueMap);
    }

    public double calcularValorEstoque(){
        double valorEstoque = 0.0;

        for (Produto produto : estoqueMap.values()){
            valorEstoque += (produto.getPreco() * produto.getQuantidade());
        }

        return valorEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto maisCaro = new Produto("", 0, Double.MIN_VALUE);

        for (Produto produto : estoqueMap.values()){
            if (produto.getPreco() > maisCaro.getPreco()){
                maisCaro = produto;
            }
        }

        return maisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto maisBarato = new Produto("", 0, Double.MAX_VALUE);

        for (Produto produto : estoqueMap.values()){
            if (produto.getPreco() < maisBarato.getPreco()){
                maisBarato = produto;
            }
        }

        return maisBarato;
    }

    public Produto obterProdutoMaiorValorEstoque(){
        Produto maiorValorEstoque = new Produto("", 0, 0);

        for (Produto produto : estoqueMap.values()){
            if ((produto.getPreco() * produto.getQuantidade()) > (maiorValorEstoque.getPreco() * maiorValorEstoque.getQuantidade())){
                maiorValorEstoque = produto;
            }
        }

        return maiorValorEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1, "Arroz", 2, 25.00);
        estoqueProdutos.adicionarProduto(2, "Feijao", 6, 10.00);
        estoqueProdutos.adicionarProduto(3, "Macarrão", 10, 2.00);

        System.out.println(estoqueProdutos.calcularValorEstoque());
        System.out.println(estoqueProdutos.obterProdutoMaisBarato());
        estoqueProdutos.exibirProdutosEstoque();
    }
}
