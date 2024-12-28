package CompteBancaire.models;

import CompteBancaire.exception.FondsInsuffisantsException;
import CompteBancaire.exception.MontantSuperieurZeroException;

public abstract class CompteBancaire {

    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(String numeroCompte, double soldeInitial, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.nomTitulaire = nomTitulaire;
    }

    public void depot(double montant) throws MontantSuperieurZeroException {
        if (montant <= 0) {
            throw new MontantSuperieurZeroException("Le montant doit etre positif");
        }
        solde += montant;
        System.out.println("Dépôt de " + montant + "€ effectué. Nouveau solde : " + solde + "€");
    }

    public abstract void retrait(double montant) throws FondsInsuffisantsException;


    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    @Override
    public String toString() {
        return "Compte: " + numeroCompte + " - Titulaire: " + nomTitulaire + " - Solde: " + solde + "€";
    }
}
