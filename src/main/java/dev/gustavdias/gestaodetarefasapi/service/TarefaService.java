package dev.gustavdias.gestaodetarefasapi.service;

import dev.gustavdias.gestaodetarefasapi.controller.dto.TarefaDTO;
import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaForm;
import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaUpdateForm;
import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import dev.gustavdias.gestaodetarefasapi.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<TarefaDTO> findAllTarefa(){
        var tarefa = repository.findAllByOrderByIdAsc();
        return tarefa.stream().map(TarefaDTO::new).collect(Collectors.toList());
    }

    public List<TarefaDTO> findAllTarefaEmAndamento(String situacao){
        var optional = repository.findAllBySituacao(situacao);
        return optional.stream().map(TarefaDTO::new).collect(Collectors.toList());
    }

    public List<TarefaDTO> findAllByParam(Long id, String tituloDescricao, String responsavel, String situacao){
        if (!tituloDescricao.isEmpty()) {
            var like = "%"+tituloDescricao+"%";
            var tarefa = repository.findByParam(like,responsavel,situacao);
            return tarefa.stream().map(TarefaDTO::new).collect(Collectors.toList());
        }else if(id != null){
            var tarefa = findByIdTarefa(id);
            return tarefa.stream().map(TarefaDTO::new).collect(Collectors.toList());
        }else{
            var tarefa = repository.findByParam(tituloDescricao,responsavel,situacao);
            return tarefa.stream().map(TarefaDTO::new).collect(Collectors.toList());
        }
    }

    public Optional<Tarefa> findByIdTarefa(Long id){
        return repository.findById(id);
    }

    public TarefaDTO saveTarefa(TarefaForm form){
        var tarefa = form.converter();
        repository.save(tarefa);
        return new TarefaDTO(tarefa);
    }

    @Transactional
    public TarefaDTO updateTarefa(Long id, TarefaUpdateForm tarefaUpdateForm){
     var tarefa = tarefaUpdateForm.atualizarDados(id, repository);
     return new TarefaDTO(tarefa);
    }

    public void deleteTarefa(Tarefa tarefa){
        repository.delete(tarefa);
    }

    @Transactional
    public void concluirTarefa(Tarefa tarefa){
        repository.save(tarefa);
    }
}
