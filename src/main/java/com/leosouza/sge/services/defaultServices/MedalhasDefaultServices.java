package com.leosouza.sge.services.defaultServices;

import com.leosouza.sge.domain.Medalhas;
import com.leosouza.sge.model.repositories.MedalhasRepository;
import com.leosouza.sge.services.MedalhasServices;
import com.leosouza.sge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedalhasDefaultServices implements MedalhasServices {

    @Autowired
    private MedalhasRepository medalhasRepository;

    @Override
    public Medalhas buscar(Long id) {
        Optional<Medalhas> medalhas = medalhasRepository.findById(id);
        return medalhas.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado! ID: " + id
        ));
    }
}
