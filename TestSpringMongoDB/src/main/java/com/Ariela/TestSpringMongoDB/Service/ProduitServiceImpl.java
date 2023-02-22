package com.Ariela.TestSpringMongoDB.Service;

import com.Ariela.TestSpringMongoDB.Excep.ProduitCollectionException;
import com.Ariela.TestSpringMongoDB.model.Produit;
import com.Ariela.TestSpringMongoDB.repository.ProduitRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public void createProduit(Produit produit) throws ConstraintViolationException, ProduitCollectionException {
        Optional<Produit> produitOptional=produitRepository.findNameproduit(produit.getName());
        if(produitOptional.isPresent()){
            throw new ProduitCollectionException(ProduitCollectionException.ProduitExist());
        }
        else{
            produitRepository.save(produit);
        }
    }

    @Override
    public List<Produit> getAllProduit() {
        List<Produit>produits=produitRepository.findAll();
        if(produits.size()>0){
            return produits;
        }
        else{
            return new ArrayList<Produit>();
        }
    }

    @Override
    public void updateProduit(String id, Produit produit) throws ProduitCollectionException {
        Optional<Produit> produitID=produitRepository.findById(id);
        if(produitID.isPresent()){
            Produit produitUpdate=produitID.get();

            produitUpdate.setName(produit.getName());
            produitUpdate.setDescription(produit.getDescription());
            produitUpdate.setPrice(produit.getPrice());
            produitRepository.save(produitUpdate);
        }
        else{
            throw new ProduitCollectionException(ProduitCollectionException.NotFoundExist(id));
        }
    }

    @Override
    public void deleteProduit(String id) throws ProduitCollectionException {
        Optional<Produit>produitOptional=produitRepository.findById(id);
        if(!produitOptional.isPresent()){
            throw new ProduitCollectionException(ProduitCollectionException.NotFoundExist(id));
        }
        else{
            produitRepository.deleteById(id);
        }
    }
}
