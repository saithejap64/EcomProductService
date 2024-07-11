package dev.saitheja.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@Entity(name = "ECOM_CATEGORY")
public class Category extends BaseModel{
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    List<Product> products;
}

/*
    C   P
    1   M
 */