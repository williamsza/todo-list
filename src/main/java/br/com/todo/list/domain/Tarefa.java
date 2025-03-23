package br.com.todo.list.domain;

import java.time.LocalDateTime;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private Status status;

    public Tarefa(String titulo, String descricao, LocalDateTime prazo, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;


    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataLimite() {
        return prazo;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.prazo = prazo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prazo=" + prazo +
                ", status=" + status +
                '}';
    }
}
