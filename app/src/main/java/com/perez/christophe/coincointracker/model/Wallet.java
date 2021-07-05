package com.perez.christophe.coincointracker.model;

/**
 * Created by Christophe on 25/06/2021.
 */
public class Wallet {


    private double mMontantCourant;
    private static final double MAXI_CAPACITY = 30.0; // c'est une constante


    public Wallet(double initialMontantCourant) {
        mMontantCourant = initialMontantCourant;
    }


    /*public double getBalance() {
        return mMontantCourant;
    }
    */
    public double getMontantCourant() {
        return mMontantCourant;
    }


    /*
    A la methode depot ,
    il a été ajouté  throws Exception suite au if qui renvoie à une Exception
    si le total mMontantCourant + montant déposé dépasse la capacité maxi
    et pour le test unitaire , cela crée une erreur qui affichera "il y a trop d'argent"
     */
    public void depot(double montant) throws Exception {

        if ((mMontantCourant + montant) > MAXI_CAPACITY) {
            throw new Exception("il y a trop d'argent ! ");
        }

        mMontantCourant = mMontantCourant + montant;
    }

    public void retrait(double montant) {
        mMontantCourant = mMontantCourant - montant;
    }


    public void etreADecouvert(double montant) {

        if (montant > mMontantCourant) {
            System.out.println("Il n'y a pas assez d'argent");
        }

        mMontantCourant = mMontantCourant - montant;
    }

}
