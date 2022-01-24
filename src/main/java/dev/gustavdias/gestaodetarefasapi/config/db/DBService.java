package dev.gustavdias.gestaodetarefasapi.config.db;

import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import dev.gustavdias.gestaodetarefasapi.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    private TarefaRepository tarefaRepository;

    public DBService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public void instaciaBaseDeDados(){

        Tarefa tarefa1 = new Tarefa("Tarefa 1","Criar Rotinas", "João", "BAIXA", new Date(), "Em andamento");
        Tarefa tarefa2 = new Tarefa("Tarefa 2","Implementar Service", "Antônio", "MÉDIA", new Date(), "Em andamento");
        Tarefa tarefa3 = new Tarefa("Tarefa 3","Implementar Controller", "João", "BAIXA", new Date(), "Em andamento");
        Tarefa tarefa4 = new Tarefa("Tarefa 4","Implementar Repository", "Guilherme", "ALTA", new Date(), "Em andamento");

        this.tarefaRepository.saveAll(Arrays.asList(tarefa1, tarefa2, tarefa3, tarefa4));
    }
}
