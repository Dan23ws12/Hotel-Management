package MVC;

import javax.swing.*;

interface Observer {
    public void update();
}

public class HotelView implements Observer {

    private Hotel hotel;
    private JFrame screen;
    private JPanel errorPanel;

    @Override
    public void update() {
        hotel.getFeatureState();

    }

    protected void displayException(Exception e) {
        JLabel errorLabel = new JLabel();
        errorLabel.setText(e.toString());
        screen.add(errorLabel);
    }
}
