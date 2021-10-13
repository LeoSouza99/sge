package com.leosouza.sge.controller;

import com.leosouza.sge.domain.Patente;
import com.leosouza.sge.model.DTO.PatenteDTO;
import com.leosouza.sge.services.PatenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/patente")
public class PatenteController {

    @Autowired
    private PatenteServices patenteServices;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Patente> buscar(@PathVariable Long id) {
        Patente patente = patenteServices.buscar(id);
        return ResponseEntity.ok().body(patente);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody PatenteDTO patenteDTO) {
        Patente patente = patenteServices.fromDTO(patenteDTO);
        patente = patenteServices.inserir(patente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@Valid @RequestBody PatenteDTO patenteDTO, @PathVariable Long id) {
        Patente patente = patenteServices.fromDTO(patenteDTO);
        patente.setId(id);
        patente = patenteServices.alterar(patente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        patenteServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PatenteDTO>> listar() {
        List<Patente> list = patenteServices.buscarTodos();
        List<PatenteDTO> dtoList = list.stream().map(obj -> new PatenteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

}
