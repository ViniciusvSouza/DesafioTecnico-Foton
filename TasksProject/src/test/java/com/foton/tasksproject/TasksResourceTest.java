package com.foton.tasksproject;

import com.foton.tasksproject.dto.ListarTarefaDto;
import com.foton.tasksproject.entity.Tasks;
import com.foton.tasksproject.services.TaskServices;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@QuarkusTest
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TasksResourceTest {
    @InjectMock
    TasksResource tasksResource;
    @Inject
    TaskServices taskServices;

    @BeforeEach
    void setUp() {

    }

    @Test
    void listarTarefa() {
        List<ListarTarefaDto> tarefas = new ArrayList<>();
        Mockito.when(tasksResource.listarTarefa("title", "asc")).thenReturn(tarefas);
    }

    @Test
    void pesquisarId() {
        Mockito.when(Tasks.findById(1L)).thenReturn(Optional.of(tasksResource));
    }

    @Test
    void cadastraTarefa() {
    }

    @Test
    void uptask() {
    }

    @Test
    void deletaTarefa() {
    }
}