package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


import dao.SachDAO_ThiGK;
import dao.TacGiaDAO_ThiGK;
import model.Sach_ThiGK;
import model.TacGia_ThiGK;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormSach_ThiGK extends JFrame {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblNewLabel;
	private JTextField textSach;
	private JLabel lblMT;
	private JTextField textMota;
	private JLabel lblNewLabel_2;
	private JTextField textGia;
	private JLabel lblNewLabel_3;
	//private JComboBox cbTacgia;
	private JScrollPane scrollPane;
	private JTable table;
	
	
	//////////////////////
	
	private JComboBox<TacGia_ThiGK> cbTacgia;
	private DefaultComboBoxModel<TacGia_ThiGK> modelTacGia = new DefaultComboBoxModel<>();
	private DefaultTableModel model = new DefaultTableModel();

	private List<TacGia_ThiGK> listTacGia = new ArrayList<>();
	private TacGiaDAO_ThiGK daoTacGia = new TacGiaDAO_ThiGK();

	private List<Sach_ThiGK> listSach = new ArrayList<>();
	private SachDAO_ThiGK daoSach = new SachDAO_ThiGK();
	
	/////////////////////
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSach_ThiGK frame = new FormSach_ThiGK();
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
	public FormSach_ThiGK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tensach = textSach.getText();
					
					String mota = textMota.getText();
			        
			        float gia = Float.parseFloat(textGia.getText());
			        		
					TacGia_ThiGK tacgia = (TacGia_ThiGK) cbTacgia.getSelectedItem();
					
					Sach_ThiGK sachh = new Sach_ThiGK(tensach, mota, gia, tacgia.getId());
					if (daoSach.insert(sachh)) {
						listSach.add(sachh);
						model.addRow(new Object[] {sachh.getId(),tensach,mota,gia, tacgia });
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Lỗi khi thêm!");
				}
				
			}
		});
		btnAdd.setBounds(517, 40, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = table.getSelectedRow();
				if (index != -1) {
					try {
						int id = listSach.get(index).getId();
						
						String tensach = textSach.getText();
						
						String mota = textMota.getText();
				        
				        float gia = Float.parseFloat(textGia.getText());
				        		
						TacGia_ThiGK Tacgiaa = (TacGia_ThiGK) cbTacgia.getSelectedItem();
						
						Sach_ThiGK sachNew = new Sach_ThiGK(id,tensach, mota, gia, Tacgiaa.getId());
						if (daoSach.update(sachNew)) {
							listSach.set(index, sachNew);
							model.setValueAt(tensach, index, 1);
							model.setValueAt(mota, index, 2);
							model.setValueAt(gia, index, 3);
							model.setValueAt(Tacgiaa, index, 4);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật!");
					}
				}
				
			}
		});
		btnUpdate.setBounds(517, 91, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				if (index != -1) {
					Sach_ThiGK sachh = listSach.get(index);
					if (daoSach.delete(sachh.getId())) {
						listSach.remove(index);
						model.removeRow(index);
					}
				}
				
			}
		});
		btnDelete.setBounds(517, 150, 89, 23);
		contentPane.add(btnDelete);
		
		lblNewLabel = new JLabel("Tên sách:");
		lblNewLabel.setBounds(24, 42, 78, 18);
		contentPane.add(lblNewLabel);
		
		textSach = new JTextField();
		textSach.setBounds(122, 41, 204, 20);
		contentPane.add(textSach);
		textSach.setColumns(10);
		
		lblMT = new JLabel("Mô tả:");
		lblMT.setBounds(24, 71, 78, 18);
		contentPane.add(lblMT);
		
		textMota = new JTextField();
		textMota.setColumns(10);
		textMota.setBounds(122, 72, 204, 63);
		contentPane.add(textMota);
		
		lblNewLabel_2 = new JLabel("Giá:");
		lblNewLabel_2.setBounds(24, 154, 78, 18);
		contentPane.add(lblNewLabel_2);
		
		textGia = new JTextField();
		textGia.setColumns(10);
		textGia.setBounds(122, 151, 204, 20);
		contentPane.add(textGia);
		
		lblNewLabel_3 = new JLabel("Tác giả:");
		lblNewLabel_3.setBounds(24, 198, 78, 18);
		contentPane.add(lblNewLabel_3);
		
		cbTacgia = new JComboBox<>(modelTacGia);
		cbTacgia.setBounds(122, 196, 204, 22);
		contentPane.add(cbTacgia);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 604, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index != -1) {
					Sach_ThiGK sachh = listSach.get(index);
					
					textSach.setText(sachh.getTen_sach());
					
					textMota.setText(sachh.getMo_ta());
					
					
					textGia.setText(String.valueOf(sachh.getGia()));

					for (int i = 0; i < modelTacGia.getSize(); i++) {
						if (modelTacGia.getElementAt(i).getId() == sachh.getTacgia_id()) {
							cbTacgia.setSelectedIndex(i);
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
				"id", "TenSach", "MoTa", "Gia", "TacGia"
			}
		));
		scrollPane.setViewportView(table);
		
		model = (DefaultTableModel) table.getModel();

		listTacGia = daoTacGia.findAll();
		for (TacGia_ThiGK tacgiaa : listTacGia) {
			modelTacGia.addElement(tacgiaa);
		}

		listSach = daoSach.findAll();
		for (Sach_ThiGK sachh : listSach) {
			model.addRow(new Object[] { sachh.getId(), sachh.getTen_sach(), sachh.getMo_ta(), sachh.getGia(),
					daoTacGia.findByID(sachh.getTacgia_id()).getTen_tacgia() });
		}

	}
}
