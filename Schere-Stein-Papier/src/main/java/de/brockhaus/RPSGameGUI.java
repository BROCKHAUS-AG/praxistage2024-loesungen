package de.brockhaus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPSGameGUI extends JFrame {
    private final GegnerKI gegnerKI = new GegnerKI();
    private final JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel choicesLabel = new JLabel("", SwingConstants.CENTER);
    private static Timer timer;

    public RPSGameGUI() {
        setTitle("Schere Stein Papier");
        setSize(600, 500);
        setMinimumSize(new Dimension(550, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the title label with padding
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Add padding to the top

        JLabel titleLabel = new JLabel("Schere Stein Papier", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        add(titlePanel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcControl = new GridBagConstraints();
        gbcControl.insets = new Insets(30, 10, 30, 10);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Set font to support emojis
        Font emojiFont = new Font("Segoe UI Emoji", Font.PLAIN, 35);

        JButton rockButton = new JButton("🪨");
        rockButton.setFont(emojiFont);
        rockButton.setPreferredSize(new Dimension(130, 130));
        JButton paperButton = new JButton("📄");
        paperButton.setFont(emojiFont);
        paperButton.setPreferredSize(new Dimension(130, 130));
        JButton scissorsButton = new JButton("✂");
        scissorsButton.setFont(emojiFont);
        scissorsButton.setPreferredSize(new Dimension(130, 130));

        rockButton.addActionListener(new ChoiceButtonListener(SpielLogik.Choice.ROCK));
        paperButton.addActionListener(new ChoiceButtonListener(SpielLogik.Choice.PAPER));
        scissorsButton.addActionListener(new ChoiceButtonListener(SpielLogik.Choice.SCISSORS));

        gbc.gridx = 0;
        buttonPanel.add(rockButton, gbc);
        gbc.gridx = 1;
        buttonPanel.add(paperButton, gbc);
        gbc.gridx = 2;
        buttonPanel.add(scissorsButton, gbc);

        gbcControl.gridy = 0;
        controlPanel.add(buttonPanel, gbcControl);
        gbcControl.gridy = 1;
        controlPanel.add(resultLabel, gbcControl);
        gbcControl.gridy = 2;
        controlPanel.add(choicesLabel, gbcControl);


        add(controlPanel, BorderLayout.CENTER);
    }

    private class ChoiceButtonListener implements ActionListener {
        private final SpielLogik.Choice playerChoice;

        public ChoiceButtonListener(SpielLogik.Choice playerChoice) {
            this.playerChoice = playerChoice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SpielLogik.Choice robotChoice = gegnerKI.getRandomChoice();
            String result = SpielLogik.bestimmeGewinner(playerChoice, robotChoice);
            resultLabel.setText(result);
            resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
            Color red = new Color(255, 0, 0, 0);
            Color green = new Color(0, 255, 0, 0);
            resultLabel.setForeground(result.contains("Player") ? green : red);
            choicesLabel.setText("<html><p>Spieler: " + playerChoice + "</p><p>Roboter: " + robotChoice + "</p></html>");
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }

            // Animation effect
            timer = new Timer(50, new ActionListener() {
                private int alpha = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    resultLabel.setForeground(new Color(resultLabel.getForeground().getRed(), resultLabel.getForeground().getGreen(), resultLabel.getForeground().getBlue(), alpha));
                    alpha += 15;
                    if (alpha > 255) {
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.start();
        }
    }

    public static void starte(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RPSGameGUI gameGUI = new RPSGameGUI();
            gameGUI.setVisible(true);
        });
    }
}