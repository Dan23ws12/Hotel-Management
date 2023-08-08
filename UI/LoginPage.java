package UI;

import javax.swing.JFrame;
import Users.Customer;

public class LoginPage extends GetCustomerPage {
    private TextFieldPanel usernamePanel = new TextFieldPanel("username");
    private TextFieldPanel passwordPanel = new TextFieldPanel("password");

    public LoginPage(JFrame screen) {
        super(screen);
        this.initComponents();
    }

    /*
     * This function initializes or creates all the components that will be used in
     * the frame and adds them to the frame
     */
    @Override
    public void initComponents() {
        super.initComponents();
        usernamePanel.setBounds(0, 80, screen.getWidth(), 40);
        submitButton.setBounds(250, 160, 60, 40);
        this.welcomeMsg.setBounds(210, 40, 150, 40);
        this.passwordPanel.setBounds(0, 120, screen.getWidth(), 40);
        this.screen.add(welcomeMsg);
        this.screen.add(usernamePanel);
        this.screen.add(passwordPanel);
        this.screen.add(submitButton);
    }

    /*
     * Finds the customer with the username and password if it exists, if not then
     * the
     * appropriate error is thrown
     */
    @Override
    public void setCustomer() {
        this.guest = new Customer("ink", "sand", "male", "s1");

    }

}
