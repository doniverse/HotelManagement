import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;





class RegisterUserPage extends  JPanel{
    private int top = 150;

    RegisterUserPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        JLabel createAccountTitle = new JLabel("Register User");
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

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(440, top+110, 200, 100);
        JTextField ageInput = new JTextField();
        ageInput.setBounds(440, top+170, 220, 25);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(440, top+160, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, top+220, 220, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, top+210, 200, 100);
        JTextField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, top+270, 220, 25);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(440, top+260, 200, 100);
        // Create a ButtonGroup to group the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        // Create radio buttons for Male and Female
        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(440, top + 315, 100, 30);
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(550, top + 315, 100, 30);
        // Add radio buttons to the ButtonGroup
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);


        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, top+355, 220, 30);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("🎊 registering user");
            }
        });

        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, top+390, 220, 30);
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });

        add(createAccountTitle);
        add(firstNameLabel);
        add(firstNameInput);
        add(lastNameLabel);
        add(lastNameInput);
        add(ageLabel);
        add(ageInput);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(logInButton);
        add(createAccountButton);
    }
}






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

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(440, top+110, 200, 100);
        JTextField ageInput = new JTextField();
        ageInput.setBounds(440, top+170, 220, 25);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(440, top+160, 200, 100);
        JTextField usernameInput = new JTextField();
        usernameInput.setBounds(440, top+220, 220, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(440, top+210, 200, 100);
        JTextField passwordInput = new JPasswordField();
        passwordInput.setBounds(440, top+270, 220, 25);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(440, top+260, 200, 100);
        // Create a ButtonGroup to group the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        // Create radio buttons for Male and Female
        JRadioButton maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(440, top + 315, 100, 30);
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(550, top + 315, 100, 30);
        // Add radio buttons to the ButtonGroup
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);


//        JLabel usernameLabelCA = new JLabel("Username:");
//        usernameLabelCA.setBounds(440, 150, 200, 100);
//        JTextField usernameInputCA = new JTextField();
//        usernameInputCA.setBounds(440, 215, 220, 25);

//        JLabel passwordLabelCA = new JLabel("Password:");
//        passwordLabelCA.setBounds(440, 220, 200, 100);
//        JPasswordField passwordInputCA = new JPasswordField();
//        passwordInputCA.setBounds(440, 280, 220, 25);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, top+355, 220, 30);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("🎊 creating employee account");
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

        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, top+390, 220, 30);
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "logInPage");
            }
        });

        add(createAccountTitle);
        add(firstNameLabel);
        add(firstNameInput);
        add(lastNameLabel);
        add(lastNameInput);
        add(ageLabel);
        add(ageInput);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);


//        add(usernameLabelCA);
//        add(usernameInputCA);
       // add(passwordLabelCA);
        //add(passwordInputCA);
        add(logInButton);
        add(createAccountButton);
    }
}


class LogInPage extends JPanel {

    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    PreparedStatement pst;
    private int top = 150;
    boolean userFound = false;
    LogInPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

//        JButton nextPageButton = new JButton("Next Page");
//        nextPageButton.setBounds(500, 400, 100, 30);

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

        JLabel alert = new JLabel();
        alert.setForeground(Color.PINK); // Set the foreground color to red
        alert.setBounds(440, 320, 200, 100);

        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(440, 320, 220, 30);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "dashboard");
                /* ⛔⛔⛔
                userFound = false;
                String username = usernameInput.getText();
                char[] passwordArr = passwordInput.getPassword();
                String userPassword = new String(passwordArr);

                String query = "SELECT * FROM employee WHERE username = '" + username + "'";
                try{
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);
                    Statement statement = con.createStatement();
                    ResultSet result = statement.executeQuery(query);

                    while(result.next()){
                        for(int i = 1; i <= 7; i++){
                            System.out.println(result.getString(i));
                        }
                        if(userPassword.equals(result.getString(7))) {
                            cardLayout.show(container, "dashboard");
                        }
                        else {
                            System.out.println("Wrong password!");
                            alert.setText("Wrong password!");

                        }
                        userFound = true;
                    }
                }catch(SQLException searchError){
                    searchError.printStackTrace();
                }
                if (!userFound) {
                    System.out.println("User not found!");
                    alert.setText("User not found!");
                }
                */
            }
        });
        /*
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(440, 355, 220, 30);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "createAccountPage");
            }
        });
        */


//        nextPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(container, "dashboard");
//            }
//        });

        //add(nextPageButton);
        add(logInTitle);
        add(usernameLabel);
        add(usernameInput);
        add(passwordLabel);
        add(passwordInput);
        add(logInButton);
        add(alert);
        //add(createAccountButton);
    }
}