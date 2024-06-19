package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> setTarefas;

    public ListaTarefas(){
        this.setTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        setTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;

        if (!setTarefas.isEmpty()){
            for (Tarefa tarefa : setTarefas){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaParaRemover = tarefa;
                    break;
                }
            }
            setTarefas.remove(tarefaParaRemover);
        }
        else {
            System.out.println("Não existem tarefas cadastradas");
        }

        if (tarefaParaRemover == null){
            System.out.println("Tarefa não encontrada para remover");
        }
    }

    public void exibirTarefas(){
        System.out.println(setTarefas);
    }

    public int contarTarefas(){
        return setTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!setTarefas.isEmpty()){
            for (Tarefa tarefa : setTarefas){
                if (tarefa.getFoiConcluida()){
                    tarefasConcluidas.add(tarefa);
                }
            }
        }
        else {
            System.out.println("Não existem tarefas cadastradas");
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        if (!setTarefas.isEmpty()){
            for (Tarefa tarefa : setTarefas){
                if (!tarefa.getFoiConcluida()){
                    tarefasPendentes.add(tarefa);
                }
            }
        }
        else {
            System.out.println("Não existem tarefas cadastradas");
        }

        return tarefasPendentes;
    }

    public void marcarTarefaComoFeita(String descricao){
        boolean tarefaEncontrada = false;
        for (Tarefa tarefa : setTarefas){
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefa.setFoiConcluida(true);
                tarefaEncontrada = true;
                break;
            }
        }

        if (!tarefaEncontrada){
            System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public void marcarTarefaComoNaoFeita(String descricao){
        boolean tarefaEncontrada = false;
        for (Tarefa tarefa : setTarefas){
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefa.setFoiConcluida(false);
                tarefaEncontrada = true;
                break;
            }
        }

        if (!tarefaEncontrada){
            System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public void limparTarefas(){
        if (setTarefas.isEmpty()){
            System.out.println("A lista de tarefas já está vazia");
        }
        else {
            setTarefas.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Arrumar o quarto");
        listaTarefas.adicionarTarefa("Escovar os dentes");
        listaTarefas.adicionarTarefa("Tomar creatina");
        listaTarefas.adicionarTarefa("Correr no araçariguama");
        listaTarefas.adicionarTarefa("Tomar café da manhã");
        listaTarefas.adicionarTarefa("Iniciar os estudos");

        listaTarefas.removerTarefa("Iniciar os estudos");

        listaTarefas.marcarTarefaComoFeita("Arrumar o quarto");
        listaTarefas.marcarTarefaComoFeita("Escovar os dentes");
        listaTarefas.marcarTarefaComoFeita("Tomar creatina");

        listaTarefas.marcarTarefaComoNaoFeita("Tomar creatina");


        //listaTarefas.limparTarefas();

        //System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas: " + listaTarefas.contarTarefas());
        System.out.println("Tarefas concluídas: " + listaTarefas.obterTarefasConcluidas());
        System.out.println("Tarefas não concluídas: " + listaTarefas.obterTarefasPendentes());

    }
}
