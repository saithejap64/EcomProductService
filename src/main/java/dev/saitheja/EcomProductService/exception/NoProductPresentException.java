package dev.saitheja.EcomProductService.exception;

public class NoProductPresentException extends RuntimeException{

    public NoProductPresentException(String message) {
        super(message);
    }
}
