/**
 * Resumen.
 * Objeto                   : ProductTypeRestController.java
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

import com.nttdata.bootcamp.bank.product.springdata.document.ProductType;
import com.nttdata.bootcamp.bank.product.springwebflux.service.impl.ProductTypeServiceImpl;
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
@RequestMapping("/api/productType")
public class ProductTypeRestController {
    private static final Logger log = LoggerFactory.getLogger(ProductTypeRestController.class);

    @Autowired
    private ProductTypeServiceImpl productTypeServiceInte;

    @PostMapping("create")
    public Mono<ProductType> create(@RequestBody final ProductType productType) {
        log.debug("Begin RestController create ProductType");
        return productTypeServiceInte.create(productType);
    }

    @GetMapping
    public Flux<ProductType> readAll() {
        log.debug("Begin RestController readAll ProductType");
        return productTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<ProductType> findByCodeProductType(@PathVariable String codeProductType) {
        log.debug("Begin RestController findByCodeProductType ProductType");
        return productTypeServiceInte.findByCodeId(codeProductType);
    }

    @PutMapping("update/{id}")
    public Mono<ProductType> updateById(@RequestBody final ProductType productType, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById ProductType");
        return productTypeServiceInte.updateById(id, productType);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById ProductType");
        return productTypeServiceInte.deleteById(id);
    }
}
