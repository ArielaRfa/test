package com.Ariela.TestSpringMongoDB.controller;

import com.Ariela.TestSpringMongoDB.Excep.ProduitCollectionException;
import com.Ariela.TestSpringMongoDB.Service.ProduitService;
import com.Ariela.TestSpringMongoDB.model.Produit;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Ariela.TestSpringMongoDB.repository.ProduitRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public ResponseEntity<?> getAllProduit() {
        List<Produit> produitList = produitService.getAllProduit();
        return new ResponseEntity<>(produitList,produitList.size()>0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/produits")
    public ResponseEntity<?>creation(@RequestBody Produit produit){
        try{
            produitService.createProduit(produit);
            return new ResponseEntity<Produit>(produit,HttpStatus.OK);
        }catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }catch(ProduitCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

@PutMapping("/produits/{id}")
    public ResponseEntity<?>modification(@PathVariable("id") String id,@RequestBody Produit produit){
        try{
            produitService.updateProduit(id,produit);
            return new ResponseEntity<>("upadate reussi de l'id"+id,HttpStatus.OK);
        } catch (ProduitCollectionException e) {
            throw new RuntimeException(e);
        }
}
    @DeleteMapping("/produits/{id}")
    public ResponseEntity<?>suppression(@PathVariable("id") String id){
        try{
           produitService.deleteProduit(id);
            return new ResponseEntity<>("Suppression "+id,HttpStatus.OK);
        }catch (ProduitCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
