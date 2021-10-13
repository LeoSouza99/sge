package com.leosouza.sge.model.DTO;

import com.leosouza.sge.domain.Patente;

import javax.validation.constraints.NotEmpty;

public class PatenteDTO {

    private Long id;

    @NotEmpty(message = "O campo nome não pode estar vazio.")
    private String nome;

    public PatenteDTO() {
    }

    public PatenteDTO(Patente patente) {
        id = patente.getId();
        nome = patente.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
