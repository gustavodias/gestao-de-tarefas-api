package dev.gustavdias.gestaodetarefasapi.controller.form;

import dev.gustavdias.gestaodetarefasapi.model.Tarefa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TarefaForm {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private String responsavel;
    @NotNull @NotEmpty
    private String prioridade;
    @NotNull
    private Date deadline;
    @NotNull @NotEmpty
    private String situacao;

    public TarefaForm(Tarefa tarefa) {
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
        this.prioridade = tarefa.getPrioridade();
        this.deadline = new Date();
        this.situacao = "Em andamento";
    }

    public Tarefa converter(){
        return new Tarefa(titulo,descricao,responsavel,prioridade,deadline,situacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getSituacao() {
        return situacao;
    }
}
