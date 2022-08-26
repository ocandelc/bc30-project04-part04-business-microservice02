/**
 * Resumen.
 * Objeto                   : PersonRestController.java
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
package com.nttdata.bootcamp.bank.product.springwebflux.controller;

import com.nttdata.bootcamp.bank.product.springdata.document.Person;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.PersonServiceInte;
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
@RequestMapping("/api/business-microservice02-product/person")
public class PersonRestController {
    private static final Logger log = LoggerFactory.getLogger(PersonRestController.class);

    @Autowired
    private PersonServiceInte personServiceInte;

    @PostMapping()
    public Mono<Person> create(@RequestBody final Person person) {
        log.debug("Begin RestController create Person");
        return personServiceInte.create(person);
    }

    @GetMapping
    public Flux<Person> readAll() {
        log.debug("Begin RestController readAll Person");
        return personServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<Person> findByCodePerson(@PathVariable String codePerson) {
        log.debug("Begin RestController findByCodePerson Person");
        return personServiceInte.findByCodeId(codePerson);
    }

    @PutMapping("/{id}")
    public Mono<Person> updateById(@RequestBody final Person person, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Person");
        return personServiceInte.updateById(id, person);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Person");
        return personServiceInte.deleteById(id);
    }
}
