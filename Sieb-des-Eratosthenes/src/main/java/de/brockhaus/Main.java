package de.brockhaus;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        System.out.println("\nSieb des Eratosthenes. Alle Primzahlen bis " + n + ":\n");
        SiebDesEratosthenes siebDesEratosthenes = new SiebDesEratosthenes(n);
        System.out.println(siebDesEratosthenes.berechnePrimzahlen());
    }
}