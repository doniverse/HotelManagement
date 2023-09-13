import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class RoomsPage extends JPanel {
    private int top = 50;
    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    String roomsQuery = "select * from Rooms";
    private JTable roomsTable;
    private String[][] roomsData; // Removed {{}}
    String[] columnNames = {"Room ID", "Room Type", "Price per Night", "Status"};

    RoomsPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        roomsTable = new JTable();

        JLabel headerLabel = new JLabel("Rooms");
        headerLabel.setBounds(180, top, 300, 50);
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.PLAIN, 36));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(url, uname, dbPassword);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(roomsQuery);

            ResultSetMetaData rsmd = result.getMetaData();

            // Determine the number of columns dynamically
            int columnCount = rsmd.getColumnCount();

            // Create an ArrayList to store the rows of data
            java.util.List<String[]> rows = new java.util.ArrayList<>();

            while (result.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = result.getString(i);
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
        JTable roomsTable = new JTable(model);
        roomsTable.setEnabled(false);

        // Create a custom cell renderer to make the first name column bold
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
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
        JScrollPane scrollPane = new JScrollPane(roomsTable);
        scrollPane.setBounds(180, top + 50, 700, 400);



        JLabel bookerIdLabel = new JLabel("User ID: ");
        bookerIdLabel.setBounds(180, top+50+450, 60, 20);
        JTextField bookerIdInput = new JTextField();
        bookerIdInput.setBounds(250,top+50+450, 60,20);

        JLabel roomIdLabel = new JLabel("Room ID: ");
        roomIdLabel.setBounds(340, top+50+450, 60, 20);
        JTextField roomIdInput = new JTextField();
        roomIdInput.setBounds(410,top+50+450, 60,20);

        JButton bookBtn = new JButton("Book Room");
        bookBtn.setBounds(490,top+50+450, 110,20);

        // Add the JScrollPane to the frame
        add(headerLabel);
        add(scrollPane);
        add(bookerIdLabel);
        add(bookerIdInput);
        add(roomIdLabel);
        add(roomIdInput);
        add(bookBtn);
    }
}
