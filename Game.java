import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

public class Game {

    JFrame frame;
    JTextField guessedNumber;
    JButton submitButton;
    JLabel status, attempts;
    int remaining_attempts = 5;
    int randomNumber = this.generateRandomNumber();
    int numberOfRounds = 1;
    boolean hasWon = false;
    int score = 0;

    public Game() {
        frame = new JFrame();

        JLabel title = new JLabel("The Number Guessing Game");
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        JPanel jPanel = new JPanel();
        guessedNumber = new JTextField(" Enter your guess ");
        guessedNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                guessedNumber.setText(" ");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        submitButton = new JButton("Guess");
        jPanel.add(guessedNumber);
        jPanel.add(submitButton);
        frame.add(jPanel);

        status = new JLabel("Status ");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setVerticalAlignment(JLabel.TOP);
        frame.add(status);


        JPanel gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));
        attempts = new JLabel("Attempts remaining: " + this.remaining_attempts);
        attempts.setHorizontalAlignment(JLabel.CENTER);
        gameInfo.add(attempts);
        frame.add(gameInfo);

        frame.setTitle("The Number Guessing game");
        frame.setResizable(true);
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(4, 1));
        frame.setVisible(false);
    }

    public int getGuessedNumber() {
        try {
            System.out.println(this.guessedNumber.getText());
            return Integer.parseInt(this.guessedNumber.getText().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int num = random.nextInt(1, 101);
        System.out.println("Random number : " + num);
        return num;
    }

    public int calculateScore() {
        return this.remaining_attempts * 25;
    }

    public void newRound() {
        this.frame.setVisible(true);
        this.numberOfRounds++;
        this.randomNumber = generateRandomNumber();
        this.remaining_attempts = 5;
        this.hasWon = false;
        this.attempts.setText("Attempts remaining: " + this.remaining_attempts);
        this.guessedNumber.setText("Enter your guess ");
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(1, 101));
    }
}