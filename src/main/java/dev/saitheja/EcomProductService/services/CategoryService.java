package dev.saitheja.EcomProductService.services;

import dev.saitheja.EcomProductService.dto.CategoryResponseDTO;
import dev.saitheja.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.saitheja.EcomProductService.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID categoryID);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryID);
    boolean deleteCategory(UUID categoryID);
    double getTotalPriceForCategory(UUID categoryId);
}
