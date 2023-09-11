import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class CreateAccountPage extends JPanel {
    private int top = 150;

    CreateAccountPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JLabel createAccountTitle = new JLabel("Create Account");
        createAccountTitle.setBounds(400, 100, 400, 100);
        createAccountTitle.setFont(new Font(createAccountTitle.getFont().getName(), Font.PLAIN, 48));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(440, top, 200, 100);
        JTextField firstNameInput = new JTextField();
        firstNameInput.setBounds(440, top+60, 220, 25);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(440, top+61, 200, 100);
        JTextField lastNameInput = new JTextField();
        lastNameInput.setBounds(440, top+120, 220, 25);

        JLabel genderLabel = new JLabel("Last Name:");
        genderLabel.setBounds(440, top+61, 200, 100);
        JTextField genderInput = new JTextField();
        genderInput.setBounds(440, top+120, 220, 25);

//        JLabel usernameLabelCA = new JLabel("Username:");
//        usernameLabelCA.setBounds(440, 150, 200, 100);
//        JTextField usernameInputCA = new JTextField();
//        usernameInputCA.setBounds(440, 215, 220, 25);

//        JLabel passwordLabelCA = new JLabel("Password:");
//        passwordLabelCA.setBounds(440, 220, 200, 100);
//        JPasswordField passwordInputCA = new JPasswordField();
//        passwordInputCA.setBounds(440, 280, 220, 25);

        JButton createAccountButtonCA = new JButton("Create Account");
        createAccountButtonCA.setBounds(440, 320, 220, 30);
        createAccountButtonCA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                    String username = firstNameInput.getText();
//                    char[] passwordChars = passwordInputCA.getPassword(); // Get the password as a character array
//                    String password = new String(passwordChars); // Convert the character array to a string
//                    System.out.println(username);
//                    System.out.println("Password: " + password);
                    /*

                    String query = "SELECT * FROM staff WHERE empID = "+empId;
                    try{
                        Connection con = DriverManager.getConnection(url, uname, password);
                        Statement statement = con.createStatement();
                        ResultSet result = statement.executeQuery(query);



                        DefaultTableModel tableModel = new DefaultTableModel();
                        tableModel.addColumn("ID");
                        tableModel.addColumn("First Name");
                        tableModel.addColumn("Last Name");
                        tableModel.addColumn("Gender");
                        tableModel.addColumn("Skills");
                        tableModel.addColumn("Field");
                        tableModel.addColumn("University");
                        tableModel.addColumn("Address");
                        tableModel.addColumn("Rating");
                        table1.setModel(tableModel);


                        while(result.next()){
                            String UniversityData = "";
                            String[] rowData = new String[9];
                            for(int i = 1; i <= 9; i++){
                                UniversityData += result.getString(i)+":";
                                rowData[i-1] = result.getString(i);
                            }
                            tableModel.addRow(rowData);
                            System.out.println(UniversityData);
                        }

                    }catch(SQLException searchError){
                        searchError.printStackTrace();
                    }
                */


            }
        });


        JButton logInButtonCA = new JButton("Log In");
        logInButtonCA.setBounds(440, 355, 220, 30);
        logInButtonCA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });;

        add(createAccountTitle);
        add(firstNameLabel);
        add(firstNameInput);
        add(lastNameLabel);
        add(lastNameInput);
//        add(usernameLabelCA);
//        add(usernameInputCA);
       // add(passwordLabelCA);
        //add(passwordInputCA);
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