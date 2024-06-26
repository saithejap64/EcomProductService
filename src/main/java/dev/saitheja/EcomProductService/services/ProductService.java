package dev.saitheja.EcomProductService.services;

import dev.saitheja.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}
