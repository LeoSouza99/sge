package com.leosouza.sge.services.defaultServices;

import com.leosouza.sge.domain.Missoes;
import com.leosouza.sge.repositories.MissoesRepository;
import com.leosouza.sge.services.MissoesServices;
import com.leosouza.sge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissoesDefaultServices implements MissoesServices {

    @Autowired
    private MissoesRepository missoesRepository;

    @Override
    public Missoes buscar(Long id) {
        Optional<Missoes> missoes = missoesRepository.findById(id);
        return missoes.orElseThrow(() -> new ObjectNotFoundException ("Id não encontrado! ID: " + id
        ));
    }
}
