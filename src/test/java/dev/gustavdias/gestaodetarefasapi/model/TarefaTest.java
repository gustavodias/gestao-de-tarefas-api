package dev.gustavdias.gestaodetarefasapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TarefaTest {

    @Test
    public void deveriaCriarTarefa(){
        var tarefa = tarefa();
        assertEquals("Tarefa 1", tarefa.getTitulo());
        assertTrue(tarefa.toString().contains("Rotinas"));
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