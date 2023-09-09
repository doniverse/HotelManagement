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
        System.out.println("Hello world!");



        JFrame frame = new JFrame("Multi-Page Screen Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JPanel container = new JPanel(new CardLayout());

        JPanel page1 = new JPanel();
        JButton nextPageButton = new JButton("Next Page");
        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "Page2");
            }
        });
        page1.add(nextPageButton);
        page1.add(new JLabel("Page One here"));

        JPanel page2 = new JPanel();
        JButton prevPageButton = new JButton("Previous Page");
        prevPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) container.getLayout();
                cardLayout.show(container, "Page1");
            }
        });
        page2.add(prevPageButton);
        ;page2.add(new JLabel("Here is page 2"));

        container.add(page1, "Page1");
        container.add(page2, "Page2");

        frame.add(container);
        frame.setVisible(true);
    }
}