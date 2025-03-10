package com.example.TestingGraphQL.service.impl;

import com.example.TestingGraphQL.entity.Product;
import com.example.TestingGraphQL.repository.ProductRepository;
import com.example.TestingGraphQL.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return  productRepository.findByCategory(category);
    }

    @Override
    public Product updateProduct(Long id, int stock) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product Not Found with ID : "+id));
        existingProduct.setStock(stock);
        return productRepository.save(existingProduct);
    }

    @Override
    public Product newShipment(Long id, int quantity) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product Not Found with ID : "+id));
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return productRepository.save(existingProduct);
    }

}
