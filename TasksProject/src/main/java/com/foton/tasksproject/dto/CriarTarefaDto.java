package com.foton.tasksproject.dto;

import java.time.LocalDateTime;

    public class CriarTarefaDto {

    public String title;

    public String description;

    public LocalDateTime creatadeat;

    public CriarTarefaDto(String title, String description, LocalDateTime creatadeat){
        this.title = title;
        this.creatadeat = creatadeat;
        this.description = description;
    }
}
