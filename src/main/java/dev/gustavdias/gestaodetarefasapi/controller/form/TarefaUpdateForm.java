package dev.gustavdias.gestaodetarefasapi.controller.form;

import dev.gustavdias.gestaodetarefasapi.model.Tarefa;
import dev.gustavdias.gestaodetarefasapi.repository.TarefaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TarefaUpdateForm {

    @NotNull
    @NotEmpty
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

    public TarefaUpdateForm(Tarefa tarefa) {
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
        this.prioridade = tarefa.getPrioridade();
        this.deadline = tarefa.getDeadline();
        this.situacao = tarefa.getSituacao();
    }

    public Tarefa atualizarDados(Long id, TarefaRepository repository){
        var tarefa = repository.findById(id);
        tarefa.get().setTitulo(this.titulo);
        tarefa.get().setDescricao(this.descricao);
        tarefa.get().setResponsavel(this.responsavel);
        tarefa.get().setPrioridade(this.prioridade);
        tarefa.get().setDeadline(this.deadline);
        tarefa.get().setSituacao(this.situacao);
        return tarefa.get();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
