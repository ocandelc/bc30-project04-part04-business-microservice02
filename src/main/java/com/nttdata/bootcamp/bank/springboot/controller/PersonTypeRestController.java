/**
 * Resumen.
 * Objeto                   : PersonTypeRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              25/08/2022        Oscar Candela           Modificación de la url.
 */
package com.nttdata.bootcamp.bank.springboot.controller;

import com.nttdata.bootcamp.bank.springboot.document.PersonType;
import com.nttdata.bootcamp.bank.springboot.service.inte.PersonTypeServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controller para invocar los métodos con rest api.
 */
@RestController
@RequestMapping("/api/business-microservice02-product/personType")
public class PersonTypeRestController {
    private static final Logger log = LoggerFactory.getLogger(PersonTypeRestController.class);

    @Autowired
    private PersonTypeServiceInte personTypeServiceInte;

    @PostMapping()
    public Mono<PersonType> create(@RequestBody final PersonType personType) {
        log.debug("Begin RestController create PersonType");
        return personTypeServiceInte.create(personType);
    }

    @GetMapping
    public Flux<PersonType> readAll() {
        log.debug("Begin RestController readAll PersonType");
        return personTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<PersonType> findByCodePersonType(@PathVariable String codePersonType) {
        log.debug("Begin RestController findByCodePersonType PersonType");
        return personTypeServiceInte.findByCodeId(codePersonType);
    }

    @PutMapping("/{id}")
    public Mono<PersonType> updateById(@RequestBody final PersonType personType, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById PersonType");
        return personTypeServiceInte.updateById(id, personType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById PersonType");
        return personTypeServiceInte.deleteById(id);
    }
}
