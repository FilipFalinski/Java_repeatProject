package pong.filip.falinski ;


import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new GameCanvas(), BorderLayout.CENTER);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}