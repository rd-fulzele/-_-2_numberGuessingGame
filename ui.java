import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ui {
    public ui() {
        home welcomePage = new home();
        Game game = new Game();

        welcomePage.playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomePage.frame.setVisible(false);
                game.frame.setVisible(true);
            }
        });

        game.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = game.getGuessedNumber();
                if(number != -1) {
                    game.remaining_attempts--;

                    if(game.randomNumber == number) {
                        game.hasWon = true;
                        GameOver gameOver = new GameOver(game);
                        game.frame.setVisible(false);
                        gameOver.frame.setVisible(true);
                    } else {
                        if(number > game.randomNumber) {
                            game.status.setText("Wrong Answer! The number is lower than " + number);
                            game.guessedNumber.setText(" Enter your next guess ");
                        } else {
                            game.status.setText("Wrong Answer! The number is higher than " + number);
                            game.guessedNumber.setText(" Enter your next guess ");
                        }
                    }

                    if(game.remaining_attempts == 0) {
                        GameOver gameOver = new GameOver(game);
                        game.frame.setVisible(false);
                        gameOver.frame.setVisible(true);
                    } else {
                        game.attempts.setText("Remaining Attempts: " + game.remaining_attempts);
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new ui();
    }
}