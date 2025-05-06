package tuan6;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Lab3_5 extends JFrame {

	private JTextField txtR;
    private JButton btnThem, btnXoa;
    private JTable table;
    private DefaultTableModel model;

    public Lab3_5() {
        setTitle("Lab4_5");
        setSize(350, 200);
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

    
        String[] columnNames = {"R", "Diện tích"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double r = Double.parseDouble(txtR.getText());
                    double area = Math.PI * r * r;

                    model.addRow(new Object[]{r, area});
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
        SwingUtilities.invokeLater(() -> new Lab3_5().setVisible(true));
    }

}
