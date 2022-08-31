/**
 * Resumen.
 * Objeto                   : ProductPersonServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 21/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.service.impl;

import com.nttdata.bootcamp.bank.springboot.dao.inte.ProductPersonDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.ProductPerson;
import com.nttdata.bootcamp.bank.springboot.service.inte.ProductPersonServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class ProductPersonServiceImpl implements ProductPersonServiceInte {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeServiceImpl.class);

    @Autowired
    private ProductPersonDaoInte productPersonDaoInte;

    @Override
    public Mono<ProductPerson> create(final ProductPerson productPerson) {
        return productPersonDaoInte.save(productPerson)
                .doFirst(() -> log.info("Begin create ProductPerson"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create ProductPerson"));
    }

    @Override
    public Flux<ProductPerson> readAll() {

        return productPersonDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll ProductPerson"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll ProductPerson"));
    }

    @Override
    public Mono<ProductPerson> findByCodeId(String codeProductPerson) {
        return productPersonDaoInte.findById(codeProductPerson)
                .doFirst(() -> log.info("Begin findByCodeProductPerson ProductPerson"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProductPerson ProductPerson"));
    }

    @Override
    public Mono<ProductPerson> updateById(final String id, final ProductPerson productPerson) {

        return productPersonDaoInte.save(productPerson)
                .doFirst(() -> log.info("Begin updateById productPerson"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById ProductPerson"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return productPersonDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById ProductPerson"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById ProductPerson"));
    }
}
