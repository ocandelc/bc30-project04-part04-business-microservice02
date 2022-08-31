/**
 * Resumen.
 * Objeto                   : ProductTypeServiceImpl.java
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

import com.nttdata.bootcamp.bank.springboot.dao.inte.ProductTypeDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.ProductType;
import com.nttdata.bootcamp.bank.springboot.service.inte.ProductTypeServiceInte;
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
public class ProductTypeServiceImpl implements ProductTypeServiceInte {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeServiceImpl.class);

    @Autowired
    private ProductTypeDaoInte productTypeDaoInte;

    @Override
    public Mono<ProductType> create(final ProductType productType) {

        return productTypeDaoInte.save(productType)
                .doFirst(() -> log.info("Begin create ProductType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create ProductType"));
    }

    @Override
    public Flux<ProductType> readAll() {

        return productTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll ProductType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll ProductType"));
    }

    @Override
    public Mono<ProductType> findByCodeId(String codeProductType) {
        return productTypeDaoInte.findById(codeProductType)
                .doFirst(() -> log.info("Begin findByCodeProductType ProductType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProductType ProductType"));
    }

    @Override
    public Mono<ProductType> updateById(final String id, final ProductType productType) {

        return productTypeDaoInte.save(productType)
                .doFirst(() -> log.info("Begin updateById productType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById ProductType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return productTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById ProductType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById ProductType"));
    }
}
