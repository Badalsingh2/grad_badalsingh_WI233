package com.example.Scheduling.Assignment;

import com.example.Scheduling.Assignment.controllers.ProductController;
import com.example.Scheduling.Assignment.entities.Product;
import com.example.Scheduling.Assignment.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService ps;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnProduct_WhenFound() throws Exception {

        Product product = new Product(1, "Laptop", 50000);

        when(ps.getProduct(1)).thenReturn(Optional.of(product));

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));

        verify(ps, times(1)).getProduct(1);
    }

    @Test
    void shouldReturn404_WhenNotFound() throws Exception {

        when(ps.getProduct(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isNotFound());

        verify(ps, times(1)).getProduct(1);
    }

    @Test
    void shouldCreateProduct() throws Exception {

        Product product = new Product(1, "Mobile", 20000);

        when(ps.addProduct(any(Product.class))).thenReturn("Saved");

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated());

        verify(ps, times(1)).addProduct(any(Product.class));
    }
}