/**
 * Resumen.
 * Objeto                   : ProductServiceImpl.java
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

import com.nttdata.bootcamp.bank.product.springwebflux.dao.inte.ProductDaoInte;
import com.nttdata.bootcamp.bank.product.springdata.document.Product;
import com.nttdata.bootcamp.bank.product.springwebflux.service.inte.ProductServiceInte;
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
public class ProductServiceImpl implements ProductServiceInte {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDaoInte productDaoInte;

    @Override
    public Mono<Product> create(final Product product) {

        var v =  productDaoInte.save(product)
                .doFirst(() -> log.info("Begin create Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Product"));
        v.subscribe();

        return v;
    }

    @Override
    public Flux<Product> readAll() {

        return productDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Product"));
    }

    @Override
    public Mono<Product> findByCodeProduct(String codeProduct) {
        return productDaoInte.findByCodeProduct(codeProduct)
                .doFirst(() -> log.info("Begin findByCodeProduct Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct Product"));
    }

    @Override
    public Mono<Product> updateById(final String id, final Product product) {

        var v = productDaoInte.save(product)
                .doFirst(() -> log.info("Begin updateById Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Product"));
        v.subscribe();
        return v;
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        var v = productDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Product"));
        v.subscribe();
        return v;
    }

}