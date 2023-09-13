import javax.swing.*;
import java.awt.*;

public class RoomsPage extends JPanel {
    private int top = 50;
    RoomsPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Rooms");
        welcomeLabel.setBounds(200, top, 300, 50);
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.PLAIN, 30));


        add(welcomeLabel);
    }
}
