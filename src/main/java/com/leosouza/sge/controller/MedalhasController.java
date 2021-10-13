package com.leosouza.sge.controller;

import com.leosouza.sge.domain.Medalhas;
import com.leosouza.sge.services.MedalhasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
