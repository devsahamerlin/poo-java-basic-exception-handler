package CompteBancaire.models;

import CompteBancaire.exception.FondsInsuffisantsException;

public class CompteCourant extends CompteBancaire {

    private double decouvertAutorise;

    public CompteCourant(String numero, double soldeInitial, String nomTitulaire, double decouvertAutorise) {
        super(numero, soldeInitial, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            return;
        }
        if (solde - montant < -decouvertAutorise) {
            throw new FondsInsuffisantsException("Dépassement du découvert autorisé (" + decouvertAutorise + "€)");
        }
        solde -= montant;
        System.out.println("Retrait de " + montant + "€ effectué. Nouveau solde : " + solde + "€");
    }
}
