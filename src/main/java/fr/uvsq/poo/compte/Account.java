package fr.uvsq.poo.compte;

import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;

/**
 * La classe Account représente un compte bancaire simple.
 */
public class Account {
  private BigDecimal balance;

  public Account(BigDecimal initialBalance) {
    validateAmount(initialBalance);
    balance = initialBalance;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void credit(BigDecimal amount) {
    validateAmount(amount);
    balance = balance.add(amount);
  }

  public void debit(BigDecimal amount) {
    validateAmount(amount);
    if (balance.compareTo(amount) < 0) {
      throw new IllegalArgumentException("Montant supérieur au solde");
    }
    balance = balance.subtract(amount);
  }

  public void transfer(BigDecimal amount, Account targetAccount) {
    if (targetAccount == this) {
      throw new IllegalArgumentException("Virement d'un compte sur lui-même");
    }
    debit(amount);
    targetAccount.credit(amount);
  }

  private static void validateAmount(BigDecimal amount) {
    if (amount.compareTo(ZERO) < 0) {
      throw new IllegalArgumentException("Montant invalide");
    }
  }
}
