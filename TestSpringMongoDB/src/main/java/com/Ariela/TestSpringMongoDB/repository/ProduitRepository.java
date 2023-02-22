package com.Ariela.TestSpringMongoDB.repository;

import com.Ariela.TestSpringMongoDB.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends MongoRepository<Produit,String> {
    @Query("{'name': ?0}")
    Optional<Produit> findNameproduit(String name);
}
