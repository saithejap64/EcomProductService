package dev.saitheja.EcomProductService.service;

import dev.saitheja.EcomProductService.dto.CategoryResponseDTO;
import dev.saitheja.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.saitheja.EcomProductService.entity.Category;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.CategoryNotFoundException;
import dev.saitheja.EcomProductService.mapper.CategoryEntityDTOMapper;
import dev.saitheja.EcomProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

//    @Autowired
//    FakeStoreClient fakeStoreClient;

    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) {
        Category category =  categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOs = new ArrayList<>();
        for(Category c : categories){
            categoryResponseDTOs.add(CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(c));
        }
        return categoryResponseDTOs;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        Category category = CategoryEntityDTOMapper.convertCreateCategoryDTOToCategory(categoryRequestDTO);
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(
                ()->new CategoryNotFoundException("Category not found for id: "+categoryId)
        );
        savedCategory.setName(categoryRequestDTO.getCategoryName());
        savedCategory=categoryRepository.save(savedCategory);
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(savedCategory);
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }

    @Override
    public double getTotalPriceForCategory(UUID categoryId) {
//        List<FakeStoreProductResponseDTO> productResponseDTOS = fakeStoreClient.getAllProducts();
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category for the given id is not found")
        );
        if(category.getProducts().isEmpty()){
            return 0;
        } else{
            double sum = 0;
            for(Product p : category.getProducts()){
                sum = sum + p.getPrice();
            }
            return sum;
        }
    }
}
