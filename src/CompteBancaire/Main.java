package CompteBancaire;
import CompteBancaire.dto.Operation;
import CompteBancaire.exception.CompteInexistantException;
import CompteBancaire.exception.FondsInsuffisantsException;
import CompteBancaire.exception.MontantSuperieurZeroException;
import CompteBancaire.models.CompteCourant;
import CompteBancaire.models.CompteEpargne;
import CompteBancaire.services.CompteMetierImpl;

import java.util.Scanner;

public class Main {

    static CompteMetierImpl  compteMetier = new CompteMetierImpl();

    static void printMenu() {
        System.out.println("1. Ajouter un compte courant");
        System.out.println("2. Ajouter un compte d'epargne");
        System.out.println("3. Dépôt d'argent sur un compte.");
        System.out.println("4. Afficher la liste des comptes.");
        System.out.println("5. Retrait d'argent sur un compte");
        System.out.println("6. Affichage du solde du compte.");
        System.out.println("7. Transfert d'argent entre deux comptes.");
        System.out.println("8. Supprimer un compte.");
        System.out.println("9. Quitter");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("###############################################################");
        System.out.println("##### Java POO Basic Exception Handling: Banking manager ######");
        System.out.println("###############################################################");

        while (true) {
            printMenu();
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Ajouter un compte courant ===");
                    CompteCourant compteCourant = saisirCompteCourant();
                    compteMetier.ajouterCompteCourant(compteCourant);
                   break;
                case 2:
                    System.out.println("\n=== Ajouter un compte d'epargne ===");
                    CompteEpargne compteEpargne = saisirCompteEpargne();
                    compteMetier.ajouterCompteEpargne(compteEpargne);
                    break;
                case 3:
                    System.out.println("\n=== Opération de dépot ===");
                    Operation depot = saisirUneOperation();
                    try {
                        compteMetier.depot(depot);
                    } catch (MontantSuperieurZeroException | CompteInexistantException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\n=== Liste des comptes ===");
                    compteMetier.listeComptes();
                    break;
                case 5:
                    System.out.println("\n=== Opération de retrait ===");
                    Operation retrait = saisirUneOperation();
                    try {
                        compteMetier.retrait(retrait);
                    } catch (CompteInexistantException | FondsInsuffisantsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\n=== Afficher Solde d'un compte ===");
                    System.out.print("Numero du compte: ");
                    String numeroCompte = scanner.nextLine();
                    try {
                        compteMetier.afficherSolde(numeroCompte);
                    } catch (CompteInexistantException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("\n=== Opération de Transfert ===");
                    System.out.print("Numero compte source: ");
                    String numeroSource = scanner.nextLine();

                    System.out.print("Numero compte destination: ");
                    String numeroDestination = scanner.nextLine();

                    System.out.print("Montant a transférer: ");
                    double montant = scanner.nextDouble();

                    try {
                        compteMetier.transfert(numeroSource, numeroDestination, montant);
                    } catch (MontantSuperieurZeroException | CompteInexistantException | FondsInsuffisantsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("\n=== Suppression d'un compte ===");
                    System.out.print("Numero du compte source: ");
                    String numero = scanner.nextLine();
                    compteMetier.supprimerCompte(numero);
                    break;
                case 9:
                    System.out.println("Bye !");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

    }

    private static CompteCourant saisirCompteCourant() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero du compte: ");
        String numeroCompte = scanner.nextLine();

        System.out.print("Nom du compte(Titulaire): ");
        String nomTitulaire = scanner.nextLine();

        System.out.print("Solde initial: ");
        double soldeInitial = scanner.nextDouble();

        System.out.print("Découvert autorisé: ");
        double decouvertAutorise = scanner.nextDouble();

        return new CompteCourant(numeroCompte, soldeInitial, nomTitulaire, decouvertAutorise);
    }

    private static CompteEpargne saisirCompteEpargne() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero du compte: ");
        String numeroCompte = scanner.nextLine();

        System.out.print("Nom du compte(Titulaire): ");
        String nomTitulaire = scanner.nextLine();

        System.out.print("Solde initial: ");
        double soldeInitial = scanner.nextDouble();

        System.out.print("Taux d'interet: ");
        double tauxInteret = scanner.nextDouble();

        return new CompteEpargne(numeroCompte, soldeInitial, nomTitulaire, tauxInteret);
    }

    private static Operation saisirUneOperation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero du compte: ");
        String numeroCompte = scanner.nextLine();

        System.out.print("Montant a déposer: ");
        double montant = scanner.nextDouble();

        Operation operation = new Operation();
        operation.setNumero(numeroCompte);
        operation.setMontant(montant);

        return operation;
    }


}
