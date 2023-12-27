import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentInformationSystem {
    private JFrame frame;
    private JTextField idField, nameField, ageField, addressField;
    private JButton addButton, editButton, deleteButton, searchButton;
    private JTextArea resultArea;

    private static final String DB_URL = "jdbc:mysql://localhost/student_db";
    private static final String DB_USER = "root"; // Change this to your MySQL username
    private static final String DB_PASS = ""; // Change this to your MySQL password

    public StudentInformationSystem() {
        frame = new JFrame("Student Information System");

        idField = new JTextField(15);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        addressField = new JTextField(15);

        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");

        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        frame.setLayout(new FlowLayout());

        frame.add(new JLabel("ID:"));
        frame.add(idField);

        frame.add(new JLabel("Name:"));
        frame.add(nameField);

        frame.add(new JLabel("Age:"));
        frame.add(ageField);

        frame.add(new JLabel("Address:"));
        frame.add(addressField);

        frame.add(addButton);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(searchButton);

        frame.add(new JScrollPane(resultArea));

        frame.setSize(485, 300); // Set the size of the frame to 300x300
        frame.setLocationRelativeTo(null);  // Center the frame on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setupListeners() {
        addButton.addActionListener(e -> addStudent());
        editButton.addActionListener(e -> editStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        searchButton.addActionListener(e -> searchStudent());
    }

    private void addStudent() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO students (name, age, address) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameField.getText());
            stmt.setInt(2, Integer.parseInt(ageField.getText()));
            stmt.setString(3, addressField.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student added successfully!");
            clearFields();
        } catch (SQLException ex) {
            showError(ex.getMessage());
        }
    }

    private void editStudent() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE students SET name=?, age=?, address=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameField.getText());
            stmt.setInt(2, Integer.parseInt(ageField.getText()));
            stmt.setString(3, addressField.getText());
            stmt.setInt(4, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student updated successfully!");
            clearFields();
        } catch (SQLException ex) {
            showError(ex.getMessage());
        }
    }

    private void deleteStudent() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Student deleted successfully!");
            clearFields();
        } catch (SQLException ex) {
            showError(ex.getMessage());
        }
    }

    private void searchStudent() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idField.setText(String.valueOf(rs.getInt("id")));
                nameField.setText(rs.getString("name"));
                ageField.setText(String.valueOf(rs.getInt("age")));
                addressField.setText(rs.getString("address"));
            } else {
                JOptionPane.showMessageDialog(frame, "No student found with the given ID.");
            }
        } catch (SQLException ex) {
            showError(ex.getMessage());
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressField.setText("");
    }

    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentInformationSystem());
    }
}
