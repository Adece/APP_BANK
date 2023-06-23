package com.bank.test;

import com.bank.BankAccount;
import com.bank.currency.CurrencyConverter;

import java.util.Scanner;

/**
 * Klasa testująca funkcjonalność konta bankowego.
 */
public class BankAccountAppTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w aplikacji bankowej!");

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Stan konta: " + bankAccount.getBalance());
            System.out.println("Wybierz operację:");
            System.out.println("1. Wpłata");
            System.out.println("2. Wypłata");
            System.out.println("3. Przelew");
            System.out.println("4. Wyjście");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Podaj kwotę do wpłaty:");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Wpłacono " + depositAmount + " zł");
                    break;
                case 2:
                    System.out.println("Podaj kwotę do wypłaty:");
                    double withdrawAmount = scanner.nextDouble();
                    boolean success = bankAccount.withdraw(withdrawAmount);
                    if (success) {
                        System.out.println("Wypłacono " + withdrawAmount + " zł");
                    } else {
                        System.out.println("Brak wystarczających środków na koncie.");
                    }
                    break;
                case 3:
                    System.out.println("Podaj kwotę do przelewu:");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Pobierz znak nowej linii po wczytaniu liczby
                    System.out.println("Podaj nazwę odbiorcy:");
                    String recipientName = scanner.nextLine();
                    bankAccount.transfer(transferAmount, recipientName);
                    break;
                case 4:
                    System.out.println("Dziękujemy za skorzystanie z aplikacji bankowej. Do widzenia!");
                    System.exit(0);
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}
