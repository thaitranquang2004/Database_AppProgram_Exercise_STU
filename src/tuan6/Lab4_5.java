
package tuan6;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4_5 extends JFrame {
    private JTextField txtDai, txtRong;
    private JButton btnThem, btnXoa;
    private JTable table;
    private DefaultTableModel model;

    public Lab4_5() {
        setTitle("Lab4_5");
        setSize(638, 426);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Panel nhập dữ liệu
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Dài ="));
        txtDai = new JTextField();
        inputPanel.add(txtDai);

        inputPanel.add(new JLabel("Rộng ="));
        txtRong = new JTextField();
        inputPanel.add(txtRong);

        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnThem);
        inputPanel.add(btnXoa);

        getContentPane().add(inputPanel, BorderLayout.NORTH);

        // Bảng hiển thị kết quả
        String[] columnNames = {"Dài", "Rộng", "DT", "CV"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double dai = Double.parseDouble(txtDai.getText());
                    double rong = Double.parseDouble(txtRong.getText());
                    double dt = dai * rong;
                    double cv = 2 * (dai + rong);

                    model.addRow(new Object[]{dai, rong, dt, cv});
                    txtDai.setText("");
                    txtRong.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDai.setText("");
                txtRong.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab4_5().setVisible(true));
    }
}
