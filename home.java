import javax.swing.*;
import java.awt.*;

public class home {

    JFrame frame;
    JButton playButton;

    public home() {
        frame = new JFrame();

        JLabel title = new JLabel("The Number Guessing Game");
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        JPanel jPanel = new JPanel();
        frame.add(jPanel);

        playButton = new JButton("Start");
        playButton.setHorizontalAlignment(JButton.CENTER);
        playButton.setSize(600, 450);
        jPanel.add(playButton);

        frame.setTitle("The Number Guessing Game");
        frame.setResizable(false);
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
    }

}