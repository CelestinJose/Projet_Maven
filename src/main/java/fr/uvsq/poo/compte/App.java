package fr.uvsq.poo.compte;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Mini Application Bancaire ===");

    System.out.print("Solde initial du compte A : ");
    Account compteA = new Account(scanner.nextBigDecimal());

    System.out.print("Solde initial du compte B : ");
    Account compteB = new Account(scanner.nextBigDecimal());

    int choix;
    do {
      System.out.println("\n----- Menu -----");
      System.out.println("1. Voir soldes");
      System.out.println("2. Créditer compte A");
      System.out.println("3. Débiter compte A");
      System.out.println("4. Transférer de A vers B");
      System.out.println("5. Quitter");
      System.out.print("Votre choix : ");
      choix = scanner.nextInt();

      try {
        switch (choix) {
          case 1:
            System.out.println("Solde compte A : " + compteA.getBalance() + " €");
            System.out.println("Solde compte B : " + compteB.getBalance() + " €");
            break;
          case 2:
            System.out.print("Montant à créditer sur A : ");
            compteA.credit(scanner.nextBigDecimal());
            System.out.println("Crédit effectué !");
            break;
          case 3:
            System.out.print("Montant à débiter sur A : ");
            compteA.debit(scanner.nextBigDecimal());
            System.out.println("Débit effectué !");
            break;
          case 4:
            System.out.print("Montant à transférer de A vers B : ");
            compteA.transfer(scanner.nextBigDecimal(), compteB);
            System.out.println("Transfert réussi !");
            break;
          case 5:
            System.out.println("Fermeture de l’application...");
            break;
          default:
            System.out.println("Choix invalide !");
        }
      } catch (IllegalArgumentException e) {
        System.out.println("Erreur : " + e.getMessage());
      }

    } while (choix != 5);

    scanner.close();
  }
}
