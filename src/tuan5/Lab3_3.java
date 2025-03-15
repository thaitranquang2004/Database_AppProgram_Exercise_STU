package tuan5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3_3 extends JFrame {
    // Exchange rates
    private final double USD_TO_VND = 22800;
    private final double EURO_TO_VND = 27800;
    private final double JPY_TO_VND = 200;
    
    // UI Components
    private JTextField amountField;
    private JComboBox<String> currencyComboBox;
    private JTextField resultField;
    private JButton convertButton;
    
    public Lab3_3() {
        // Set up the frame
        setTitle("Lab3_3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel amountLabel = new JLabel("Số tiền:");
        amountField = new JTextField(10);
        
        JLabel currencyLabel = new JLabel("Đơn vị:");
        String[] currencies = {"USD", "EURO", "JPY"};
        currencyComboBox = new JComboBox<>(currencies);
        
        convertButton = new JButton("Đổi tiền");
        
        JLabel resultLabel = new JLabel("VND =");
        resultField = new JTextField(15);
        resultField.setEditable(false);
        
        // Set up layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(currencyLabel);
        inputPanel.add(currencyComboBox);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(convertButton);
        
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
        
        // Add event handler for convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        
        // Add main panel to frame
        add(mainPanel);
        
        // Display the frame
        setVisible(true);
    }
    
    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String selectedCurrency = (String) currencyComboBox.getSelectedItem();
            double exchangeRate = 0;
            
            if ("USD".equals(selectedCurrency)) {
                exchangeRate = USD_TO_VND;
            } else if ("EURO".equals(selectedCurrency)) {
                exchangeRate = EURO_TO_VND;
            } else if ("JPY".equals(selectedCurrency)) {
                exchangeRate = JPY_TO_VND;
            }
            
            double result = amount * exchangeRate;
            resultField.setText(String.format("%.0f", result));
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
                new Lab3_3();
            }
        });
    }
}