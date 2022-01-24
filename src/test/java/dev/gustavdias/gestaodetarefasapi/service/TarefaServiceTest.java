package dev.gustavdias.gestaodetarefasapi.service;

import dev.gustavdias.gestaodetarefasapi.controller.form.TarefaForm;
import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import dev.gustavdias.gestaodetarefasapi.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TarefaServiceTest {

    @Mock
    private TarefaRepository repository;

    private TarefaService service;

    @Captor
    private ArgumentCaptor<Tarefa> captor;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
        this.service = new TarefaService(repository);
    }

    @Test
    public void deveriaSalvarTarefaComSucesso(){
        Tarefa tarefa = tarefa();
        service.saveTarefa(new TarefaForm(tarefa));
        Mockito.verify(repository).save(captor.capture());
        assertEquals(captor.getValue().getTitulo(), tarefa.getTitulo());
    }

    private Tarefa tarefa(){
        return new Tarefa("Tarefa 1",
                "Criar Rotinas",
                "João",
                "BAIXA",
                new Date(),
                "Em andamento");
    }
}