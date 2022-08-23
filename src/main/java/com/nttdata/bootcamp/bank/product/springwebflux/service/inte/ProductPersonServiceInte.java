/**
 * Resumen.
 * Objeto                   : ProductPersonServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 21/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.service.inte;

import com.nttdata.bootcamp.bank.product.springdata.document.ProductPerson;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface ProductPersonServiceInte {
    Mono<ProductPerson> create(final ProductPerson productPerson);

    Flux<ProductPerson> readAll();

    Mono<ProductPerson> findByCodeId(String codeProductPerson);

    Mono<ProductPerson> updateById(final String id, final ProductPerson productPerson);

    Mono<Void> deleteById(final String id);
}