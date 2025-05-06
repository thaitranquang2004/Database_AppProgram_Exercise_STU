package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.LopDAO_SinhvienOT;
import dao.SinhVienDAO_SinhvienOT;
import model.Lop_SinhvienOT;
import model.SinhVien_SinhvienOT;

import java.awt.event.*;

public class FormSinhVien_SinhvienOT extends JFrame {

	private JPanel contentPane;
	private JTextField textHoTen;
	private JTextField textDTB;
	private JTable table;

	//////////////////////
	
	private JComboBox<Lop_SinhvienOT> cbxLop;
	private DefaultComboBoxModel<Lop_SinhvienOT> modelLop = new DefaultComboBoxModel<>();
	private DefaultTableModel model = new DefaultTableModel();

	private List<Lop_SinhvienOT> listLop = new ArrayList<>();
	private LopDAO_SinhvienOT daoLop = new LopDAO_SinhvienOT();

	private List<SinhVien_SinhvienOT> listSV = new ArrayList<>();
	private SinhVienDAO_SinhvienOT daoSV = new SinhVienDAO_SinhvienOT();
	
	/////////////////////
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FormSinhVien_SinhvienOT frame = new FormSinhVien_SinhvienOT();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FormSinhVien_SinhvienOT() {
		setTitle("Quản lý sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHoTen = new JLabel("Họ Tên");
		lblHoTen.setBounds(30, 20, 50, 14);
		contentPane.add(lblHoTen);

		JLabel lblDTB = new JLabel("Điểm TB");
		lblDTB.setBounds(30, 55, 60, 14);
		contentPane.add(lblDTB);

		JLabel lblLop = new JLabel("Lớp");
		lblLop.setBounds(30, 90, 50, 14);
		contentPane.add(lblLop);

		textHoTen = new JTextField();
		textHoTen.setBounds(100, 17, 150, 20);
		contentPane.add(textHoTen);
		textHoTen.setColumns(10);

		textDTB = new JTextField();
		textDTB.setBounds(100, 52, 100, 20);
		contentPane.add(textDTB);

		cbxLop = new JComboBox<>(modelLop);
		cbxLop.setBounds(100, 87, 150, 22);
		contentPane.add(cbxLop);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(400, 20, 100, 25);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(400, 60, 100, 25);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(400, 100, 100, 25);
		contentPane.add(btnUpdate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 130, 520, 170);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"MSSV", "Họ Tên", "Điểm TB", "Lớp" }
		));
		scrollPane.setViewportView(table);

		// Gán model để sử dụng lại
		model = (DefaultTableModel) table.getModel();

		// Load dữ liệu lớp
		listLop = daoLop.findAll();
		for (Lop_SinhvienOT lop : listLop) {
			modelLop.addElement(lop);
		}

		// Load dữ liệu sinh viên
		listSV = daoSV.findAll();
		for (SinhVien_SinhvienOT sv : listSV) {
			model.addRow(new Object[] { sv.getId(), sv.getHoTen(), sv.getDtb(), daoLop.findByID(sv.getMaLop()).getTenLop() });
		}

		// Sự kiện click table
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index != -1) {
					SinhVien_SinhvienOT sv = listSV.get(index);
					textHoTen.setText(sv.getHoTen());
					textDTB.setText(String.valueOf(sv.getDtb()));

					// Tìm đúng Lop trong cbxLop để setSelectedIndex
					for (int i = 0; i < modelLop.getSize(); i++) {
						if (modelLop.getElementAt(i).getMaLop() == sv.getMaLop()) {
							cbxLop.setSelectedIndex(i);
							break;
						}
					}
				}
			}
		});

		// Nút Add
		btnAdd.addActionListener(e -> {
			try {
				String hoTen = textHoTen.getText();
				float dtb = Float.parseFloat(textDTB.getText());
				Lop_SinhvienOT lop = (Lop_SinhvienOT) cbxLop.getSelectedItem();
				SinhVien_SinhvienOT sv = new SinhVien_SinhvienOT(hoTen, dtb, lop.getMaLop());
				if (daoSV.insert(sv)) {
					listSV.add(sv);
					model.addRow(new Object[] {sv.getId(), hoTen, dtb, lop.getTenLop() });
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm sinh viên!");
			}
		});

		// Nút Delete
		btnDelete.addActionListener(e -> {
			int index = table.getSelectedRow();
			if (index != -1) {
				SinhVien_SinhvienOT sv = listSV.get(index);
				if (daoSV.delete(sv.getId())) {
					listSV.remove(index);
					model.removeRow(index);
				}
			}
		});

		// Nút Update
		btnUpdate.addActionListener(e -> {
			int index = table.getSelectedRow();
			if (index != -1) {
				try {
					int id = listSV.get(index).getId();
					String hoTen = textHoTen.getText();
					float dtb = Float.parseFloat(textDTB.getText());
					Lop_SinhvienOT lop = (Lop_SinhvienOT) cbxLop.getSelectedItem();
					SinhVien_SinhvienOT svNew = new SinhVien_SinhvienOT(id, hoTen, dtb, lop.getMaLop());
					if (daoSV.update(svNew)) {
						listSV.set(index, svNew);
						model.setValueAt(hoTen, index, 1);
						model.setValueAt(dtb, index, 2);
						model.setValueAt(lop.getTenLop(), index, 3);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật!");
				}
			}
		});
	}
}
