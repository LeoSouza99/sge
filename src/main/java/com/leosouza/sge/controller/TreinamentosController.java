package com.leosouza.sge.controller;

import com.leosouza.sge.domain.Treinamentos;
import com.leosouza.sge.services.TreinamentosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/treinamentos")
public class TreinamentosController {

    @Autowired
    private TreinamentosServices treinamentosServices;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Treinamentos> buscar(@PathVariable Long id) {
        Treinamentos treinamentos = treinamentosServices.buscar(id);
        return ResponseEntity.ok().body(treinamentos);
    }
}
