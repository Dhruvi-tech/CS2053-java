import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LabSession12 extends JFrame {
    private List<Student> students = new ArrayList<>();
    private JTextArea displayArea;
    private JTextField idField, nameField, emailField, ageField;
    private JComboBox<String> courseBox;
    
    public LabSession12() {
        setTitle("Student Record Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Form fields
        formPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);
        
        formPanel.add(new JLabel("Course:"));
        courseBox = new JComboBox<>(new String[]{"Computer Science", "Engineering", "Mathematics", "Physics", "Chemistry"});
        courseBox.setSelectedIndex(-1);
        formPanel.add(courseBox);
        
        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Student");
        JButton clearButton = new JButton("Clear Fields");
        JButton displayButton = new JButton("Display All");
        
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayButton);
        formPanel.add(buttonPanel);
        
        // Display area
        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Student Records"));
        
        // Layout
        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Event handlers
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText().trim();
                    String name = nameField.getText().trim();
                    String email = emailField.getText().trim();
                    String course = (String) courseBox.getSelectedItem();
                    String ageText = ageField.getText().trim();
                    
                    if (id.isEmpty() || name.isEmpty() || email.isEmpty() || course == null || ageText.isEmpty()) {
                        JOptionPane.showMessageDialog(LabSession12.this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int age = Integer.parseInt(ageText);
                    Student student = new Student(id, name, email, course, age);
                    students.add(student);
                    displayArea.append(student.toString() + "\n");
                    
                    // Clear fields after adding
                    clearFields();
                    
                    JOptionPane.showMessageDialog(LabSession12.this, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LabSession12.this, "Please enter a valid age!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        clearButton.addActionListener(e -> clearFields());
        
        displayButton.addActionListener(e -> {
            displayArea.setText("");
            if (students.isEmpty()) {
                displayArea.setText("No students registered yet.");
            } else {
                for (Student student : students) {
                    displayArea.append(student.toString() + "\n");
                }
            }
        });
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        courseBox.setSelectedIndex(-1);
        ageField.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LabSession12().setVisible(true);
        });
    }
}