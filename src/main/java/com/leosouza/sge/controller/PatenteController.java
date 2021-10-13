package com.leosouza.sge.controller;

import com.leosouza.sge.domain.Patente;
import com.leosouza.sge.services.PatenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
