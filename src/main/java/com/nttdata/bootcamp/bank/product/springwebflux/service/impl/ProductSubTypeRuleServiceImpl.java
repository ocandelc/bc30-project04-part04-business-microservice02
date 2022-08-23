/**
 * Resumen.
 * Objeto                   : ProductSubTypeRuleServiceImpl.java
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

import com.nttdata.bootcamp.bank.product.springwebflux.dao.inte.ProductSubTypeRuleDaoInte;
import com.nttdata.bootcamp.bank.product.springdata.document.ProductSubTypeRule;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.ProductSubTypeRuleServiceInte;
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
public class ProductSubTypeRuleServiceImpl implements ProductSubTypeRuleServiceInte {
    private static final Logger log = LoggerFactory.getLogger(ProductSubTypeRuleServiceInte.class);

    @Autowired
    private ProductSubTypeRuleDaoInte productSubTypeRuleDaoInte;

    @Override
    public Mono<ProductSubTypeRule> create(final ProductSubTypeRule product) {

        return productSubTypeRuleDaoInte.save(product)
                .doFirst(() -> log.info("Begin create ProductSubTypeRule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create ProductSubTypeRule"));
    }

    @Override
    public Flux<ProductSubTypeRule> readAll() {

        return productSubTypeRuleDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll ProductSubTypeRule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll ProductSubTypeRule"));
    }

    @Override
    public Mono<ProductSubTypeRule> findByCodeId(String codeProduct) {

        return productSubTypeRuleDaoInte.findById(codeProduct)
                .doFirst(() -> log.info("Begin findByCodeProduct ProductSubTypeRule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct ProductSubTypeRule"));
    }

    @Override
    public Mono<ProductSubTypeRule> updateById(final String id, final ProductSubTypeRule product) {

        return productSubTypeRuleDaoInte.save(product)
                .doFirst(() -> log.info("Begin updateById ProductSubTypeRule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById ProductSubTypeRule"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return productSubTypeRuleDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById ProductSubTypeRule"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById ProductSubTypeRule"));
    }

}