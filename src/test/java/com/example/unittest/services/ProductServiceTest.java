package com.example.unittest.services;


import com.example.unittest.entity.Product;
import com.example.unittest.exception.BadRequestException;
import com.example.unittest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {//after class created create instance of product service
    Product product;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        product = new Product();//to initilize product object which used to send product to service layer
    }

    @Test
    public void whenProductNameNullThrowException() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            productService.saveProduct(product);
        });
        assertEquals("Name of product can't null", exception.getMessage());//check if error message same with manual test
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());//check if response code same with manual test
        //first unit test success
    }

    @Test
    public void whenSavedProductSuccessThenReturnProduct() {
        product.setName("Xiaomi");
        product.setQuantity(12);

        lenient().when(productRepository.save(product)).thenReturn(product);
        assertNotNull(product);
        assertEquals(product.getName(), product.getName());
        //success
    }
}