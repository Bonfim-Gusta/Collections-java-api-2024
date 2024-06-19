package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> setConvidados;

    public ConjuntoConvidados() {
        this.setConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        setConvidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidado = null;
        for (Convidado c : setConvidados){
            if (c.getCodigoConvite() == codigoConvite){
                convidado = c;
                break;
            }
        }
        setConvidados.remove(convidado);
    }

    public int contarConvidados(){
        return setConvidados.size();
    }

    public void exibirConvidados(){
        System.out.println(setConvidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        System.out.println(conjuntoConvidados.contarConvidados());

        conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 1236);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 1236);
        conjuntoConvidados.adicionarConvidado("Convidado 5", 1238);

        //conjuntoConvidados.removerConvidadoPorCodigoConvite(1238);

        System.out.println(conjuntoConvidados.contarConvidados());
        conjuntoConvidados.exibirConvidados();


    }
}
