package dev.saitheja.EcomProductService.controller;

import dev.saitheja.EcomProductService.client.FakeStoreClient;
import dev.saitheja.EcomProductService.dto.fakeStoreDTOs.FakeStoreCartResponseDTO;
import dev.saitheja.EcomProductService.exception.CartNotFoundException;
import dev.saitheja.EcomProductService.exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    //this controller is only created for the use case of controller advice, in this code we are not doing anything related to cart
    @Autowired
    FakeStoreClient fakeStoreClient;
    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null){
            throw new CartNotFoundException("Cart not found for userID " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }

    @GetMapping("/cartexception")
    public ResponseEntity getCartException(){
        throw new RandomException("Exception from cart");
    }
}
