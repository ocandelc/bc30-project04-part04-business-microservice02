/**
 * Resumen.
 * Objeto                   : ProductSubTypeRuleRestController.java
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

import com.nttdata.bootcamp.bank.springboot.document.ProductSubTypeRule;
import com.nttdata.bootcamp.bank.springboot.service.inte.ProductSubTypeRuleServiceInte;
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
@RequestMapping("/api/business-microservice02-product/productsubtyperule")
public class ProductSubTypeRuleRestController
{
    private static final Logger log = LoggerFactory.getLogger(ProductSubTypeRuleRestController.class);

    @Autowired
    private ProductSubTypeRuleServiceInte productSubTypeRuleServiceInte;

    @PostMapping()
    public Mono<ProductSubTypeRule> create(@RequestBody final ProductSubTypeRule product) {
        log.debug("Begin RestController create Product");
        return productSubTypeRuleServiceInte.create(product);
    }

    @GetMapping
    public Flux<ProductSubTypeRule> readAll() {
        log.debug("Begin RestController readAll Product");
        return productSubTypeRuleServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<ProductSubTypeRule> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return productSubTypeRuleServiceInte.findByCodeId(codeProduct);
    }

    @PutMapping("/{id}")
    public Mono<ProductSubTypeRule> updateById(@RequestBody final ProductSubTypeRule product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return productSubTypeRuleServiceInte.updateById(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return productSubTypeRuleServiceInte.deleteById(id);
    }

}