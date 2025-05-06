package tuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Lab3_4 extends JFrame {

	private JTextField txtR;
    private JButton btnThem, btnXoa;
    private JTextArea textArea;

    public Lab3_4() {
        setTitle("Lab3_4");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("R ="));
        txtR = new JTextField();
        inputPanel.add(txtR);

        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnThem);
        inputPanel.add(btnXoa);

        add(inputPanel, BorderLayout.NORTH);


        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

 
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double r = Double.parseDouble(txtR.getText());
                    double dt = Math.PI * r * r;
                    double cv = 2 * Math.PI * r;
                    
                    String result = String.format("R=%.1f; DT=%.10f; CV=%.10f\n", r, dt, cv);
                    textArea.append(result);
                    txtR.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtR.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab3_4().setVisible(true));
    }

}
