package UI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Users.Customer;

public abstract class GetCustomerPage {
    protected SubmitButton submitButton;
    protected JFrame screen;
    protected Customer guest;
    protected JLabel welcomeMsg;

    public GetCustomerPage(JFrame screen) {
        this.screen = screen;
        this.welcomeMsg = new JLabel("Welcome to our hotel!!!");
        this.welcomeMsg.setBorder(BorderFactory.createLineBorder(Color.black, 3, false));

    }

    /*
     * This function initializes or creates all the components that will be used in
     * the frame and adds them to the frame
     */
    public void initComponents() {
        this.submitButton = new SubmitButton(this);

    }

    public Customer getCustomer() {
        return this.guest;
    }

    public abstract void setCustomer();
}
