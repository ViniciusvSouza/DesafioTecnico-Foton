package com.foton.tasksproject.entity;


import com.foton.tasksproject.dto.ListarTarefaDto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Tasks extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "tasks_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "tasks_id_seq",
            sequenceName = "tasks_id_seq",
            allocationSize = 1
    )

    public Long id;

    public String title;

    public boolean completed;

    public String description;
    @CreationTimestamp
    public LocalDateTime createdAt;
    @UpdateTimestamp
    public LocalDateTime updatedAt;


    public static List<ListarTarefaDto> listTasks(String campo, String ordem) {

        return Tasks.find("order by " + campo + " " + ordem).project(ListarTarefaDto.class).list();
    }


}

