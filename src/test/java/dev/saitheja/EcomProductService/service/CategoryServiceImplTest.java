package dev.saitheja.EcomProductService.service;

import dev.saitheja.EcomProductService.entity.Category;
import dev.saitheja.EcomProductService.entity.Product;
import dev.saitheja.EcomProductService.exception.CategoryNotFoundException;
import dev.saitheja.EcomProductService.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {
    //mock for all the dependencies - categoryRepository
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks //InjectMocks for the actual class we are testing
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); //not required these days. It initialises and adds all the required mocks
    }

    @Test
    public void testGetTotalPriceForMultipleProductsUnderCategory(){
        //Arrange
        UUID categoryID = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryID)).thenReturn(categoryOptionalMockData);
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryID);

        //Act
        double expectedTotalCost = 300.0;

        //Assert
        Assertions.assertEquals(actualTotalCost, expectedTotalCost);

    }

    @Test
    public  void testGetTotalPriceForZeroProductsUnderCategory(){
        //Arrange
        UUID categoryID = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockDataWithZeroProducts();
        Mockito.when(categoryRepository.findById(categoryID)).thenReturn(categoryOptionalMockData);
        double actualTestCost = categoryService.getTotalPriceForCategory(categoryID);

        //Act
        double expectedTestCost = 0.0;

        //Assert
        Assertions.assertEquals(actualTestCost, expectedTestCost);
    }

    @Test
    public void testCategoryNotFoundExceptionThrown(){
        //Arrange
        UUID categoryID = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryID)).thenReturn(Optional.empty());

        //Act & Assert
        Assertions.assertThrows(CategoryNotFoundException.class,
                ()->categoryService.getTotalPriceForCategory(categoryID));
    }


    private Optional<Category> getCategoryMockDataWithZeroProducts(){
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        List<Product> products = new ArrayList<>();

        category.setProducts(products);
        return Optional.of(category);
    }

    private Optional<Category> getCategoryMockData(){
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        Product product1= new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(100.0);
        product1.setCategory(category);

        Product product2= new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setPrice(200.0);
        product2.setCategory(category);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        category.setProducts(products);
        return Optional.of(category);
    }

}
