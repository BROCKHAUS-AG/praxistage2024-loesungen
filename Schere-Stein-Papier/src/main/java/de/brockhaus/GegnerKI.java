package de.brockhaus;

import java.util.Random;

public class GegnerKI {
    private static final Random random = new Random();

    public SpielLogik.Choice getRandomChoice() {
        int pick = random.nextInt(SpielLogik.Choice.values().length);
        return SpielLogik.Choice.values()[pick];
    }
}