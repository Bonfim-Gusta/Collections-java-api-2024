package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos(){
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao){
        agendaEventosMap.put(data, new Evento(nomeEvento, nomeAtracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);

        LocalDate data = null;
        Evento evento = null;
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                data = entry.getKey();
                evento = entry.getValue();
                break;
            }
        }

        if (data == null){
            System.out.println("Sem shows próximos no momento");
        }
        else {
            System.out.println("O próximo evento será no dia " + data + "\nEvento esperado: " + evento.getNomeEvento()
            + "\nDescrição: \n" + evento.getNomeAtracao());
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.JULY, 20),
                "Barbixas",  "Show barbixas no teatro municipal");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 8, 5),
                "A opera",  "Artistas musicais da cidade se apresentam");
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.DECEMBER, 25),
                "Meu pequeno amigo",  "Peça teatral infantil");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JUNE, 19),
                "Circo",  "O maior circo da américa latina chega na cidade");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JUNE, 25),
                "RockFest",  "As melhores bandas covers estarão presentes");


        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
