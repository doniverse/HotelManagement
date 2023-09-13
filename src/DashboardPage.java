import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DashboardPage extends JPanel {
    private int top = 150;
    public boolean setRegisterButton = true;

    DashboardPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);
//        JButton prevPageButton = new JButton("Previous Page");
//        prevPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(container, "logInPage");
//            }
//        });
//        add(prevPageButton);
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setBounds(440, top, 300, 50);
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.PLAIN, 48));
        JLabel menuLabel = new JLabel("Choose your action: ");
        menuLabel.setBounds(440, top+50, 300, 50);

        JButton registerUserBtn = new JButton("Register User");
        registerUserBtn.setBounds(440, top+100, 220, 30);
        registerUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "registerPage");
            }
        });
        JButton roomsBtn = new JButton("Rooms");
        roomsBtn.setBounds(440, top+150, 220, 30);
        roomsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "roomsPage");
            }
        });
        JButton servicesBtn = new JButton("Services");
        servicesBtn.setBounds(440, top+200, 220, 30);


        add(welcomeLabel);
        add(menuLabel);
        add(registerUserBtn);
        add(roomsBtn);
        add(servicesBtn);
    }
}
