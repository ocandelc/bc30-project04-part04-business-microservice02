/**
 * Resumen.
 * Objeto                   : ProductClientRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 21/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.controller;

import com.nttdata.bootcamp.bank.product.springdata.document.ProductClient;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.ProductClientServiceInte;
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
@RequestMapping("/api/productClient")
public class ProductClientRestController {
    private static final Logger log = LoggerFactory.getLogger(ProductClientRestController.class);

    @Autowired
    private ProductClientServiceInte productClientServiceInte;

    @PostMapping("create")
    public Mono<ProductClient> create(@RequestBody final ProductClient productClient) {
        log.debug("Begin RestController create ProductClient");
        return productClientServiceInte.create(productClient);
    }

    @GetMapping
    public Flux<ProductClient> readAll() {
        log.debug("Begin RestController readAll ProductClient");
        return productClientServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<ProductClient> findByCodeProductClient(@PathVariable String codeProductClient) {
        log.debug("Begin RestController findByCodeProductClient ProductClient");
        return productClientServiceInte.findByCodeId(codeProductClient);
    }

    @PutMapping("update/{id}")
    public Mono<ProductClient> updateById(@RequestBody final ProductClient productClient, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById ProductClient");
        return productClientServiceInte.updateById(id, productClient);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById ProductClient");
        return productClientServiceInte.deleteById(id);
    }
}
