package com.leosouza.sge.services;

import com.leosouza.sge.domain.Medalhas;
import com.leosouza.sge.model.DTO.MedalhasDTO;

import java.util.List;

public interface MedalhasServices {

    Medalhas buscar(Long id);

    Medalhas fromDTO(MedalhasDTO medalhasDTO);

    Medalhas inserir(Medalhas medalhas);

    Medalhas alterar(Medalhas medalhas);

    void deletar(Long id);

    List<Medalhas> buscarTodos();
}
