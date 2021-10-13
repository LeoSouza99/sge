package com.leosouza.sge.services.defaultServices;

import com.leosouza.sge.domain.Treinamentos;
import com.leosouza.sge.model.repositories.TreinamentosRepository;
import com.leosouza.sge.services.TreinamentosServices;
import com.leosouza.sge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreinamentosDefaultServices implements TreinamentosServices {

    @Autowired
    private TreinamentosRepository treinamentosRepository;

    @Override
    public Treinamentos buscar(Long id) {
        Optional<Treinamentos> treinamentos = treinamentosRepository.findById(id);
        return treinamentos.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado! ID: " + id
        ));
    }
}
