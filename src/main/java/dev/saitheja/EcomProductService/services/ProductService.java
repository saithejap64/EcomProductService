package dev.saitheja.EcomProductService.services;

import dev.saitheja.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.NoProductPresentException;
import dev.saitheja.EcomProductService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}
