/**
 * Resumen.
 * Objeto                   : ProductClientServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 21/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.service.inte;

import com.nttdata.bootcamp.bank.springboot.document.ProductClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface ProductClientServiceInte {
    Mono<ProductClient> create(final ProductClient productClient);

    Flux<ProductClient> readAll();

    Mono<ProductClient> findByCodeId(String codeProductClient);

    Mono<ProductClient> updateById(final String id, final ProductClient productClient);

    Mono<Void> deleteById(final String id);
}
