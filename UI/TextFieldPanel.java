package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * TextFieldPanel class
 * ********************************************
 * An object of this class is a panel that only containes a textfield and a label 
 * which is insight into what should be inserted in the textfield.
 * The label is to the left of the textfield
 */
public class TextFieldPanel extends JPanel {
    private JTextField inputField = new JTextField();
    private JLabel label = new JLabel();

    public TextFieldPanel(String lalbelMsg) {
        this.setLayout(new FlowLayout());
        this.label.setText(lalbelMsg);
        inputField.setFont(new Font("Consolas", Font.ITALIC, 20));
        inputField.setPreferredSize(new Dimension(60, 40));
        this.add(label);
        this.add(inputField);
    }

}
