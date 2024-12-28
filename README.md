# Programmation Orientée Objet Java - Base de la Gestion des exceptions

![applications structure.png](images/applications%20structure.png)

# Exemple 2: Gestion des Comptes Bancaire

## Exceptions:

- FondsInsuffisantsException
- CompteInexistantException.
- MontantSuperieurZeroException

## Application: `src/CompteBancaire` (Package)

   ![0 Banking manager.png](images/0%20Banking%20manager.png)

### Ajouter des comptes

#### 1. Ajouter un compte courant

![1-Ajouter un compte courant.png](images/1-Ajouter%20un%20compte%20courant.png)

#### 2. Ajouter un compte d'epargne

![2 Ajouter un compte epargne.png](images/2%20Ajouter%20un%20compte%20epargne.png)

#### 3. Dépôt d'argent sur un compte:
   - `cas passant`
    
   ![3- cas passant.png](images/3-%20cas%20passant.png)
    
  - `Cas fonds du compote source insuffisant`

    ![3- fonds insuffisant.png](images/3-%20fonds%20insuffisant.png)

  - `cas du compte qui n'existe pas`

    ![3 compte existe pas.png](images/3%20compte%20existe%20pas.png)

  - `cas d'un montant négatif ou 0`

    ![3 cas un montant negatif ou 0.png](images/3%20cas%20un%20montant%20negatif%20ou%200.png)

#### 4. Afficher la liste des comptes

![4 Afficher la liste des comptes.png](images/4%20Afficher%20la%20liste%20des%20comptes.png)

#### 5. Retrait d'argent sur un compte
   
   - `cas passant`

   ![5 cas passant.png](images/5%20cas%20passant.png)

  - `cas du compte qui n'existe pas`

    ![5 cas du compte qui n'existe pas.png](images/5%20cas%20du%20compte%20qui%20n'existe%20pas.png)

#### 6. Affichage du solde du compte

![6 Affichage du solde du compte.png](images/6%20Affichage%20du%20solde%20du%20compte.png)

#### 7. Transfert d'argent entre deux comptes.
   - `cas passant`

   ![7 cas passant.png](images/7%20cas%20passant.png)

  - `Cas fonds du compote source insuffisant`

    ![8 fonds insuffisant.png](images/8%20fonds%20insuffisant.png)

  - `cas du compte source qui n'existe pas`

    ![7 cas du compte source qui n'existe pas.png](images/7%20cas%20du%20compte%20source%20qui%20n'existe%20pas.png)

  - `cas du compte destination qui n'existe pas`

    ![7 cas du compte destination qui n'existe pas.png](images/7%20cas%20du%20compte%20destination%20qui%20n'existe%20pas.png)

  - `cas d'un montant négatif ou 0`

    ![7 cas un montant negatif ou 0.png](images/7%20cas%20un%20montant%20negatif%20ou%200.png)

#### 8. Supprimer un compte.
   - `Suppression`

   ![8 Supprimer un compte.png](images/8%20Supprimer%20un%20compte.png)

   - `Verification`

   ![8 Verification.png](images/8%20Verification.png)

#### 9. Quitter

![9 Quitter.png](images/9%20Quitter.png)

#### 10. Option non existant

    ![10 Invalid option.png](images/10%20Invalid%20option.png)

# Exemple 1: Entier Naturel

## Gestion des exceptions
## Exceptions:

- NombreNegatifException

## Application: `src/EntierNaturel` (Package)
![EntierNaturel.png](images/EntierNaturel.png)