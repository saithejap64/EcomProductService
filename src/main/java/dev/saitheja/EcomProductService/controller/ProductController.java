package dev.saitheja.EcomProductService.controller;

import dev.saitheja.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.InvalidInputException;
import dev.saitheja.EcomProductService.exception.ProductNotFoundException;
import dev.saitheja.EcomProductService.exception.RandomException;
import dev.saitheja.EcomProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
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
}