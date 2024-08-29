package de.brockhaus;

import java.util.ArrayList;
import java.util.List;

public class SiebDesEratosthenes {

    private final int n;
    private int position = 0;
    private Zahl[] zahlen;
    private List<Integer> primzahlen;

    public SiebDesEratosthenes(int n) {
        // Der Sieb soll direkt beim Erstellen der Instanz ausgeführt werden
        // und die Primzahlen in einer Liste speichern.

        this.n = n;
        erstelleArrayUndListe();
        sieben();
        primesRausschreiben();
    }

    private void hinschreiben(int zahl) {
        zahlen[position] = new Zahl(zahl);
        position++;
    }

    private void durchstreichen(int zahl) {
        zahlen[zahl - 1].streicheDurch();
    }

    private boolean isDurchgestrichen(int zahl) {
        return zahlen[zahl - 1].isDurchgestrichen();
    }

    private void erstelleArrayUndListe() {
        // Hier musst du die Liste, sowie das zahlen Array erzeugen.
        // Das zahlen Array muss aufsteigend mit Zahlen von 1 bis n gefüllt werden.

        primzahlen = new ArrayList<>();
        zahlen = new Zahl[n];
        for (int i = 1; i <= n; i++) {
            hinschreiben(i);
        }
        durchstreichen(1);
    }

    private void sieben() {
        // Hier musst du den eigentlichen Sieb des Eratosthenes Algorithmus implementieren.
        // Du kannst die Methoden durchstreicheVielfache() und isDurchgestrichen() benutzen.

        int a = 2;
        while (a * a <= n) {
            if (!isDurchgestrichen(a)) {
                durchstreicheVielfache(a);
            }
            a++;
        }
    }

    private void primesRausschreiben() {
        // Hier musst du die Primzahlen in die Liste primzahlen schreiben.

        for (int i = 1; i <= n; i++) {
            if (!isDurchgestrichen(i)) {
                primzahlen.add(i);
            }
        }
    }

    private void durchstreicheVielfache(int zahl) {
        // Hier musst du die Vielfachen einer Zahl durchstreichen.
        // Du kannst die Methode durchstreichen() benutzen.

        int x = zahl * 2;
        while (x <= n) {
            durchstreichen(x);
            x += zahl;
        }
    }

    public List<Integer> berechnePrimzahlen() {
        return primzahlen;
    }
}