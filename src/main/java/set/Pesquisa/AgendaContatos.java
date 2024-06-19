package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> setContatos;

    public AgendaContatos() {
        this.setContatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int contato){
        setContatos.add(new Contato(nome, contato));
    }

    public void exibirContatos(){
        System.out.println(setContatos);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> retornoPesquisa = new HashSet<>();
        if (!setContatos.isEmpty()){
            for (Contato c : setContatos){
                if (c.getNome().contains(nome)){
                    retornoPesquisa.add(c);
                }
            }
        }

        return retornoPesquisa;
    }

    public Contato atualizarContato(String nome, int numero){
        Contato contatoAtualizado = null;

        for (Contato c : setContatos){
            if (c.getNome().equals(nome)){
                c.setNumeroTelefone(numero);
                contatoAtualizado = c;
                break;
            }
        }

        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Leonardo", 958451256);
        agendaContatos.adicionarContato("Leonardo", 958451288);
        agendaContatos.adicionarContato("Leonardo Ribeiro", 958445726);
        agendaContatos.adicionarContato("Bruno Leonardo", 958445726);
        agendaContatos.adicionarContato("Lucas", 974469256);

        System.out.println(agendaContatos.atualizarContato("Leonardo Ribeiro", 988885555));
        agendaContatos.exibirContatos();
    }
}
