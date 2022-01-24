package dev.gustavdias.gestaodetarefasapi.controller;

import dev.gustavdias.gestaodetarefasapi.controller.dto.TarefaDTO;
import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaForm;
import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaUpdateForm;
import dev.gustavdias.gestaodetarefasapi.service.TarefaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
@Api(value = "Gestão de Tarefas - API")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value="Retorna uma lista de Tarefas")
    public ResponseEntity<List<TarefaDTO>> findAllCandidatos(){
        var listTarefa = service.findAllTarefa();
        if (listTarefa.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(listTarefa);
        }
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna uma Tarefa com o parametro ID passado")
    public ResponseEntity<TarefaDTO> findOneCandidato(@PathVariable("id") Long id){
        var tarefa = service.findByIdTarefa(id);

        return tarefa.map(value -> ResponseEntity.ok(new TarefaDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation(value="Cria uma nova Tarefa")
    public ResponseEntity<TarefaDTO> saveCandidato(@RequestBody @Valid TarefaForm form, UriComponentsBuilder uriComponentsBuilder){
        var tarefaDto = service.saveTarefa(form);
        URI uri = uriComponentsBuilder.path("tarefa/{id}").buildAndExpand(tarefaDto.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefaDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma Tarefa pelo parametro ID passado")
    public ResponseEntity<TarefaDTO> updateCandidato(@PathVariable("id") Long id,
                                                        @RequestBody @Valid TarefaUpdateForm tarefaUpdateForm){
        var optionalTarefa = service.findByIdTarefa(id);

        if (optionalTarefa.isPresent()){
            return ResponseEntity.ok(service.updateTarefa(id, tarefaUpdateForm));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma Tarefa")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        var optionalTarefa = service.findByIdTarefa(id);
        if (optionalTarefa.isPresent()){
            service.deleteTarefa(optionalTarefa.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
