/**
 * Resumen.
 * Objeto                   : Person.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.product.springdata.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@AllArgsConstructor
@Document(collection="person")
public class Person {
    @Id
    private String id;
    private String codePerson;
    private String nameFirst;
    private String nameSecond;
    private String surnameFirst;
    private String surnameSecond;
    private String birthday;
    private String numberDocumentType;
    private String state;
    private String codeDocumentType;
    private String codePersonType;
}
