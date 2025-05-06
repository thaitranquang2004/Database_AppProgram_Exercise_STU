package tuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Lab3_2 extends JFrame {

	private JTextField txtSoNgay;
    private JRadioButton rbA, rbB, rbC;
    private JCheckBox cbThueXe, cbCatUi;
    private JButton btnThanhToan;

    public Lab3_2() {
        setTitle("Lab3_2");
        setSize(274, 339);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(5, 1, 5, 5));

        JPanel panelNgay = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNgay.add(new JLabel("Số ngày:"));
        txtSoNgay = new JTextField(10);
        panelNgay.add(txtSoNgay);
        getContentPane().add(panelNgay);


        JPanel panelPhong = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPhong.add(new JLabel("Loại phòng:"));
        rbA = new JRadioButton("A");
        rbB = new JRadioButton("B");
        rbC = new JRadioButton("C");
        ButtonGroup group = new ButtonGroup();
        group.add(rbA);
        group.add(rbB);
        group.add(rbC);
        rbA.setSelected(true);
        panelPhong.add(rbA);
        panelPhong.add(rbB);
        panelPhong.add(rbC);
        getContentPane().add(panelPhong);


        JPanel panelDichVu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDichVu.add(new JLabel("Dịch vụ:"));
        cbThueXe = new JCheckBox("Thuê xe");
        cbCatUi = new JCheckBox("Cắt ủi");
        panelDichVu.add(cbThueXe);
        panelDichVu.add(cbCatUi);
        getContentPane().add(panelDichVu);


        btnThanhToan = new JButton("Thanh toán");
        getContentPane().add(btnThanhToan);


        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int soNgay = Integer.parseInt(txtSoNgay.getText());

                    int giaPhong = 0;
                    if (rbA.isSelected()) giaPhong = 1000;
                    if (rbB.isSelected()) giaPhong = 800;
                    if (rbC.isSelected()) giaPhong = 500;

            
                    int dichVu = 0;
                    if (cbThueXe.isSelected()) dichVu += 200;
                    if (cbCatUi.isSelected()) dichVu += 150;

                    int tongTien = (giaPhong + dichVu) * soNgay;

                    JOptionPane.showMessageDialog(null, "Tổng tiền = " + tongTien, "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số ngày hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Lab3_2().setVisible(true));
    }

}
