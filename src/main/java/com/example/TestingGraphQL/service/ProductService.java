package com.example.TestingGraphQL.service;

import com.example.TestingGraphQL.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Product updateProduct(Long id, int stock);

    Product newShipment (Long id, int quantity);
}
