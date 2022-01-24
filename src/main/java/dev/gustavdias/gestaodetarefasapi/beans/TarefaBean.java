package dev.gustavdias.gestaodetarefasapi.beans;

import dev.gustavdias.gestaodetarefasapi.controller.dto.TarefaDTO;
import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaForm;
import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaUpdateForm;
import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import dev.gustavdias.gestaodetarefasapi.service.TarefaService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named(value = "tarefaBean")
@ViewScoped
public class TarefaBean {

    private final TarefaService service;

    public TarefaBean(final TarefaService service) {
        this.service = service;
    }

    @Getter
    @Setter
    private Tarefa tarefa = new Tarefa();

    @Getter
    @Setter
    private TarefaDTO tarefaDTO = new TarefaDTO(tarefa);

    @Getter
    @Setter
    private List<TarefaDTO> tarefaDTOS = new ArrayList<>();

    public void redirectToTarefas() throws IOException {
        tarefa = new Tarefa();
        FacesContext.getCurrentInstance().getExternalContext().redirect("tarefas.jr");
    }

    public void redirectToNovaTarefa() throws IOException {
        tarefa = new Tarefa();
        FacesContext.getCurrentInstance().getExternalContext().redirect("nova-tarefa.jr");
    }

    public void redirectToEditarTarefa(Long id) throws IOException {
        var tarefaOptional = service.findByIdTarefa(id);
        tarefa = tarefaOptional.get();
        System.out.println(tarefa.getDeadline());
        FacesContext.getCurrentInstance().getExternalContext().redirect("editar-tarefa.jr");
    }

    public List<TarefaDTO> listarTodasTarefas() {
        return service.findAllTarefa();
    }

    public List<TarefaDTO> listarTarefas(){
        if (tarefaDTOS.isEmpty()){
            tarefa = new Tarefa();
            tarefaDTOS = new ArrayList<>();
            return tarefaDTOS = service.findAllTarefaEmAndamento("Em andamento");
        }else {
            return tarefaDTOS;
        }
    }

    public List<TarefaDTO> findByParametro(){
        var tituloDescricao = tarefa.getTitulo();
        tarefaDTOS = new ArrayList<>();
        return tarefaDTOS = service.findAllByParam(tarefa.getId(),tituloDescricao,tarefa.getResponsavel(),tarefa.getSituacao());
    }

    public void novaTarefa() throws IOException {
        TarefaForm tarefaForm = new TarefaForm(tarefa);
        service.saveTarefa(tarefaForm);
        tarefaDTOS.clear();
        redirectToTarefas();
    }

    public void editarTarefa(Long id) throws IOException {
        id = tarefa.getId();
        TarefaUpdateForm tarefaUpdateForm = new TarefaUpdateForm(tarefa);
        service.updateTarefa(id, tarefaUpdateForm);
        tarefaDTOS.clear();
        redirectToTarefas();
    }

    public void concluirTarefa(Long id){
        var tarefaOptional =service.findByIdTarefa(id);
        if (tarefaOptional.isPresent()){
            tarefaOptional.get().setSituacao("Concluída");
            service.concluirTarefa(tarefaOptional.get());
            tarefaDTOS.clear();
        }else{
            tarefaDTOS.clear();
        }
    }

    public void deletarTarefa(Long id){
        service.deleteTarefa(service.findByIdTarefa(id).get());
        tarefaDTOS.clear();
    }
}
