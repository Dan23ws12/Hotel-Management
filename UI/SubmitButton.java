package UI;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitButton extends JButton implements ActionListener {
    private GetCustomerPage panel;

    public SubmitButton(GetCustomerPage panel) {
        this.panel = panel;
        this.addActionListener(this);
    }

    /*
     * Makes sure that when the button is clicked and all the info is given
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.panel.setCustomer();
    }

}
