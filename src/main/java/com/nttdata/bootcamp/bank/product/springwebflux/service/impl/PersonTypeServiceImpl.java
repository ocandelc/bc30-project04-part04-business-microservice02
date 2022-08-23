/**
 * Resumen.
 * Objeto                   : PersonTypeServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.service.impl;

import com.nttdata.bootcamp.bank.product.springwebflux.dao.inte.PersonTypeDaoInte;
import com.nttdata.bootcamp.bank.product.springdata.document.PersonType;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.PersonTypeServiceInte;
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
public class PersonTypeServiceImpl implements PersonTypeServiceInte {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeServiceImpl.class);

    @Autowired
    private PersonTypeDaoInte personTypeDaoInte;

    @Override
    public Mono<PersonType> create(final PersonType personType) {
        return personTypeDaoInte.save(personType)
                .doFirst(() -> log.info("Begin create PersonType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create PersonType"));
    }

    @Override
    public Flux<PersonType> readAll() {

        return personTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll PersonType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll PersonType"));
    }

    @Override
    public Mono<PersonType> findByCodeId(String codePersonType) {
        return personTypeDaoInte.findById(codePersonType)
                .doFirst(() -> log.info("Begin findByCodePersonType PersonType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodePersonType PersonType"));
    }

    @Override
    public Mono<PersonType> updateById(final String id, final PersonType personType) {

        return personTypeDaoInte.save(personType)
                .doFirst(() -> log.info("Begin updateById personType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById PersonType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return personTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById PersonType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById PersonType"));
    }
}
