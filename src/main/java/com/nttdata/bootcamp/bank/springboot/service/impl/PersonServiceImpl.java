/**
 * Resumen.
 * Objeto                   : PersonServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.service.impl;

import com.nttdata.bootcamp.bank.springboot.dao.inte.PersonDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.Person;
import com.nttdata.bootcamp.bank.springboot.service.inte.PersonServiceInte;
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
public class PersonServiceImpl implements PersonServiceInte {
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeServiceImpl.class);

    @Autowired
    private PersonDaoInte personDaoInte;

    @Override
    public Mono<Person> create(final Person person) {
        return personDaoInte.save(person)
                .doFirst(() -> log.info("Begin create Person"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Person"));
    }

    @Override
    public Flux<Person> readAll() {

        return personDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Person"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Person"));
    }

    @Override
    public Mono<Person> findByCodeId(String codePerson) {
        return personDaoInte.findById(codePerson)
                .doFirst(() -> log.info("Begin findByCodePerson Person"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodePerson Person"));
    }

    @Override
    public Mono<Person> updateById(final String id, final Person person) {

        return personDaoInte.save(person)
                .doFirst(() -> log.info("Begin updateById person"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Person"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return personDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Person"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Person"));
    }
}
