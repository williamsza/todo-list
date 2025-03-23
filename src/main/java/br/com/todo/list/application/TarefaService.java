package br.com.todo.list.application;

import br.com.todo.list.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();
    private NotificadorDePrazo notificador;
    private ValidadorDeTarefa validador;

    public TarefaService(NotificadorDePrazo notificador) {
        this.tarefas = tarefas;
        this.notificador = notificador;
        this.validador = new ValidadorDeTarefa();
    }


    //    public TarefaService(NotificadorDePrazo notificador, ValidadorDeTarefa validador) {
//        this.notificador = notificador;
//        this.validador = new ValidadorDeTarefa();
//    }

    public void adicionarTarefa(String titulo, String descricao, LocalDateTime prazo, Status status) throws TarefaExcepiton {
        validador.validar(titulo, descricao, prazo, status);
        Tarefa tarefa = new Tarefa(titulo, descricao, prazo, status);
        tarefas.add(tarefa);
        notificador.notificar(tarefa);

    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public List<Tarefa> filtrarTarefasPorStatus(Status status) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getStatus() == status)
                .toList();
    }

    public List<Tarefa> listarTarefasOrdenadasPorPrazo() {
        return tarefas.stream()
                .sorted(Comparator.comparing(Tarefa::getPrazo))
                .toList();
    }
}
