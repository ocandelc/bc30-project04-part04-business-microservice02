/**
 * Resumen.
 * Objeto                   : ProductPersonDaoInte.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 21/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.dao.inte;

import com.nttdata.bootcamp.bank.springboot.document.ProductPerson;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductPersonDaoInte extends ReactiveMongoRepository<ProductPerson, String> {
    Mono<ProductPerson> findById(String id);
}
