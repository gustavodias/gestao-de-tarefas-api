package dev.gustavdias.gestaodetarefasapi.repository;

import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
