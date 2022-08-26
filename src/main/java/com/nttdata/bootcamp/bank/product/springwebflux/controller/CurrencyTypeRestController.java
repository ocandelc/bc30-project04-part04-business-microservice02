/**
 * Resumen.
 * Objeto                   : CurrencyTypeRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.controller;

import com.nttdata.bootcamp.bank.product.springdata.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.CurrencyTypeServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de controller para invocar los métodos con rest api.
 */
@RestController
@RequestMapping("/api/business-microservice02-product/currencytype")
public class CurrencyTypeRestController {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeRestController.class);

    @Autowired
    private CurrencyTypeServiceInte currencyTypeServiceInte;

    @PostMapping()
    public Mono<CurrencyType> create(@RequestBody final CurrencyType product) {
        log.debug("Begin RestController create Product");
        return currencyTypeServiceInte.create(product);
    }

    @GetMapping
    public Flux<CurrencyType> readAll() {
        log.debug("Begin RestController readAll Product");
        return currencyTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<CurrencyType> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return currencyTypeServiceInte.findByCodeId(codeProduct);
    }

    @PutMapping("/{id}")
    public Mono<CurrencyType> updateById(@RequestBody final CurrencyType product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return currencyTypeServiceInte.updateById(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return currencyTypeServiceInte.deleteById(id);
    }

}