package com.nttdata.bootcamp.bank.product.springflux.controller;

import com.nttdata.bootcamp.bank.product.model.document.Product;
import com.nttdata.bootcamp.bank.product.service.inte.ProductServiceInte;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;

@SpringBootTest
public class ProductRestControllerTest {

    @MockBean
    private ProductServiceInte productServiceInte;

    @Test
    void readAllTest() {

        Flux<Product> fluxLocation = productServiceInte.readAll();

        Mockito.verify(productServiceInte).readAll();

     }

}
