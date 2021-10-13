package com.leosouza.sge.controller;

import com.leosouza.sge.domain.Medalhas;
import com.leosouza.sge.model.DTO.MedalhasDTO;
import com.leosouza.sge.services.MedalhasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/medalhas")
public class MedalhasController {

    @Autowired
    private MedalhasServices medalhasServices;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medalhas> buscar(@PathVariable Long id) {
        Medalhas medalhas = medalhasServices.buscar(id);
        return ResponseEntity.ok().body(medalhas);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody MedalhasDTO medalhasDTO) {
        Medalhas medalhas = medalhasServices.fromDTO(medalhasDTO);
        medalhas = medalhasServices.inserir(medalhas);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(medalhas.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@Valid @RequestBody MedalhasDTO medalhasDTO, @PathVariable Long id) {
        Medalhas medalhas = medalhasServices.fromDTO(medalhasDTO);
        medalhas.setId(id);
        medalhas = medalhasServices.alterar(medalhas);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medalhasServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MedalhasDTO>> listar() {
        List<Medalhas> list = medalhasServices.buscarTodos();
        List<MedalhasDTO> dtoList = list.stream().map(obj -> new MedalhasDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

}
