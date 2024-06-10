package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    //atributo
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao)
    {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao)
    {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for (Tarefa tarefa : tarefaList)
        {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao))
            {
                tarefasParaRemover.add(tarefa);
            }
        }

        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas()
    {
        return tarefaList.size();
    }

    public void obterDescricoesTarefas()
    {
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        listaTarefa.adicionarTarefa("Ir para a academia");
        listaTarefa.adicionarTarefa("Ir para o buffet");
        listaTarefa.adicionarTarefa("Sair com a namorada");
        listaTarefa.adicionarTarefa("Sair com a namorada");
        listaTarefa.removerTarefa("Ir para a academia");
        System.out.println(listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.obterDescricoesTarefas();
    }
}
