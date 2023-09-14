import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class UserRooms extends JPanel {
    private int top = 50;
    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    String roomsQuery = "select * from Rooms where availabilitystatus = true";
    private JTable roomsTable;
    private String[][] roomsData; // Removed {{}}
    String[] columnNames = {"Room ID", "Room Type", "Price per Night", "Status"};
    String[] roomTypes = {"","Family", "Economy", "Suite"};

    java.util.List<String[]> rows;

    DefaultTableCellRenderer renderer;

    JScrollPane scrollPane;

    public UserRooms(CardLayout cardLayout, JPanel container){
        setLayout(null);
        roomsTable = new JTable();

        JLabel headerLabel = new JLabel("Rooms");
        headerLabel.setBounds(180, top, 300, 50);
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.BOLD, 36));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        // filter buttons
        JPanel filterBar = new JPanel(null);
        JLabel filterLabel = new JLabel("Filter: ");
        filterLabel.setBounds(0,10,50, 10);
        JLabel filterRoomIdLabel = new JLabel("Room ID: ");
        filterRoomIdLabel.setBounds(0,22, 60, 25);
        JTextField filterRoomIdInput = new JTextField();
        filterRoomIdInput.setBounds(60,22, 50, 25);

        JLabel filterTypeLabel = new JLabel("Room Type: ");
        filterTypeLabel.setBounds(130,22, 80, 25);
        JComboBox filterTypeCombo = new JComboBox(roomTypes);
        filterTypeCombo.setBounds(210,22, 120, 25);


        JLabel filterPriceLabel = new JLabel("Max Price: ");
        filterPriceLabel.setBounds(350,22, 70, 25);
        JTextField filterPriceInput = new JTextField();
        filterPriceInput.setBounds(420,22, 40, 25);

        JButton filterButton= new JButton("Filter");
        filterButton.setBounds(470,22, 60, 25);
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int RoomId = 0;
                int MaxPrice = 0;
                String RoomType = "";

                try {
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);

                    // Define the base SQL query
                    String baseQuery = "SELECT * FROM Rooms WHERE 1 = 1";

                    // Create a flag to track if any filter conditions are added
                    boolean filterAdded = false;

                    if(filterRoomIdInput.getText().length() > 0){
                        RoomId = Integer.parseInt(filterRoomIdInput.getText());
                        baseQuery += " AND roomID = ?";
                        filterAdded = true;
                    }

                    if(filterPriceInput.getText().length() > 0){
                        MaxPrice =Integer.parseInt(filterPriceInput.getText());
                        baseQuery += " AND PricePerNight <= ?";
                        filterAdded = true;
                    }

                    RoomType = (String) filterTypeCombo.getSelectedItem();
                    if(RoomType.length() > 0 ){
                        baseQuery += " AND roomType = ?";
                        filterAdded = true;
                    }

                    // If no filter conditions are added, we need to adjust the query
                    if (!filterAdded) {
                        baseQuery = "SELECT * FROM Rooms";
                    }
                    baseQuery+="AND availabilitystatus = true";

                    PreparedStatement pst = con.prepareStatement(baseQuery);

                    // Set values for the parameters
                    int parameterIndex = 1; // Start with the first parameter

                    if (RoomId != 0) {
                        pst.setInt(parameterIndex++, RoomId);
                    }

                    if (!RoomType.equals("")) {
                        pst.setString(parameterIndex++, RoomType);
                    }

                    if (MaxPrice > 0) {
                        pst.setDouble(parameterIndex++, MaxPrice);
                    }

                    ResultSet rs = pst.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // Determine the number of columns dynamically
                    int columnCount = rsmd.getColumnCount();

                    // Create an ArrayList to store the rows of data
                    rows = new java.util.ArrayList<>();


                    while (rs.next()) {
                        String[] rowData = new String[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            if(i==columnCount){
                                if(!Objects.equals(rs.getString(i), "1")){
                                    rowData[i-1] = "Occupied";
                                }else{
                                    rowData[i-1] = "Vacant";
                                }
                            }else{
                                rowData[i - 1] = rs.getString(i);
                            }

                        }
                        rows.add(rowData);
                    }
                    // Convert the ArrayList to a 2D array
                    roomsData = new String[rows.size()][];
                    for (int i = 0; i < rows.size(); i++) {
                        roomsData[i] = rows.get(i);
                    }
                    rs.close();
                } catch (SQLException error) {
                    error.printStackTrace();
                }


                // Create a DefaultTableModel to hold the data and column names
                DefaultTableModel model = new DefaultTableModel(roomsData, columnNames);

                // Create a JTable with the DefaultTableModel
                roomsTable = new JTable(model);
                roomsTable.setEnabled(false);

                // Apply the custom renderer to the first name column
                roomsTable.getColumnModel().getColumn(0).setCellRenderer(renderer);
                // Create a JScrollPane to add the JTable to (for scrolling)
                scrollPane = new JScrollPane(roomsTable);
                scrollPane.setBounds(180, top + 150, 700, 320);
                add(scrollPane);

            }
        });


        JButton allButton= new JButton("Get All");
        allButton.setBounds(550,22, 80, 25);
        allButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fetch all data
                try {
                    Connection con = DriverManager.getConnection(url, uname, dbPassword);
                    Statement statement = con.createStatement();
                    ResultSet result = statement.executeQuery(roomsQuery);
                    ResultSetMetaData rsmd = result.getMetaData();

                    // Determine the number of columns dynamically
                    int columnCount = rsmd.getColumnCount();

                    // Create an ArrayList to store the rows of data
                    rows = new java.util.ArrayList<>();

                    while (result.next()) {
                        String[] rowData = new String[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            if(i==columnCount){
                                if(!Objects.equals(result.getString(i), "1")){
                                    rowData[i-1] = "Occupied";
                                }else{
                                    rowData[i-1] = "Vacant";
                                }
                            }else{
                                rowData[i - 1] = result.getString(i);
                            }
                        }
                        rows.add(rowData);
                    }
                    // Convert the ArrayList to a 2D array
                    roomsData = new String[rows.size()][];
                    for (int i = 0; i < rows.size(); i++) {
                        roomsData[i] = rows.get(i);
                    }
                } catch (SQLException fetchError) {
                    fetchError.printStackTrace();
                }
                // Create a DefaultTableModel to hold the data and column names
                DefaultTableModel model = new DefaultTableModel(roomsData, columnNames);
                // Create a JTable with the DefaultTableModel
                roomsTable = new JTable(model);
                roomsTable.setEnabled(false);
                // Apply the custom renderer to the first name column
                roomsTable.getColumnModel().getColumn(0).setCellRenderer(renderer);
                // Create a JScrollPane to add the JTable to (for scrolling)
                scrollPane = new JScrollPane(roomsTable);
                scrollPane.setBounds(180, top + 150, 700, 320);
                add(scrollPane);
            }
        });


        //adding filter control
        filterBar.add(filterLabel);
        filterBar.add(filterRoomIdLabel);
        filterBar.add(filterRoomIdInput);
        filterBar.add(filterTypeLabel);
        filterBar.add(filterTypeCombo);
        filterBar.add(filterPriceLabel);
        filterBar.add(filterPriceInput);
        filterBar.add(filterButton);
        filterBar.add(allButton);
        filterBar.setBounds(180, top+50+10, 640,90);
        add(filterBar);


        try {
            Connection con = DriverManager.getConnection(url, uname, dbPassword);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(roomsQuery);

            ResultSetMetaData rsmd = result.getMetaData();

            // Determine the number of columns dynamically
            int columnCount = rsmd.getColumnCount();

            // Create an ArrayList to store the rows of data
            rows = new java.util.ArrayList<>();

            while (result.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    if(i==columnCount){
                        if(!Objects.equals(result.getString(i), "1")){
                            rowData[i-1] = "Occupied";
                        }else{
                            rowData[i-1] = "Vacant";
                        }
                    }else{
                        rowData[i - 1] = result.getString(i);
                    }

                }
                rows.add(rowData);
            }

            // Convert the ArrayList to a 2D array
            roomsData = new String[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                roomsData[i] = rows.get(i);
            }
        } catch (SQLException fetchError) {
            fetchError.printStackTrace();
        }

        // Create a DefaultTableModel to hold the data and column names
        DefaultTableModel model = new DefaultTableModel(roomsData, columnNames);

        // Create a JTable with the DefaultTableModel
        roomsTable = new JTable(model);
        roomsTable.setEnabled(false);

        // Create a custom cell renderer to make the first name column bold
        renderer = new DefaultTableCellRenderer() {
            Font font = new Font("Arial", Font.BOLD, 18);
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setFont(font);
                return cell;
            }
        };

        // Apply the custom renderer to the first name column
        roomsTable.getColumnModel().getColumn(0).setCellRenderer(renderer);

        // Create a JScrollPane to add the JTable to (for scrolling)
        scrollPane = new JScrollPane(roomsTable);
        scrollPane.setBounds(180, top + 150, 700, 320);


    add(headerLabel);
    add(scrollPane);
    }

}
