package br.com.todo.list.repository;

import br.com.todo.list.model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaStorage {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(Tarefa tarefa){
        tarefas.add(tarefa);

    }
    public List<Tarefa> listarTodas(){
        return tarefas;
    }
    public List<Tarefa> filtarPorStatus(Tarefa.Status status){
        return tarefas.stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.toList());

    }

}
