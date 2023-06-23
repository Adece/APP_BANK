package com.bank;

import java.io.*;

/**
 * Klasa reprezentująca konto bankowe.
 */
public class BankAccount {
    private static final String FILE_PATH = "bank_account.txt";
    private double balance;

    /**
     * Tworzy nowe konto bankowe.
     */
    public BankAccount() {
        balance = readBalanceFromFile();
    }

    /**
     * Zwraca stan konta.
     *
     * @return stan konta
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Wpłaca środki na konto.
     *
     * @param amount kwota do wpłaty
     */
    public void deposit(double amount) {
        balance += amount;
        saveBalanceToFile();
    }

    /**
     * Wypłaca środki z konta.
     *
     * @param amount kwota do wypłaty
     * @return true, jeśli wypłata powiodła się; false w przeciwnym razie
     */
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            saveBalanceToFile();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Przelewa środki na inne konto.
     *
     * @param amount        kwota do przelewu
     * @param recipientName nazwa odbiorcy
     */
    public void transfer(double amount, String recipientName) {
        // logika przesyłania przelewu
        balance -= amount;
        saveBalanceToFile();
        System.out.println("Przelew na kwotę " + amount + " zł został wysłany do odbiorcy: " + recipientName);
    }

    /**
     * Przewalutowuje kwotę z jednej waluty na inną.
     *
     * @param amount       kwota do przewalutowania
     * @param fromCurrency waluta źródłowa
     * @param toCurrency   waluta docelowa
     * @return przewalutowana kwota
     */
    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // logika przewalutowania
        return amount;
    }

    /**
     * Zapisuje stan konta do pliku.
     */
    private void saveBalanceToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku.");
        }
    }

    /**
     * Odczytuje stan konta z pliku.
     *
     * @return stan konta
     */
    private double readBalanceFromFile() {
        double balance = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String balanceStr = reader.readLine();
            balance = Double.parseDouble(balanceStr);
        } catch (IOException e) {
            // Plik nie istnieje, zostanie utworzony przy zapisie.
        }

        return balance;
    }
}
