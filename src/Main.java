import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CreateAccountPage extends JPanel {
    CreateAccountPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JLabel createAccountTitle = new JLabel("Create Account");
        createAccountTitle.setBounds(400, 100, 400, 100);
        createAccountTitle.setFont(new Font(createAccountTitle.getFont().getName(), Font.PLAIN, 48));

        JLabel usernameLabelCA = new JLabel("Username:");
        usernameLabelCA.setBounds(440, 150, 200, 100);
        JTextField usernameInputCA = new JTextField();
        usernameInputCA.setBounds(440, 215, 220, 25);

        JLabel passwordLabelCA = new JLabel("Password:");
        passwordLabelCA.setBounds(440, 220, 200, 100);
        JPasswordField passwordInputCA = new JPasswordField();
        passwordInputCA.setBounds(440, 280, 220, 25);

        JButton createAccountButtonCA = new JButton("Create Account");
        createAccountButtonCA.setBounds(440, 320, 220, 30);
        JButton logInButtonCA = new JButton("Log In");
        logInButtonCA.setBounds(440, 355, 220, 30);
        logInButtonCA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });;


        add(createAccountTitle);
        add(usernameLabelCA);
        add(usernameInputCA);
        add(passwordLabelCA);
        add(passwordInputCA);
        add(logInButtonCA);
        add(createAccountButtonCA);
    }
}

class LogInPage extends JPanel {
    LogInPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JButton nextPageButton = new JButton("Next Page");
        nextPageButton.setBounds(500, 400, 100, 30);

        JLabel logInTitle = new JLabel("Log In");
        logInTitle.setBounds(480, 100, 200, 100);
        logInTitle.setFont(new Font(logInTitle.getFont().getName(), Font.PLAIN, 48));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(440, 150, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, 215, 220, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, 220, 200, 100);
        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, 280, 220, 25);

        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, 320, 220, 30);
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, 355, 220, 30);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "createAccountPage");
            }
        });

        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "dashboard");
            }
        });

        add(nextPageButton);
        add(logInTitle);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(logInButton);
        add(createAccountButton);
    }
}

class DashboardPage extends JPanel {
    DashboardPage(CardLayout cardLayout, JPanel container) {
        JButton prevPageButton = new JButton("Previous Page");
        prevPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });
        add(prevPageButton);
        add(new JLabel("Dashboard Here"));
    }
}

public class Main {
    public static void main(String[] args) {
        com.formdev.flatlaf.themes.FlatMacLightLaf.install();
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hotel Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setResizable(false);

        JPanel container = new JPanel(new CardLayout());

        CreateAccountPage createAccountPage = new CreateAccountPage((CardLayout) container.getLayout(), container);
        LogInPage logInPage = new LogInPage((CardLayout) container.getLayout(), container);
        DashboardPage dashboardPage = new DashboardPage((CardLayout) container.getLayout(), container);

        container.add(logInPage, "logInPage");
        container.add(dashboardPage, "dashboard");
        container.add(createAccountPage, "createAccountPage");

        frame.add(container);
        frame.setVisible(true);
    }
}
