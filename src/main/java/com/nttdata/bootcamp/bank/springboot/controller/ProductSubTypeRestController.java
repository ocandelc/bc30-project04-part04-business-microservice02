/**
 * Resumen.
 * Objeto                   : ProductSubTypeRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.controller;

import com.nttdata.bootcamp.bank.springboot.document.ProductSubType;
import com.nttdata.bootcamp.bank.springboot.service.inte.ProductServiceInte;
import com.nttdata.bootcamp.bank.springboot.service.inte.ProductSubTypeServiceInte;
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
@RequestMapping("/api/business-microservice02-product/productsubtype")
public class ProductSubTypeRestController
{
    private static final Logger log = LoggerFactory.getLogger(ProductServiceInte.class);

    @Autowired
    private ProductSubTypeServiceInte productSubTypeServiceInte;

    @PostMapping()
    public Mono<ProductSubType> create(@RequestBody final ProductSubType product) {
        log.debug("Begin RestController create Product");
        return productSubTypeServiceInte.create(product);
    }

    @GetMapping
    public Flux<ProductSubType> readAll() {
        log.debug("Begin RestController readAll Product");
        return productSubTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<ProductSubType> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return productSubTypeServiceInte.findByCodeId(codeProduct);
    }

    @PutMapping("/{id}")
    public Mono<ProductSubType> updateById(@RequestBody final ProductSubType product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return productSubTypeServiceInte.updateById(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return productSubTypeServiceInte.deleteById(id);
    }

}