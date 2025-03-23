package br.com.todo.list.application;

import br.com.todo.list.domain.Tarefa;
import br.com.todo.list.domain.Status;
import br.com.todo.list.domain.ValidadorDeTarefa;
import br.com.todo.list.infrastructure.Notificador;
import br.com.todo.list.repository.TarefaStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();
    private Notificador notificador;
    private ValidadorDeTarefa validador;

    public TarefaService( Notificador notificador, ValidadorDeTarefa validador) {
        this.notificador = notificador;
        this.validador = new ValidadorDeTarefa();
    }
}
