package com.leosouza.sge.controller;

import com.leosouza.sge.domain.Missoes;
import com.leosouza.sge.services.MissoesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/missoes")
public class MissoesController {

    @Autowired
    private MissoesServices missoesServices;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Missoes> buscar(@PathVariable Long id) {
        Missoes missoes = missoesServices.buscar(id);
        return ResponseEntity.ok().body(missoes);
    }

}
