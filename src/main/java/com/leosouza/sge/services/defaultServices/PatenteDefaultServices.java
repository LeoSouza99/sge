package com.leosouza.sge.services.defaultServices;

import com.leosouza.sge.domain.Patente;
import com.leosouza.sge.model.DTO.PatenteDTO;
import com.leosouza.sge.model.repositories.PatenteRepository;
import com.leosouza.sge.services.PatenteServices;
import com.leosouza.sge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Patente fromDTO(PatenteDTO patenteDTO) {
        Patente patente = new Patente(null, patenteDTO.getNome());
        return patente;
    }

    @Override
    public Patente inserir(Patente patente) {
        patente.setId(null);
        return patenteRepository.save(patente);
    }

    @Override
    public Patente alterar(Patente patente) {
        Patente newPatente = buscar(patente.getId());
        alterarDados(newPatente, patente);
        return patenteRepository.save(newPatente);
    }

    @Override
    public void deletar(Long id) {
        buscar(id);
        patenteRepository.deleteById(id);
    }

    @Override
    public List<Patente> buscarTodos() {
        return patenteRepository.findAll();
    }

    private void alterarDados(Patente newPatente, Patente patente) {
        newPatente.setNome(patente.getNome());
    }
}
