package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import bus.HinhTronBUS;
import model.HinhTron;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JtableHinhTron_Tuan7 {

	private JFrame frame;
	private JTextField txtR;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private java.util.List<HinhTron> hinhTronList = new java.util.ArrayList<>();
	private HinhTronBUS hinhTronBUS=new HinhTronBUS();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtableHinhTron_Tuan7 window = new JtableHinhTron_Tuan7();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JtableHinhTron_Tuan7() {
		initialize();
		loadData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("R = ");
		lblNewLabel.setBounds(52, 59, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtR = new JTextField();
		txtR.setBounds(127, 56, 171, 20);
		frame.getContentPane().add(txtR);
		txtR.setColumns(10);
		
		
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
        list.setBounds(24, 233, 415, 105);
        frame.getContentPane().add(list);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    double r = Double.parseDouble(txtR.getText());
                    HinhTron hinhtron = new HinhTron(0, r); // ID tự động
                    if (hinhTronBUS.themHinhTron(hinhtron)) {
                        JOptionPane.showMessageDialog(frame, "Thêm thành công!");
                        loadData(); // Cập nhật lại danh sách
                    } else {
                        JOptionPane.showMessageDialog(frame, "Lỗi khi thêm!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Nhập sai định dạng bán kính!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
		btnThem.setBounds(35, 141, 89, 23);
		frame.getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    int id = hinhTronList.get(selectedIndex).getId();
                    if (hinhTronBUS.xoaHinhTron(id)) {
                        JOptionPane.showMessageDialog(frame, "Xóa thành công!");
                        loadData();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Lỗi khi xóa!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Chọn một hình tròn để xóa!");
                }
			}
		});
		btnXoa.setBounds(144, 141, 89, 23);
		frame.getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        double newR = Double.parseDouble(txtR.getText());
                        int id = hinhTronList.get(selectedIndex).getId();
                        if (hinhTronBUS.suaHinhTron(id, newR)) {
                            JOptionPane.showMessageDialog(frame, "Cập nhật thành công!");
                            loadData();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Lỗi khi cập nhật!");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Nhập sai định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Chọn một hình tròn để sửa!");
                }
			}
		});
		btnSua.setBounds(297, 141, 89, 23);
		frame.getContentPane().add(btnSua);
		
		JList list = new JList();
		list.setBounds(24, 233, 415, 105);
		frame.getContentPane().add(list);
	}
	private void loadData() {
        hinhTronList = hinhTronBUS.getallHinhTron();
        listModel.clear();
        for (HinhTron hinhtron : hinhTronList) {
            String item = "ID = " + hinhtron.getId() +
                          ", R = " + hinhtron.getR() +
                          ", Diện Tích = " + hinhtron.dienTich() +
                          ", Chu Vi = " + hinhtron.chuVi();
            listModel.addElement(item);
        }
    }
	private void updateJList() {
        listModel.clear();
        for (HinhTron hinhtron : hinhTronList) {
            String item = "R = " + hinhtron.getR() +
                          ", Dien Tich = " + hinhtron.dienTich() +
                          ", Chu Vi = " + hinhtron.chuVi();
            listModel.addElement(item);
        }
    }
}
			