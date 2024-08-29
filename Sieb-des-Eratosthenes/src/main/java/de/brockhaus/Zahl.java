package de.brockhaus;

public class Zahl {

    private final int zahl;
    private boolean durchgestrichen;

    public Zahl(int zahl) {
        this.zahl = zahl;
        durchgestrichen = false;
    }

    public int getZahl() {
        return zahl;
    }

    public boolean istDurchgestrichen() {
        return durchgestrichen;
    }

    public void streicheDurch() {
        this.durchgestrichen = true;
    }
}
