package CompteBancaire.services;

import CompteBancaire.dto.Operation;
import CompteBancaire.exception.CompteInexistantException;
import CompteBancaire.exception.FondsInsuffisantsException;
import CompteBancaire.exception.MontantSuperieurZeroException;
import CompteBancaire.models.CompteCourant;
import CompteBancaire.models.CompteEpargne;

public interface ICompteMetier {

    void ajouterCompteCourant(CompteCourant compteCourant);
    void ajouterCompteEpargne(CompteEpargne compteEpargne);
    void listeComptes();
    void depot(Operation operation) throws CompteInexistantException, MontantSuperieurZeroException;
    void retrait(Operation operation) throws CompteInexistantException, FondsInsuffisantsException;
    void afficherSolde(String numeroCompte) throws CompteInexistantException;
    void transfert(String source, String numeroDestination, double montant)  throws FondsInsuffisantsException, CompteInexistantException, MontantSuperieurZeroException;
    void supprimerCompte(String numeroCompte) throws CompteInexistantException;
}
