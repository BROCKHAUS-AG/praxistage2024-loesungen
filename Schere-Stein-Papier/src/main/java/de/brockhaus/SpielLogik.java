package de.brockhaus;

public class SpielLogik {
    public enum Choice {
        ROCK, PAPER, SCISSORS
    }

    public static String bestimmeGewinner(Choice playerChoice, Choice robotChoice) {
        if (playerChoice == robotChoice) {
            return "It's a tie!";
        }
        switch (playerChoice) {
            case ROCK:
                return (robotChoice == Choice.SCISSORS) ? "Player wins!" : "Robot wins!";
            case PAPER:
                return (robotChoice == Choice.ROCK) ? "Player wins!" : "Robot wins!";
            case SCISSORS:
                return (robotChoice == Choice.PAPER) ? "Player wins!" : "Robot wins!";
        }
        return "Error";
    }
}