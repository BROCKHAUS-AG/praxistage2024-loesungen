package de.brockhausag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI implements ActionListener {
    private final JFrame frame = new JFrame("Tic Tac Toe");
    private final JPanel panel = new JPanel(new GridLayout(3, 3));
    private final JButton[] buttons = new JButton[9];
    private final TicTacToeGame game = new TicTacToeGame();

    public TicTacToeGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.PLAIN, 40));
            button.addActionListener(this);
            panel.add(button);
            buttons[i] = button;
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int index = getButtonIndex(button);

        if (index != -1) {
            try {
                game.makeMove(index);
                updateButtonText(button, game.getLastPlayer());
                button.setEnabled(false);

                FieldState winner = game.getWinner();
                if (winner != null) {
                    if (winner == FieldState.NONE) {
                        JOptionPane.showMessageDialog(frame, "Unentschieden!");
                    } else {
                        JOptionPane.showMessageDialog(frame, winner + " hat gewonnen!");
                    }
                    resetGame();
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        }
    }

    private int getButtonIndex(JButton button) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == button) {
                return i;
            }
        }
        return -1;
    }

    private void updateButtonText(JButton button, FieldState player) {
        button.setText(player == FieldState.X ? "X" : "O");
    }

    private void resetGame() {
        game.resetGame();
        for (JButton button : buttons) {
            button.setEnabled(true);
            button.setText("");
        }
    }
}