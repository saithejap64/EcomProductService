package dev.saitheja.EcomProductService.exception;

public class ProductNotFoundException extends ProductPresentException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
