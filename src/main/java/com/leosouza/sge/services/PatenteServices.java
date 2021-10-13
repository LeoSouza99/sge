package com.leosouza.sge.services;

import com.leosouza.sge.domain.Patente;
import com.leosouza.sge.model.DTO.PatenteDTO;

import java.util.List;

public interface PatenteServices {

    Patente buscar(Long id);

    Patente fromDTO(PatenteDTO patenteDTO);

    Patente inserir(Patente patente);

    Patente alterar(Patente patente);

    void deletar(Long id);

    List<Patente> buscarTodos();
}
