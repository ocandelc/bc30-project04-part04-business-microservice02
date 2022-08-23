/**
 * Resumen.
 * Objeto                   : ProductSubTypeRuleServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.service.inte;

import com.nttdata.bootcamp.bank.product.springdata.document.ProductSubTypeRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface ProductSubTypeRuleServiceInte
{

    Mono<ProductSubTypeRule> create(final ProductSubTypeRule productSubTypeRule);

    Flux<ProductSubTypeRule> readAll();

    Mono<ProductSubTypeRule> findByCodeId(String codeProduct);

    Mono<ProductSubTypeRule> updateById(final String id, final ProductSubTypeRule productSubTypeRule);

    Mono<Void> deleteById(final String id);
}