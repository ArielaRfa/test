package com.Ariela.TestSpringMongoDB.Service;

import com.Ariela.TestSpringMongoDB.Excep.ProduitCollectionException;
import com.Ariela.TestSpringMongoDB.model.Produit;
import jakarta.validation.ConstraintViolationException;

import java.util.List;

public interface ProduitService {
    public void createProduit(Produit produit) throws ConstraintViolationException, ProduitCollectionException;

    public List<Produit> getAllProduit();
    public void updateProduit(String id ,Produit produit) throws ProduitCollectionException;
    public void deleteProduit(String id) throws ProduitCollectionException;
}
