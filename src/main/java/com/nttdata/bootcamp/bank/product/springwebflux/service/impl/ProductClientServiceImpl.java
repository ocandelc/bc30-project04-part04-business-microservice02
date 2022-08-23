/**
 * Resumen.
 * Objeto                   : ProductClientServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 21/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.service.impl;

import com.nttdata.bootcamp.bank.product.springwebflux.dao.inte.ProductClientDaoInte;
import com.nttdata.bootcamp.bank.product.springdata.document.ProductClient;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.ProductClientServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class ProductClientServiceImpl implements ProductClientServiceInte {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeServiceImpl.class);

    @Autowired
    private ProductClientDaoInte productClientDaoInte;

    @Override
    public Mono<ProductClient> create(final ProductClient productClient) {
        return productClientDaoInte.save(productClient)
                .doFirst(() -> log.info("Begin create ProductClient"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create ProductClient"));
    }

    @Override
    public Flux<ProductClient> readAll() {

        return productClientDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll ProductClient"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll ProductClient"));
    }

    @Override
    public Mono<ProductClient> findByCodeId(String codeProductClient) {
        return productClientDaoInte.findById(codeProductClient)
                .doFirst(() -> log.info("Begin findByCodeProductClient ProductClient"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProductClient ProductClient"));
    }

    @Override
    public Mono<ProductClient> updateById(final String id, final ProductClient productClient) {

        return productClientDaoInte.save(productClient)
                .doFirst(() -> log.info("Begin updateById productClient"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById ProductClient"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return productClientDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById ProductClient"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById ProductClient"));
    }
}
