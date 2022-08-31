/**
 * Resumen.
 * Objeto                   : ProductSubTypeServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.service.impl;

import com.nttdata.bootcamp.bank.springboot.dao.inte.ProductSubTypeDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.ProductSubType;
import com.nttdata.bootcamp.bank.springboot.service.inte.ProductSubTypeServiceInte;
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
public class ProductSubTypeServiceImpl implements ProductSubTypeServiceInte {
    private static final Logger log = LoggerFactory.getLogger(ProductSubTypeServiceImpl.class);

    @Autowired
    private ProductSubTypeDaoInte productSubTypeDaoInte;

    @Override
    public Mono<ProductSubType> create(final ProductSubType product) {

        return productSubTypeDaoInte.save(product)
                .doFirst(() -> log.info("Begin create ProductSubType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create ProductSubType"));
    }

    @Override
    public Flux<ProductSubType> readAll() {

        return productSubTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll ProductSubType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll ProductSubType"));
    }

    @Override
    public Mono<ProductSubType> findByCodeId(String codeProduct) {

        return productSubTypeDaoInte.findById(codeProduct)
                .doFirst(() -> log.info("Begin findByCodeProduct ProductSubType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct ProductSubType"));
    }

    @Override
    public Mono<ProductSubType> updateById(final String id, final ProductSubType product) {

        return productSubTypeDaoInte.save(product)
                .doFirst(() -> log.info("Begin updateById ProductSubType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById ProductSubType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return productSubTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Product"));
    }

}