package dev.saitheja.EcomProductService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@ToString
@Getter
@Setter
@Entity(name = "ECOM_PRODUCT")
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageURL;
    private double rating;
}
