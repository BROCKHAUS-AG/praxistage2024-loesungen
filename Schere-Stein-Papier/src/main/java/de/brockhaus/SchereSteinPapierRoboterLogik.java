package de.brockhaus;

import java.util.Random;

public class SchereSteinPapierRoboterLogik {

    enum Choice {
        STEIN, PAPIER, SCHERE
    }

    private static final Random random = new Random();

    public String getRandomChoice() {
        int pick = random.nextInt(Choice.values().length);
        return Choice.values()[pick].toString();
    }
}