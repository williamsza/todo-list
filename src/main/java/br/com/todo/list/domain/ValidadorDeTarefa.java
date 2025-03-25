package br.com.todo.list.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ValidadorDeTarefa {

    public void validar(String titulo, String descricao, LocalDateTime prozo, Status status) throws TarefaExcepiton {

        if (titulo.length() < 4) {
            throw new TarefaExcepiton("O Título deve ter pelo menos 3 caracteres. ");

        }
        if (prozo.isBefore(LocalDateTime.now())) {
            throw new TarefaExcepiton("O prozo não pode ser do passado.  ");

        }
        if (prozo.toLocalDate().isEqual(LocalDate.now())) {
            throw new TarefaExcepiton("A tarefa não pode ser adicionado com o prazo curto!");
        }


    }
}