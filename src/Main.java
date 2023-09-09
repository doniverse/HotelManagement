import javax.swing.*;
import java.awt.*;



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
        new HomePage();
    }
}