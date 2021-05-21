package com.foton.tasksproject.services;

import com.foton.tasksproject.dto.ListarTarefaDto;
import com.foton.tasksproject.entity.Tasks;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TaskServices {

    public List<ListarTarefaDto> listarTarefa(String campo, String ordem){

        return Tasks.listTasks(campo, ordem);
    }
}