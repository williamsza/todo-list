package br.com.todo.list.adapters.controller;

import br.com.todo.list.application.TarefaService;
import br.com.todo.list.domain.Status;
import br.com.todo.list.domain.Tarefa;
import br.com.todo.list.domain.TarefaExcepiton;

import java.time.LocalDateTime;
import java.util.List;

public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public void adicionarTarefa(String titulo, String descricao, LocalDateTime prazo, Status status) {
        try {
            tarefaService.adicionarTarefa(titulo, descricao, prazo, status);
            System.out.println("Tarefa adicionada com sucesso! ");

        } catch (TarefaExcepiton ex) {
            System.out.println("Erro ao adicionar tarefa: " + ex.getMessage());


        }

    }

    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    public List<Tarefa> filtrarTarefasPorStatus(Status status) {
        return tarefaService.filtrarTarefasPorStatus(status);

    }

    public List<Tarefa> listarTarefasOrdenadasPorPrazo() {
        return tarefaService.listarTarefasOrdenadasPorPrazo();
    }
}

