package com.upt.lp.R_Equipa16.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "lista_de_tarefas")
public class ListaDeTarefas extends Prioridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private boolean tarefaCompleta;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isTarefaCompleta() {
        return tarefaCompleta;
    }

    public void setTarefaCompleta(boolean tarefaCompleta) {
        this.tarefaCompleta = tarefaCompleta;
    }

}
