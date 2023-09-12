import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




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
        //com.formdev.flatlaf.themes.FlatMacLightLaf.install();
        com.formdev.flatlaf.themes.FlatMacDarkLaf.install();
        SwingUtilities.invokeLater(() -> {
            landingPage();
        });
    }

    private static void landingPage() {
        JFrame frame = new JFrame("Hotel Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setResizable(false);

        JPanel container = new JPanel(new CardLayout());

        //CreateAccountPage createAccountPage = new CreateAccountPage((CardLayout) container.getLayout(), container);
        LogInPage logInPage = new LogInPage((CardLayout) container.getLayout(), container);
        DashboardPage dashboardPage = new DashboardPage((CardLayout) container.getLayout(), container);

        container.add(logInPage, "logInPage");
        container.add(dashboardPage, "dashboard");
        //container.add(createAccountPage, "createAccountPage");

        frame.add(container);
        frame.setVisible(true);
    }
}
