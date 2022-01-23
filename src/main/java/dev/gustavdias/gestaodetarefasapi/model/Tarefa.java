package dev.gustavdias.gestaodetarefasapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity(name = "Tarefa")
@Table(name = "Tarefa")
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String responsavel;

    @Column
    private String prioridade;

    @Column
    private String deadline;

    @Column
    private String status;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String responsavel, String prioridade, String deadline, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.deadline = deadline;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tarefa tarefa = (Tarefa) o;
        return id != null && Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
