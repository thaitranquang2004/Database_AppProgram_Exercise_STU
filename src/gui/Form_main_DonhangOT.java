package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DonHangDAO_DonhangOT;
import dao.KhachHangDAO_DonhangOT;
import model.DonHang_DonhangOT;
import model.KhachHang_DonhangOT;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form_main_DonhangOT extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNgayTao;
	private JLabel lblTongTien;
	private JTextField textMadonhang;
	private JTextField textNgaytao;
	private JTextField textTongtien;
	private JLabel lblNewLabel_3;
	//private JComboBox cbKhachhang;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JScrollPane scrollPane;
	private JTable table;
	
	
	//////////////////////
	
	private JComboBox<KhachHang_DonhangOT> cbKhachhang;
	private DefaultComboBoxModel<KhachHang_DonhangOT> modelKhachhang = new DefaultComboBoxModel<>();
	private DefaultTableModel model = new DefaultTableModel();

	private List<KhachHang_DonhangOT> listKhachHang = new ArrayList<>();
	private KhachHangDAO_DonhangOT daoKhachHang = new KhachHangDAO_DonhangOT();

	private List<DonHang_DonhangOT> listDH = new ArrayList<>();
	private DonHangDAO_DonhangOT daoDonHang = new DonHangDAO_DonhangOT();
	private JLabel lblDdmmyyyy;
	
	/////////////////////
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_main_DonhangOT frame = new Form_main_DonhangOT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_main_DonhangOT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Ma don hang");
		lblNewLabel.setBounds(32, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNgayTao = new JLabel("Ngay tao");
		lblNgayTao.setBounds(32, 94, 46, 14);
		contentPane.add(lblNgayTao);
		
		lblTongTien = new JLabel("Tong tien");
		lblTongTien.setBounds(32, 139, 46, 14);
		contentPane.add(lblTongTien);
		
		textMadonhang = new JTextField();
		textMadonhang.setBounds(95, 46, 86, 20);
		contentPane.add(textMadonhang);
		textMadonhang.setColumns(10);
		
		textNgaytao = new JTextField();
		textNgaytao.setColumns(10);
		textNgaytao.setBounds(95, 91, 86, 20);
		contentPane.add(textNgaytao);
		
		textTongtien = new JTextField();
		textTongtien.setColumns(10);
		textTongtien.setBounds(95, 136, 86, 20);
		contentPane.add(textTongtien);
		
		lblNewLabel_3 = new JLabel("Khach hang");
		lblNewLabel_3.setBounds(32, 175, 46, 14);
		contentPane.add(lblNewLabel_3);
		// chu y
		cbKhachhang = new JComboBox<>(modelKhachhang);
		cbKhachhang.setBounds(95, 171, 179, 22);
		contentPane.add(cbKhachhang);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String madonhang = textMadonhang.getText();
					
			        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			        Date ngaytao = formatter.parse(textNgaytao.getText());
			        
			        float tongtien = Float.parseFloat(textTongtien.getText());
			        		
					KhachHang_DonhangOT khachhang = (KhachHang_DonhangOT) cbKhachhang.getSelectedItem();
					
					DonHang_DonhangOT sv = new DonHang_DonhangOT(madonhang, ngaytao, tongtien, khachhang.getId());
					if (daoDonHang.insert(sv)) {
						listDH.add(sv);
						model.addRow(new Object[] {sv.getId(),madonhang,ngaytao,tongtien, khachhang });
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Lỗi khi thêm!");
				}
			}
		});
		btnAdd.setBounds(263, 45, 89, 23);
		contentPane.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				if (index != -1) {
					DonHang_DonhangOT sv = listDH.get(index);
					if (daoDonHang.delete(sv.getId())) {
						listDH.remove(index);
						model.removeRow(index);
					}
				}
				
			}
		});
		btnDelete.setBounds(263, 90, 89, 23);
		contentPane.add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				if (index != -1) {
					try {
						int id = listDH.get(index).getId();
						
						String madonhang = textMadonhang.getText();
						
				        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				        Date ngaytao = formatter.parse(textNgaytao.getText());
				        
				        float tongtien = Float.parseFloat(textTongtien.getText());
				        		
						KhachHang_DonhangOT khachhang = (KhachHang_DonhangOT) cbKhachhang.getSelectedItem();
						
						DonHang_DonhangOT svNew = new DonHang_DonhangOT(id,madonhang, ngaytao, tongtien, khachhang.getId());
						if (daoDonHang.update(svNew)) {
							listDH.set(index, svNew);
							model.setValueAt(madonhang, index, 1);
							model.setValueAt(ngaytao, index, 2);
							model.setValueAt(tongtien, index, 3);
							model.setValueAt(khachhang, index, 4);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật!");
					}
				}
				
			}
		});
		btnUpdate.setBounds(263, 135, 89, 23);
		contentPane.add(btnUpdate);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 530, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index != -1) {
					DonHang_DonhangOT sv = listDH.get(index);
					
					textMadonhang.setText(sv.getMa_donhang());
					
			        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			        String dateStr = formatter.format(sv.getNgay_tao());
					textNgaytao.setText(dateStr);
					
					textTongtien.setText(String.valueOf(sv.getTong_tien()));

					// Tìm đúng Lop trong cbxLop để setSelectedIndex
					for (int i = 0; i < modelKhachhang.getSize(); i++) {
						if (modelKhachhang.getElementAt(i).getId() == sv.getKhachhang_id()) {
							cbKhachhang.setSelectedIndex(i);
							break;
						}
					}
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "madonhang", "ngaytao", "tongtien", "khachhang"
			}
		));
		scrollPane.setViewportView(table);
		
		lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(95, 77, 86, 14);
		contentPane.add(lblDdmmyyyy);
		
		// Gán model để sử dụng lại
		model = (DefaultTableModel) table.getModel();

		// Load dữ liệu lớp
		listKhachHang = daoKhachHang.findAll();
		for (KhachHang_DonhangOT lop : listKhachHang) {
			modelKhachhang.addElement(lop);
		}

		// Load dữ liệu sinh viên
		listDH = daoDonHang.findAll();
		for (DonHang_DonhangOT sv : listDH) {
			model.addRow(new Object[] { sv.getId(), sv.getMa_donhang(), sv.getNgay_tao(), sv.getTong_tien(),
					daoKhachHang.findByID(sv.getKhachhang_id()).getTen_khachhang() });
		}

		
	}
}
