package EntierNaturel;

import EntierNaturel.exception.NombreNegatifException;
import EntierNaturel.models.EntierNaturel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Entier Naturel!");

        try {
            System.out.println("Création d'un entier naturel avec valeur 5");
            EntierNaturel en = new EntierNaturel(5);
            System.out.println("Valeur actuelle: " + en.getVal());

            System.out.println("\nModification de la valeur à 10");
            en.setVal(10);
            System.out.println("Nouvelle valeur: " + en.getVal());

            System.out.println("\nDécrémentation");
            en.decrementer();
            System.out.println("Après décrémentation: " + en.getVal());

            System.out.println("\nCréation avec une valeur négative");
            new EntierNaturel(-5);

        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur négative recuperé: " + e.getNombreNegatif());
        }


        try {
            System.out.println("\nDécrémentation jusqu'à zéro");
            EntierNaturel enZero = new EntierNaturel(0);
            System.out.println("Valeur initiale: " + enZero.getVal());
            enZero.decrementer();

        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur négative recuperé: " + e.getNombreNegatif());
        }

    }
}