package tuan5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame {
    // Exchange rates
    private final double USD_TO_VND = 22800;
    private final double EURO_TO_VND = 27800;
    private final double JPY_TO_VND = 200;
    
    // UI Components
    private JTextField inputField;
    private JTextField resultField;
    private JButton usdButton;
    private JButton euroButton;
    private JButton jpyButton;
    
    public CurrencyConverter() {
        // Set up the frame
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel inputLabel = new JLabel("Số tiền:");
        inputField = new JTextField(10);
        
        usdButton = new JButton("USD");
        euroButton = new JButton("EURO");
        jpyButton = new JButton("JPY");
        
        JLabel resultLabel = new JLabel("VND =");
        resultField = new JTextField(15);
        resultField.setEditable(false);
        
        // Set up layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(usdButton);
        buttonPanel.add(euroButton);
        buttonPanel.add(jpyButton);
        
        // Result panel
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);
        
        // Add panels to main panel
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        centerPanel.add(inputPanel);
        centerPanel.add(buttonPanel);
        centerPanel.add(resultPanel);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Add event handlers
        usdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency(USD_TO_VND);
            }
        });
        
        euroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency(EURO_TO_VND);
            }
        });
        
        jpyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency(JPY_TO_VND);
            }
        });
        
        // Add main panel to frame
        add(mainPanel);
        
        // Display the frame
        setVisible(true);
    }
    
    private void convertCurrency(double exchangeRate) {
        try {
            double amount = Double.parseDouble(inputField.getText());
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
                new CurrencyConverter();
            }
        });
    }
}