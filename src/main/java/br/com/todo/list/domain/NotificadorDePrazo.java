package br.com.todo.list.domain;

import br.com.todo.list.infrastructure.Notificador;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NotificadorDePrazo implements Notificador {
    @Override
    public void notificar(Tarefa tarefa) {

        long tempoAtePrazo = tarefa.getPrazo().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli() - System.currentTimeMillis();
        //if (tempoAtePrazo > 0 && tempoAtePrazo <= TimeUnit.MINUTES.toMillis(30)) {
        if (tempoAtePrazo > 0 && tempoAtePrazo <= TimeUnit.MINUTES.toMillis(30)) {
            CompletableFuture.runAsync(() -> {

                try {

                    TimeUnit.MILLISECONDS.sleep(tempoAtePrazo);
                    System.out.println("Notificação: A tarefa  ' " + tarefa.getTitulo() + "' está próxima do prazo! ");


                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();

                }


            });

        }

    }
}
