package dev.saitheja.EcomProductService.controller;

import dev.saitheja.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.InvalidInputException;
import dev.saitheja.EcomProductService.exception.ProductNotFoundException;
import dev.saitheja.EcomProductService.exception.RandomException;
import dev.saitheja.EcomProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService; // field injection

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
        if(id < 1){
            throw new InvalidInputException("Input is not correct");
        }
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/productexception")
    public ResponseEntity getProductException(){
        throw new RandomException("Exception from product");
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product){
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
}