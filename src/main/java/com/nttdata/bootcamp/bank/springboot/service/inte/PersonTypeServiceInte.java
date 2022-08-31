/**
 * Resumen.
 * Objeto                   : PersonTypeServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.service.inte;

import com.nttdata.bootcamp.bank.springboot.document.PersonType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface PersonTypeServiceInte {
    Mono<PersonType> create(final PersonType personType);

    Flux<PersonType> readAll();

    Mono<PersonType> findByCodeId(String codePersonType);

    Mono<PersonType> updateById(final String id, final PersonType personType);

    Mono<Void> deleteById(final String id);
}
