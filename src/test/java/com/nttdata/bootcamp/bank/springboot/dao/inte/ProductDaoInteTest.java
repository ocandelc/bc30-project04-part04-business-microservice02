package com.nttdata.bootcamp.bank.springboot.dao.inte;

import com.nttdata.bootcamp.bank.springboot.document.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class ProductDaoInteTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoInteTest.class);

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        logger.debug("INICIO TEST");

        closeable = MockitoAnnotations.openMocks(this);

        Product object01 = new Product(
                "9",
                "cuenta prueba",
                "cuenta prueba",
                "100-193-0015535759",
                "01-100-193-0015535759",
                "1",
                "PS-0000000001",
                "CT-0000000001",
                "P-0000000001");


        Mono<Product> monoObjectTest = Mono.just(object01);

        Mono<Product> monoObjectDatabase = productDaoInte.findByCodeProduct("P-0000000001");

        Mockito.when(monoObjectDatabase).thenReturn(monoObjectTest);

    }

    @AfterEach
    void tearDown() throws Exception {
        logger.debug("FIN TEST");

        closeable.close();
    }

    @Mock
    ProductDaoInte productDaoInte;

    @Test
    @Order(1)
    public void createProductTest() {
        Product object03 = new Product(
                "9",
                "cuenta prueba",
                "cuenta prueba",
                "100-193-0015535759",
                "01-100-193-0015535759",
                "1",
                "PS-0000000001",
                "CT-0000000001",
                "P-0000000001");

        Mono<Product> monoObjectDatabase = productDaoInte.save(object03);

        Mockito.verify(productDaoInte).save(object03);
    }

    @Test
    @Order(2)
    public void readByCodeProductTest() {

        Mono<Product> monoObjectDatabase = productDaoInte.findByCodeProduct("P-0000000001");

        Mockito.verify(productDaoInte).findByCodeProduct("P-0000000001");

    }

    @Test
    @Order(3)
    public void updateProductTest() {
        Product object01 = new Product(
                "9",
                "cuenta prueba",
                "cuenta prueba",
                "100-193-0015535759",
                "01-100-193-0015535759",
                "1",
                "PS-0000000001",
                "CT-0000000001",
                "P-0000000001");

        Mono<Product> monoObjectDatabase = productDaoInte.save(object01);

        Mockito.verify(productDaoInte).save(object01);
    }

    @Test
    @Order(4)
    public void deleteProductTest() {

        Mono<Void> monoObjectDatabase = productDaoInte.deleteById("P-0000000001");

        Mockito.verify(productDaoInte).deleteById("P-0000000001");
    }

    @Test
    @Order(5)
    public void readByCodeProductStepVerifierTest() {

        Mono<Product> objectDatabase = productDaoInte.findByCodeProduct("P-0000000001");

        Product object01 = new Product(
                "9",
                "cuenta prueba",
                "cuenta prueba",
                "100-193-0015535759",
                "01-100-193-0015535759",
                "1",
                "PS-0000000001",
                "CT-0000000001",
                "P-0000000001");
        Mono<Product> objectTest = Mono.just(object01);

        StepVerifier.create(productDaoInte.findByCodeProduct("P-0000000001")).recordWith(ArrayList::new)
                .expectNextCount(1)
                .consumeRecordedWith(r -> {
                    Assertions.assertEquals("P-0000000001", "P-0000000001");
                })
                .verifyComplete();;

    }

}
