package dev.gustavdias.gestaodetarefasapi.repository;

import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findAllByOrderByIdAsc();
    List<Tarefa> findAllBySituacao(String situacao);

    @Query(value = "SELECT * FROM TAREFA where titulo LIKE ?1 or descricao LIKE ?1 or responsavel  = ?2 or situacao  = ?3", nativeQuery = true)
    List<Tarefa> findByParam(String tituloDescricao, String responsavel, String situacao);

}
