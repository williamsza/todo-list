package br.com.todo.list.infrastructure;

import br.com.todo.list.domain.Tarefa;

public interface Notificador {
    void notificar(Tarefa tarefa);
}
