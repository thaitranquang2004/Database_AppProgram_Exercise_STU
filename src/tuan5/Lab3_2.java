package tuan5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_2 extends JFrame {
    
    private JTextField fieldA;
    private JTextField fieldB;
    private JTextField resultField;
    private JRadioButton addButton;
    private JRadioButton subtractButton;
    private JRadioButton multiplyButton;
    private JRadioButton divideButton;
    private JButton calculateButton;
    
    public Lab3_2() {
        // Set up the frame
        setTitle("Lab3_2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel labelA = new JLabel("Số A:");
        fieldA = new JTextField(20);
        
        JLabel labelB = new JLabel("Số B:");
        fieldB = new JTextField(20);
        
        // Radio buttons for operations
        addButton = new JRadioButton("+");
        subtractButton = new JRadioButton("-");
        multiplyButton = new JRadioButton("*");
        divideButton = new JRadioButton("/");
        
        // Set the first radio button as selected by default
        addButton.setSelected(true);
        
        // Group the radio buttons
        ButtonGroup operationGroup = new ButtonGroup();
        operationGroup.add(addButton);
        operationGroup.add(subtractButton);
        operationGroup.add(multiplyButton);
        operationGroup.add(divideButton);
        
        // Create calculate button
        calculateButton = new JButton("Kết quả");
        
        // Create result field
        JLabel resultLabel = new JLabel("Kết quả:");
        resultField = new JTextField(20);
        resultField.setEditable(false);
        
        // Set up layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input panel for A and B
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(labelA);
        inputPanel.add(fieldA);
        inputPanel.add(labelB);
        inputPanel.add(fieldB);
        
        // Radio buttons panel
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        radioPanel.add(addButton);
        radioPanel.add(subtractButton);
        radioPanel.add(multiplyButton);
        radioPanel.add(divideButton);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        
        // Result panel
        JPanel resultPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);
        
        // Add panels to main panel
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        centerPanel.add(inputPanel);
        centerPanel.add(radioPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(resultPanel);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
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
            double result = 0;
            
            if (addButton.isSelected()) {
                result = a + b;
            } else if (subtractButton.isSelected()) {
                result = a - b;
            } else if (multiplyButton.isSelected()) {
                result = a * b;
            } else if (divideButton.isSelected()) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(this, 
                        "Không thể chia cho 0!", 
                        "Lỗi", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = a / b;
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
                new Lab3_2();
            }
        });
    }
}