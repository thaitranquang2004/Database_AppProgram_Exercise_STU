package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SachDAO_BookOT;
import dao.LoaiSachDAO_BookOT;
import model.Sach_BookOT;
import model.LoaiSach_BookOT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormSach_BookOT extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLoaiSach;
    
    ///////////////
    
    private JComboBox<LoaiSach_BookOT> cbxLoaiSach;
    DefaultComboBoxModel<LoaiSach_BookOT> modelLoaiSach = new DefaultComboBoxModel<>();
    DefaultTableModel model = new DefaultTableModel();
    
    LoaiSachDAO_BookOT daoLoaiSach = new LoaiSachDAO_BookOT();
    List<LoaiSach_BookOT> listLoaiSach = new ArrayList<>();
    
    List<Sach_BookOT> listSach = new ArrayList<>();
    SachDAO_BookOT daoSach = new SachDAO_BookOT();

    ///////////////
    
    private JLabel lblMaSach;
    private JLabel lblTenSach;
    private JLabel lblGia;
    private JTextField textMaSach;
    private JTextField textTenSach;
    private JTextField textGia;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormSach_BookOT frame = new FormSach_BookOT();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FormSach_BookOT() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblLoaiSach = new JLabel("Loai Sach");
        lblLoaiSach.setBounds(32, 95, 79, 14);
        contentPane.add(lblLoaiSach);

        cbxLoaiSach = new JComboBox<>();
        cbxLoaiSach.setBounds(135, 91, 145, 22);
        contentPane.add(cbxLoaiSach);
        cbxLoaiSach.setModel(modelLoaiSach);

        lblMaSach = new JLabel("Ma Sach");
        lblMaSach.setBounds(32, 21, 70, 14);
        contentPane.add(lblMaSach);

        lblTenSach = new JLabel("Ten Sach");
        lblTenSach.setBounds(32, 57, 70, 14);
        contentPane.add(lblTenSach);

        lblGia = new JLabel("Gia");
        lblGia.setBounds(32, 133, 70, 14);
        contentPane.add(lblGia);

        textMaSach = new JTextField();
        textMaSach.setBounds(135, 18, 145, 20);
        contentPane.add(textMaSach);
        textMaSach.setColumns(10);

        textTenSach = new JTextField();
        textTenSach.setBounds(135, 54, 145, 20);
        contentPane.add(textTenSach);
        textTenSach.setColumns(10);

        textGia = new JTextField();
        textGia.setBounds(135, 130, 145, 20);
        contentPane.add(textGia);
        textGia.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 180, 510, 200);
        contentPane.add(scrollPane);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(399, 17, 89, 23);
        contentPane.add(btnAdd);
        
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(399, 51, 89, 23);
        contentPane.add(btnDelete);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(399, 91, 89, 23);
        contentPane.add(btnUpdate);

        table = new JTable();  // Khởi tạo table
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Ma Sach", "Ten Sach", "Gia", "Loai Sach"
                }
        ));
        scrollPane.setViewportView(table);
        
        // Load LoaiSach into ComboBox
        listLoaiSach = daoLoaiSach.findAll();
        for (LoaiSach_BookOT loaiSach : listLoaiSach) {
            modelLoaiSach.addElement(loaiSach);
        }
        
		// Gán model để sử dụng lại
        model = (DefaultTableModel) table.getModel();
        
        // Load Sach vao Table
        listSach = daoSach.findAll();
        for (Sach_BookOT sach : listSach) {
            Object[] o = {sach.getMaSach(), sach.getTenSach(), sach.getGia(), sach.getMaLoai()};
            model.addRow(o);
        }

        // Mouse listener for table row selection
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                if (index != -1) {
                    // Get the selected Sach from the list
                    Sach_BookOT selectedSach = listSach.get(index);

                    // Set the values into the text fields
                    textMaSach.setText(selectedSach.getMaSach());
                    textTenSach.setText(selectedSach.getTenSach());
                    textGia.setText(String.valueOf(selectedSach.getGia()));

                    // Find and set the corresponding LoaiSach into the ComboBox
                    for (int i = 0; i < modelLoaiSach.getSize(); i++) {
                        LoaiSach_BookOT loaiSach = modelLoaiSach.getElementAt(i);
                        if (loaiSach.getMaLoai() == selectedSach.getMaLoai()) {
                            cbxLoaiSach.setSelectedItem(loaiSach);
                            break;
                        }
                    }
                }
            }
        });

        //Nut Add
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                    String maSach = textMaSach.getText();
                    String tenSach = textTenSach.getText();
                    float giaFloat = Float.parseFloat(textGia.getText());  // Chuyển đổi String thành float

                    LoaiSach_BookOT loaiSach = (LoaiSach_BookOT) modelLoaiSach.getSelectedItem();
                    int maLoai = loaiSach.getMaLoai();

                    Sach_BookOT sach = new Sach_BookOT(maSach, tenSach, giaFloat, maLoai);
                    if (daoSach.insert(sach)) {
                        listSach.add(sach);
                        model.addRow(new Object[]{maSach, tenSach, giaFloat, loaiSach.getTenLoai()});
                    }
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi khi thêm!");
				}
            }
        });


        //Nut Delete
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                if (index != -1) {
                    Sach_BookOT sach = listSach.get(index);
                    if (daoSach.delete(sach.getMaSach())) {
                        listSach.remove(index);
                        model.removeRow(index);
                    }
                }
            }
        });


        //Nut Update
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                if (index != -1) {
                	try {
                        Sach_BookOT sachOld = listSach.get(index);

                        String maSach = textMaSach.getText();
                        String tenSach = textTenSach.getText();
                        float giaFloat = Float.parseFloat(textGia.getText()); 
                        LoaiSach_BookOT loaiSach = (LoaiSach_BookOT) modelLoaiSach.getSelectedItem();
                        int maLoai = loaiSach.getMaLoai();

                        Sach_BookOT sachNew = new Sach_BookOT(sachOld.getMaSach(), tenSach, giaFloat, maLoai);

                        if (daoSach.update(sachNew)) {
                            listSach.set(index, sachNew);
                            model.setValueAt(tenSach, index, 1);
                            model.setValueAt(giaFloat, index, 2);
                            model.setValueAt(loaiSach.getTenLoai(), index, 3);
                        }
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Lỗi khi thêm!");
					}
                }
            }
        });
    }
}
