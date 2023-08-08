import java.awt.Color;

import javax.swing.JFrame;

import UI.LoginPage;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("login page");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(160, 160, 160));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 600);
        LoginPage page = new LoginPage(frame);
        frame.setVisible(true);

    }

}
