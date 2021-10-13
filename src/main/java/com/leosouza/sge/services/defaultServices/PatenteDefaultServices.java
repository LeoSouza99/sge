package com.leosouza.sge.services.defaultServices;

import com.leosouza.sge.domain.Patente;
import com.leosouza.sge.repositories.PatenteRepository;
import com.leosouza.sge.services.PatenteServices;
import com.leosouza.sge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatenteDefaultServices implements PatenteServices {

    @Autowired
    private PatenteRepository patenteRepository;

    @Override
    public Patente buscar(Long id) {
        Optional<Patente> patente = patenteRepository.findById(id);
        return patente.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado! ID: " + id
        ));
    }
}
