package com.leosouza.sge.services.defaultServices;

import com.leosouza.sge.domain.Medalhas;
import com.leosouza.sge.model.DTO.MedalhasDTO;
import com.leosouza.sge.model.repositories.MedalhasRepository;
import com.leosouza.sge.services.MedalhasServices;
import com.leosouza.sge.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Medalhas fromDTO(MedalhasDTO medalhasDTO) {
        Medalhas medalhas = new Medalhas(null,
                medalhasDTO.getNome(),
                medalhasDTO.getDescricao(),
                medalhasDTO.getImagem(),
                medalhasDTO.getData());
        return medalhas;
    }

    @Override
    public Medalhas inserir(Medalhas medalhas) {
        medalhas.setId(null);
        return medalhasRepository.save(medalhas);
    }

    @Override
    public Medalhas alterar(Medalhas medalhas) {
        Medalhas newMedalhas = buscar(medalhas.getId());
        alterarDados(newMedalhas, medalhas);
        return medalhasRepository.save(newMedalhas);
    }

    private void alterarDados(Medalhas newMedalhas, Medalhas medalhas) {
        newMedalhas.setNome(medalhas.getNome());
        newMedalhas.setData(medalhas.getData());
        newMedalhas.setDescricao(medalhas.getDescricao());
        newMedalhas.setImagem(medalhas.getImagem());
    }

    @Override
    public void deletar(Long id) {
        buscar(id);
        medalhasRepository.deleteById(id);
    }

    @Override
    public List<Medalhas> buscarTodos() {
        return medalhasRepository.findAll();
    }
}
