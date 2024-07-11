package dev.saitheja.EcomProductService.services;

import dev.saitheja.EcomProductService.dto.CreateProductRequestDTO;
import dev.saitheja.EcomProductService.dto.ProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProduct(String productName);
    List<Product> getProducts(double minPrice, double maxPrice);
}
