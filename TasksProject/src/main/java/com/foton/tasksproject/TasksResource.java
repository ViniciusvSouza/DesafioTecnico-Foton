package com.foton.tasksproject;

import com.foton.tasksproject.dto.AtualizarTarefaDto;
import com.foton.tasksproject.dto.CriarTarefaDto;
import com.foton.tasksproject.dto.ListarTarefaDto;
import com.foton.tasksproject.entity.Tasks;
import com.foton.tasksproject.services.TaskServices;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/task")
@Transactional
public class TasksResource {

    @Inject
    TaskServices taskServices;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ListarTarefaDto> listarTarefa(@QueryParam("campo") String campo,
                                              @QueryParam("ordem") String ordem){

        if (!campo.equals("title") && !campo.equals("updatedat") && !campo.equals("createdat")){
            campo = "title";
        }

        if (ordem == null){
            ordem = "asc";
        }

        return taskServices.listarTarefa(campo, ordem);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pesquisarId( @PathParam("id") Long id){

        return Response.ok(Tasks.findById(id)).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void cadastraTarefa(CriarTarefaDto criartarefadto){
        Tasks task = new Tasks();

        task.description = criartarefadto.description;
        task.title = criartarefadto.title;
        task.createdAt = criartarefadto.creatadeat;
        task.persist();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void uptask(@PathParam("id") long id, AtualizarTarefaDto task){
       Optional<Tasks> tasksup = Tasks.findByIdOptional(id);

       if (tasksup.isPresent()){
           Tasks tasks = tasksup.get();
           tasks.title = task.title;
           tasks.description = task.description;
           tasks.updatedAt = task.updatedAt;
           tasks.completed = task.completed;
       }else {
           throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                   .entity("Tarefa não encontrada").build());

       }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deletaTarefa(@PathParam("id") Long id){
        Tasks tasksdelete = Tasks.findById(id);
        if (tasksdelete == null){
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Tarefa não encontrada").build());
        }else {
            tasksdelete.delete();
        }
    }
}
