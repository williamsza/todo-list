package br.com.todo.list.application;

import br.com.todo.list.domain.Tarefa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificacaoService {

    public CompletableFuture<Void> verificarNotificacoes(List<Tarefa> tarefas) {
        return CompletableFuture.runAsync(() -> {
            for (Tarefa tarefa : tarefas) {
                long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), tarefa.getDataLimite());
                if (diasRestantes <= 1) {
                    System.out.println("Notificação: A tarefa '" + tarefa.getTitulo() + "' está próxima do prazo!");
                }
            }
        });


    }
}
