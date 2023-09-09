import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;



class HomePage{
    HomePage(){
        JFrame mainFrame = new JFrame("Hotel Manager");
        mainFrame.setSize(500,500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}


public class Main {


    public static void main(String[] args) {
        com.formdev.flatlaf.themes.FlatMacLightLaf.install();
        JFrame frame = new JFrame("Hotel Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setResizable(false);

        JPanel container = new JPanel(new CardLayout());

        // LogInPage
        JPanel logInPage = new JPanel();
        logInPage.setLayout(null);

        JButton nextPageButton = new JButton("Next Page");
        nextPageButton.setBounds(500, 400, 100, 30);

        JLabel logInTitle = new JLabel("Log In");
        logInTitle.setBounds(480, 100, 200, 100);
        logInTitle.setFont(new Font(logInTitle.getFont().getName(), Font.PLAIN, 48));

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(440, 150, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, 215, 220,25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, 220, 200, 100);
        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, 280, 220,25);


        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, 320, 220, 30);
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, 355, 220,30);

        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "dashboard");
            }
        });

        logInPage.add(nextPageButton);
        logInPage.add(logInTitle);
        logInPage.add(usernameLabel);
        logInPage.add(usernameInput);
        logInPage.add(passwordLabel);
        logInPage.add(passwordInput);
        logInPage.add(logInButton);
        logInPage.add(createAccountButton);
        logInPage.add(new JLabel("Log In page"));



        JPanel dashboard = new JPanel();
        JButton prevPageButton = new JButton("Previous Page");
        prevPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "logInPage");
            }
        });
        dashboard.add(prevPageButton);
        dashboard.add(new JLabel("Dashboard Here"));

        container.add(logInPage, "logInPage");
        container.add(dashboard, "dashboard");

        frame.add(container);
        frame.setVisible(true);
    }
}