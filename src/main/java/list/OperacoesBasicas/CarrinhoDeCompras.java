package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    List<Item> listaDeCompras;

    public CarrinhoDeCompras() {
        this.listaDeCompras = new ArrayList<>();
    }

    void adicionarItem(String nome, double preco, int quantidade) {
        listaDeCompras.add(new Item(nome, preco, quantidade));
    }

    void removerItem(String nome)
    {
        List<Item> itensParaRemover = new ArrayList<>();

        for (Item i : listaDeCompras){
            if (i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }

        listaDeCompras.removeAll(itensParaRemover);
    }

    double calcularValorTotal(){
        double valorTotal = 0.0f;
        for (Item i : listaDeCompras){
            valorTotal = valorTotal + (i.getPreco() * i.getQuantidade());
        }

        return valorTotal;
    }

    void exibirItens(){
        System.out.println(listaDeCompras);
    }


    public static void main(String[] args) {
        CarrinhoDeCompras listaDeCompras = new CarrinhoDeCompras();

        listaDeCompras.adicionarItem("Arroz", 25.00f, 4);
        listaDeCompras.adicionarItem("Feijão", 10.00f, 2);

        listaDeCompras.removerItem("arroz");

        System.out.println("Preço total = " + listaDeCompras.calcularValorTotal());
        listaDeCompras.exibirItens();
    }
}
