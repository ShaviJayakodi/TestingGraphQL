package com.example.TestingGraphQL.controller;

import com.example.TestingGraphQL.entity.Product;
import com.example.TestingGraphQL.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @QueryMapping
    public List<Product> getProductByCategory(@Argument String category){
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateStock(@Argument Long id, @Argument int stock){
        return productService.updateProduct(id,stock);
    }

    @MutationMapping
    public Product newShipment (@Argument Long id, @Argument int quantity){
        return productService.newShipment(id,quantity);
    }
}
