package com.Ariela.TestSpringMongoDB.Excep;

public class ProduitCollectionException extends Exception {
    private static final long serialVersionUID = 1L;

    public ProduitCollectionException(String message) {
        super(message);
    }

    public static String NotFoundExist(String id) {
        return "produit avec id:" + id + "n'est pas trouve";
    }

    public static String ProduitExist() {
        return "ce nom existe deja";
    }
}
