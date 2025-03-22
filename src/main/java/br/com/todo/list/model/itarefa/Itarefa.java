package br.com.todo.list.model.itarefa;

import br.com.todo.list.model.status.Status;

import java.time.LocalDate;

public interface Itarefa {
    String getTutulo();
    String getDescricao();
    LocalDate getPrazo();
    Status getStatus();
}
