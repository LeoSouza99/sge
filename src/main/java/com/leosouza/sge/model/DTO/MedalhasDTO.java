package com.leosouza.sge.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leosouza.sge.domain.Medalhas;

import javax.validation.constraints.NotEmpty;
import java.util.Date;


public class MedalhasDTO {

    private Long id;

    @NotEmpty(message = "Campo nome obrigatório.")
    private String nome;

    @NotEmpty(message = "Campo descrição obrigatório.")
    private String descricao;
    private String imagem;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    public MedalhasDTO() {
    }

    public MedalhasDTO(Medalhas medalhas) {
        id = medalhas.getId();
        nome = medalhas.getNome();
        descricao = medalhas.getDescricao();
        imagem = medalhas.getImagem();
        data = medalhas.getData();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
