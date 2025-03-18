package br.com.todo.list.service;

import br.com.todo.list.model.Tarefa;
import br.com.todo.list.repository.TarefaStorage;

import java.time.LocalDate;
import java.util.List;

public class TarefaService {

    private TarefaStorage storage = new TarefaStorage();

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa.getTitulo().length() < 3) {
            System.out.println("Tarefa deve ter pelo menos 3 caracteres.");

        }
        if (tarefa.getDataLimite().isBefore(LocalDate.now())) {
            System.out.println("Data limite não pode ser do passado");

        }
        storage.adicionar(tarefa);

    }

    public List<Tarefa> listarTodas(){
        return storage.listarTodas();
    }
}
