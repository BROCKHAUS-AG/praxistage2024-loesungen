package de.brockhausag;

import java.util.Arrays;

public class TicTacToeGame implements TicTacToeLogic{
    private final FieldState[] fieldStates = new FieldState[9];
    private FieldState lastPlayer = FieldState.O;

    public TicTacToeGame() {
        Arrays.fill(fieldStates, FieldState.NONE);
    }

    public void makeMove(int index) {
        if (fieldStates[index] != FieldState.NONE) {
            throw new IllegalArgumentException("Feld ist bereits belegt!");
        }
        if(lastPlayer.equals(FieldState.O)) {
            fieldStates[index] = FieldState.X;
            lastPlayer = FieldState.X;
        }else if(lastPlayer.equals(FieldState.X)) {
            fieldStates[index] = FieldState.O;
            lastPlayer = FieldState.O;
        }
    }

    public FieldState getWinner() {
        FieldState winner;

        // Check rows
        for (int i = 0; i < 9; i += 3) {
            winner = checkThreeStates(fieldStates[i], fieldStates[i + 1], fieldStates[i + 2]);
            if (winner != null) {
                return winner;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            winner = checkThreeStates(fieldStates[i], fieldStates[i + 3], fieldStates[i + 6]);
            if (winner != null) {
                return winner;
            }
        }

        // Check diagonals
        winner = checkThreeStates(fieldStates[0], fieldStates[4], fieldStates[8]);
        if (winner != null) {
            return winner;
        }

        winner = checkThreeStates(fieldStates[2], fieldStates[4], fieldStates[6]);
        if (winner != null) {
            return winner;
        }

        // Check for tie
        for (FieldState state : fieldStates) {
            if (state == FieldState.NONE) {
                return null; // Game is not over
            }
        }
        return FieldState.NONE; // Tie
    }

    private FieldState checkThreeStates(FieldState state1, FieldState state2, FieldState state3) {
        if (areThreeStatesEqual(state1, state2, state3)) {
            return state1 == FieldState.X ? FieldState.X : FieldState.O;
        }
        return null;
    }

    public void resetGame() {
        Arrays.fill(fieldStates, FieldState.NONE);
        lastPlayer = FieldState.O;
    }

    public FieldState[] getFieldStates() {
        return fieldStates;
    }

    public FieldState getLastPlayer() {
        return lastPlayer;
    }

    private boolean areThreeStatesEqual(FieldState state1, FieldState state2, FieldState state3) {
        return state1 != FieldState.NONE && state1 == state2 && state1 == state3;
    }
}