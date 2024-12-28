package CompteBancaire.models;

import CompteBancaire.exception.FondsInsuffisantsException;

public class CompteEpargne extends CompteBancaire {

    private double tauxInteret;

    public CompteEpargne(String numero, double soldeInitial, String titulaire, double tauxInteret) {
        super(numero, soldeInitial, titulaire);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            return;
        }
        if (solde < montant) {
            throw new FondsInsuffisantsException("Solde "+solde+" insuffisant pour effectuer le retrait de "+montant);
        }
        solde -= montant;
        System.out.println("Retrait de " + montant + "€ effectué. Nouveau solde : " + solde + "€");
    }

    public void appliquerInterets() {
        double interets = solde * tauxInteret;
        solde += interets;
        System.out.println("Intérêts appliqués : " + interets + "€. Nouveau solde : " + solde + "€");
    }
}
