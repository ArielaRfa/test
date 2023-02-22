package com.Ariela.TestSpringMongoDB.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produits")
public class Produit {
    @Id
    private String id;
    @NotNull(message = "name not null")
    private  String name;
    @NotNull(message = "price not null")
    private int price;
    @NotNull(message = "desc not null")
    private String description;
}
