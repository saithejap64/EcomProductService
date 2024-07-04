package dev.saitheja.EcomProductService.services;

import dev.saitheja.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.ProductNotFoundException;
import dev.saitheja.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct= productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
