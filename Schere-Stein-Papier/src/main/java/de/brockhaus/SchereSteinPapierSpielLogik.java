package de.brockhaus;

public class SchereSteinPapierSpielLogik {

    public static boolean istGewinnerSpieler(String playerChoice, String robotChoice) {
        // Hier muss bestimmt werden, ob der Spieler das Spiel gewonnen hat.
        // In dem Fall muss "true" zurückgegeben werden, ansonsten "false" (Unentschieden oder Roboter gewinnt).

        switch (playerChoice) {
            case "STEIN":
                return robotChoice.equals("SCHERE");
            case "PAPIER":
                return robotChoice.equals("STEIN");
            case "SCHERE":
                return robotChoice.equals("PAPIER");
        }
        return false;
    }

    public static String bestimmeGewinnerString(String playerChoice, String robotChoice) {
        // Hier muss der String zurückgegeben werden, der auf der GUI angezeigt werden soll.
        // Es gibt drei Fälle: "Du gewinnst!", "Roboter gewinnt!" und "Unentschieden!".
        // Tipp: Nutze bereits geschriebene Methoden.

        if (playerChoice.equals(robotChoice)) {
            return "Unentschieden!";
        } else if (istGewinnerSpieler(playerChoice, robotChoice)) {
            return "Du gewinnst!";
        } else {
            return "Roboter gewinnt!";
        }
    }



    public static String bestimmeErgebnisString(String playerChoice, String robotChoice) {
        // Hier muss das Ergebnis zurückgegeben werden (z.B.: "Spieler: STEIN | Roboter: SCHERE").
        // Welche Wahl hat der Spieler getroffen? Welche Wahl der Roboter?
        // In dem String muss zuerst das Ergebnis des Spielers vorkommen, dann das Ergebnis des Roboters.

        return "Spieler: " + playerChoice + "| Roboter: " + robotChoice;
    }
}