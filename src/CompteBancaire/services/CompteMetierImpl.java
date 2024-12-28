package CompteBancaire.services;

import CompteBancaire.dto.Operation;
import CompteBancaire.exception.CompteInexistantException;
import CompteBancaire.exception.FondsInsuffisantsException;
import CompteBancaire.exception.MontantSuperieurZeroException;
import CompteBancaire.models.CompteBancaire;
import CompteBancaire.models.CompteCourant;
import CompteBancaire.models.CompteEpargne;

import java.util.ArrayList;

public class CompteMetierImpl implements ICompteMetier {

    private static ArrayList<CompteBancaire> comptes = new ArrayList<>();

    @Override
    public void ajouterCompteCourant(CompteCourant compteCourant) {
        comptes.add(compteCourant);
        System.out.println("Compte courant "+compteCourant.getNumeroCompte()+" ajouté avec succes");
    }

    @Override
    public void ajouterCompteEpargne(CompteEpargne compteEpargne) {
        comptes.add(compteEpargne);
        System.out.println("Compte d'epargne "+compteEpargne.getNumeroCompte()+" ajouté avec succes");
    }

    @Override
    public void listeComptes() {
        comptes.forEach(System.out::println);;
    }

    @Override
    public void depot(Operation operation) throws CompteInexistantException, MontantSuperieurZeroException {
            CompteBancaire compte = rechercherCompte(operation.getNumero());

            if (compte == null) {
                throw new CompteInexistantException("Compte " + operation.getNumero() + " n'existe pas");
            }
            compte.depot(operation.getMontant());
            if (compte instanceof CompteEpargne) {
                ((CompteEpargne) compte).appliquerInterets();
            }
    }

    @Override
    public void retrait(Operation operation) throws CompteInexistantException, FondsInsuffisantsException {

            CompteBancaire compte = rechercherCompte(operation.getNumero());
            if (compte == null) {
                throw new CompteInexistantException("Compte " + operation.getNumero() + " n'existe pas");
            }

            if (compte.getSolde() < operation.getMontant()) {
                throw new FondsInsuffisantsException("Le compte source " + operation.getNumero() + " n'a pas assez de fonds pour le retrait.");
            }

            compte.retrait(operation.getMontant());
    }

    @Override
    public void afficherSolde(String numeroCompte) throws CompteInexistantException {
        CompteBancaire compte = rechercherCompte(numeroCompte);
        if (compte == null) {
            throw new CompteInexistantException("Compte " + numeroCompte + " n'existe pas");
        }
        System.out.println("Solde du compte " + numeroCompte + ": " + compte.getSolde() + "€");
    }

    @Override
    public void transfert(String numeroSource, String numeroDestination, double montant) throws CompteInexistantException, FondsInsuffisantsException, MontantSuperieurZeroException {


            CompteBancaire destination = rechercherCompte(numeroDestination);
            if (destination == null) {
                throw new CompteInexistantException("Compte de destination " + numeroDestination + " n'existe pas");
            }

            CompteBancaire source = rechercherCompte(numeroSource);
            if (source == null) {
                throw new CompteInexistantException("Compte source " + numeroSource + " n'existe pas");
            }


            if (source.getSolde() < montant) {
                throw new FondsInsuffisantsException("Le compte source " + numeroSource + " n'a pas assez de fonds pour le transfert.");
            }

            source.retrait(montant);
            destination.depot(montant);

            System.out.println("Transfert de " + montant + "€, de " + source.getNumeroCompte() +
                    " vers " + destination.getNumeroCompte() + " effectué avec succes");

    }

    @Override
    public void supprimerCompte(String numeroCompte) {
        try {
            CompteBancaire compte = rechercherCompte(numeroCompte);
            comptes.removeIf(cp -> cp.getNumeroCompte().equals(compte.getNumeroCompte()));
            System.out.println("Compte "+compte.getNumeroCompte()+" supprimé");

        }catch (CompteInexistantException e) {
            System.out.println(e.getMessage());
        }

    }

    private static CompteBancaire rechercherCompte(String numero) throws CompteInexistantException{
        return comptes.stream()
                .filter(compte -> compte.getNumeroCompte().equals(numero))
                .findFirst()
                .orElse(null);
    }
}
