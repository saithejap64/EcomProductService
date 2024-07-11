package dev.saitheja.EcomProductService.controller;

import dev.saitheja.EcomProductService.dto.CreateProductRequestDTO;
import dev.saitheja.EcomProductService.dto.ProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.InvalidInputException;
import dev.saitheja.EcomProductService.exception.ProductNotFoundException;
import dev.saitheja.EcomProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product") // base URL for all the APIs in this controller
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService; // field injection

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id){
        if(id == null){
            throw new InvalidInputException("Input is not correct");
        }
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO){
        System.out.println(" Input ");
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id)
        );
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByProductName(@PathVariable("productName") String productName){
        return ResponseEntity.ok(
                productService.getProduct(productName)
        );
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductByPriceRange(@PathVariable("min") double minPrice, @PathVariable("max") double maxPrice){
        return ResponseEntity.ok(
                productService.getProducts(minPrice, maxPrice)
        );
    }


    //used for demo of controller advice
    /*
    @GetMapping("/productexception")
    public ResponseEntity getProductException(){
        throw new RandomException("Exception from product");
    }
     */
}