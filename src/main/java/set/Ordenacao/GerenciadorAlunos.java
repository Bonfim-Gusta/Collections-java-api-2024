package main.java.set.Ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> setAlunos;

    public GerenciadorAlunos(){
        this.setAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, int matricula, double nota){
        setAlunos.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(int matricula){
        Aluno alunoParaRemover = null;

        if (!setAlunos.isEmpty()){
            for (Aluno aluno : setAlunos){
                if (aluno.getMatricula() == matricula){
                    alunoParaRemover = aluno;
                    break;
                }
            }
        }
        else {
            System.out.println("Não existem alunos cadastrados.");
        }

        setAlunos.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunosPorNome(){
        return new TreeSet<>(setAlunos);
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new CompararPorNota());
        alunosPorNota.addAll(setAlunos);

        return alunosPorNota;
    }

    public void exibirAlunos(){
        System.out.println(setAlunos);
    }

    public static void main(String[] args) {
        GerenciadorAlunos listaAlunos = new GerenciadorAlunos();

        listaAlunos.adicionarAluno("Gustavo", 998985, 10);
        listaAlunos.adicionarAluno("Adriana", 994785, 9);
        listaAlunos.adicionarAluno("Kayky", 48985, 9.5);
        listaAlunos.adicionarAluno("Marcelo", 48585, 9.8);
        listaAlunos.adicionarAluno("Joao", 48989, 8.5);

        listaAlunos.removerAluno(998985);


        System.out.println(listaAlunos.exibirAlunosPorNome());
        //listaAlunos.exibirAlunos();
    }
}

class CompararPorNota implements Comparator<Aluno>{
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a1.getNota(), a2.getNota());
    }
}

