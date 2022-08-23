/**
 * Resumen.
 * Objeto                   : RuleDaoInte.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springwebflux.dao.inte;

import com.nttdata.bootcamp.bank.product.springdata.document.Rule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RuleDaoInte extends ReactiveMongoRepository<Rule, String> {
    Mono<Rule> findById(String id);
}
