package com.upt.lp.R_Equipa16.model;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Prioridade {
	
    private String nivelPrioridade;

    public String getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(String nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }
}
