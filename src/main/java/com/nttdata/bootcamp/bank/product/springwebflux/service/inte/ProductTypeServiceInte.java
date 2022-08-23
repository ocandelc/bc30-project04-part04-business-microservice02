/**
 * Resumen.
 * Objeto                   : ProductTypeServiceInte.java
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

import com.nttdata.bootcamp.bank.product.springdata.document.ProductType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface ProductTypeServiceInte {

    Mono<ProductType> create(final ProductType productType);

    Flux<ProductType> readAll();

    Mono<ProductType> findByCodeId(String codeProductType);

    Mono<ProductType> updateById(final String id, final ProductType productType);

    Mono<Void> deleteById(final String id);
}
