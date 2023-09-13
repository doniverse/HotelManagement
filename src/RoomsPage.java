import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.PreparedStatement;


public class RoomsPage extends JPanel {
    private int top = 50;
    static String uname = "root";
    static String dbPassword = "naolfekadu123";
    static String url = "jdbc:mysql://localhost:3306/hotelmanagement";
    PreparedStatement pst;
    private JTable roomsTable;
    RoomsPage(CardLayout cardLayout, JPanel container) {
        setLayout(null);

        roomsTable  = new JTable();

        JLabel headerLabel = new JLabel("Rooms");
        headerLabel.setBounds(180, top, 300, 50);
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.PLAIN, 36));

        JFrame frame = new JFrame("JTable with Bold First Name");
        frame.setLayout(new BorderLayout());

        // Sample data for the JTable
        Object[][] data = {
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28},
                {"John", "Doe", 30},
                {"Jane", "Smith", 25},
                {"Bob", "Johnson", 35},
                {"Alice", "Williams", 28}
        };

        // Column names for the JTable
        String[] columnNames = {"First Name", "Last Name", "Age"};

        // Create a DefaultTableModel to hold the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the DefaultTableModel
        JTable roomsTable = new JTable(model);
        roomsTable.setEnabled(false);


        // Create a custom cell renderer to make the first name column bold
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            Font font = new Font("Arial", Font.BOLD, 18);
            Font otherFont = new Font("Arial", Font.BOLD, 15);

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
        scrollPane.setBounds(180, top+50, 700,400);

        // Add the JScrollPane to the frame
        add(headerLabel);
        add(scrollPane);
    }
}
