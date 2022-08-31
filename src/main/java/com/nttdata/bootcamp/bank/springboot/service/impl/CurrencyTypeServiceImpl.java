/**
 * Resumen.
 * Objeto                   : CurrencyTypeServiceImpl.java
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

import com.nttdata.bootcamp.bank.springboot.dao.inte.CurrencyTypeDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.CurrencyType;
import com.nttdata.bootcamp.bank.springboot.service.inte.CurrencyTypeServiceInte;
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
public class CurrencyTypeServiceImpl implements CurrencyTypeServiceInte {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeServiceImpl.class);

    @Autowired
    private CurrencyTypeDaoInte currencyTypeDaoInte;

    @Override
    public Mono<CurrencyType> create(final CurrencyType product) {

        return currencyTypeDaoInte.save(product)
                .doFirst(() -> log.info("Begin create CurrencyType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create CurrencyType"));
    }

    @Override
    public Flux<CurrencyType> readAll() {

        return currencyTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll CurrencyType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll CurrencyType"));
    }

    @Override
    public Mono<CurrencyType> findByCodeId(String codeProduct) {
        return currencyTypeDaoInte.findById(codeProduct)
                .doFirst(() -> log.info("Begin findByCodeProduct CurrencyType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct CurrencyType"));
    }

    @Override
    public Mono<CurrencyType> updateById(final String id, final CurrencyType product) {

        return currencyTypeDaoInte.save(product)
                .doFirst(() -> log.info("Begin updateById CurrencyType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById CurrencyType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return currencyTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById CurrencyType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById CurrencyType"));
    }

}