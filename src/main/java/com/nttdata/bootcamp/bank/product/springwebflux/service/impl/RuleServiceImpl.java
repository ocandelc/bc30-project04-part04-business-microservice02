/**
 * Resumen.
 * Objeto                   : RuleServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.service.impl;

import com.nttdata.bootcamp.bank.product.springwebflux.dao.inte.RuleDaoInte;
import com.nttdata.bootcamp.bank.product.springdata.document.Rule;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.RuleServiceInte;
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
public class RuleServiceImpl implements RuleServiceInte {
    private static final Logger log = LoggerFactory.getLogger(RuleServiceImpl.class);

    @Autowired
    private RuleDaoInte ruleDaoInte;

    @Override
    public Mono<Rule> create(final Rule product) {

        return ruleDaoInte.save(product)
                .doFirst(() -> log.info("Begin create Rule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Rule"));
    }

    @Override
    public Flux<Rule> readAll() {

        return ruleDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Rule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Rule"));
    }

    @Override
    public Mono<Rule> findById(String codeProduct) {

        return ruleDaoInte.findById(codeProduct)
                .doFirst(() -> log.info("Begin findByCodeProduct Rule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct Rule"));
    }

    @Override
    public Mono<Rule> updateById(final String id, final Rule product) {

        return ruleDaoInte.save(product)
                .doFirst(() -> log.info("Begin updateById Rule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Rule"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return ruleDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Rule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Rule"));
    }

}