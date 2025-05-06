package tuan6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Lab5 extends JFrame {

	private JTextField txtDai, txtRong;
    private JButton btnThem, btnXoa;
    private JTextArea textArea;

    public Lab5() {
        setTitle("Lab4_5");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Chiều dài:"));
        txtDai = new JTextField();
        inputPanel.add(txtDai);

        inputPanel.add(new JLabel("Chiều rộng:"));
        txtRong = new JTextField();
        inputPanel.add(txtRong);

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
                    int dai = Integer.parseInt(txtDai.getText());
                    int rong = Integer.parseInt(txtRong.getText());
                    int dt = dai * rong;
                    int cv = 2 * (dai + rong);

                    String result = String.format("Dai=%d; Rong=%d; DT=%d; CV=%d\n", dai, rong, dt, cv);
                    textArea.append(result);
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
        SwingUtilities.invokeLater(() -> new Lab5().setVisible(true));
    }

}
