package com.foton.tasksproject.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDateTime;

@RegisterForReflection
public class ListarTarefaDto {
    public long id;

    public String title;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;

    public ListarTarefaDto(long id, String title, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
