package tuan5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_4 extends JFrame {
    // UI Components
    private JTextField fieldA;
    private JTextField fieldB;
    private JComboBox<String> operationComboBox;
    private JTextField resultField;
    private JButton calculateButton;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;
    
    public Lab3_4() {
        // Set up the frame
        setTitle("Lab3_4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel labelA = new JLabel("Số A:");
        fieldA = new JTextField(20);
        
        JLabel labelB = new JLabel("Số B:");
        fieldB = new JTextField(20);
        
        JLabel operationLabel = new JLabel("Phép tính:");
        String[] operations = {"+", "-", "*", "/"};
        operationComboBox = new JComboBox<>(operations);
        
        calculateButton = new JButton("Kết quả");
        
        JLabel resultLabel = new JLabel("Kết quả:");
        resultField = new JTextField(20);
        resultField.setEditable(false);
        
        // Set up layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input panel for A and B
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(labelA);
        inputPanel.add(fieldA);
        inputPanel.add(labelB);
        inputPanel.add(fieldB);
        inputPanel.add(operationLabel);
        inputPanel.add(operationComboBox);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        
        // Result panel
        JPanel resultPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);
        
        // Add panels to main panel
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        centerPanel.add(inputPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(resultPanel);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Create menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        // Add event handler for calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        
        // Add main panel to frame
        add(mainPanel);
        
        // Display the frame
        setVisible(true);
    }
    
    private void calculate() {
        try {
            double a = Double.parseDouble(fieldA.getText());
            double b = Double.parseDouble(fieldB.getText());
            String selectedOperation = (String) operationComboBox.getSelectedItem();
            double result = 0;
            
            switch (selectedOperation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        JOptionPane.showMessageDialog(this, 
                            "Không thể chia cho 0!", 
                            "Lỗi", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = a / b;
                    break;
            }
            
            resultField.setText(String.format("%.1f", result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Vui lòng nhập số hợp lệ!", 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create application on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab3_4();
            }
        });
    }
}
