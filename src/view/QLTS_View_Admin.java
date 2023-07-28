package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.user_DAO;
import model.User;
import model.Tinh;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class QLTS_View_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField codeTextField;
	private JTextField txtMaTS;
	private JTextField txtTenTS;
	private JTextField txtNgaySinh;
	private JTextField txtDiem1;
	private JTextField txtDiem2;
	private JTextField txtDiem3;
	private JTextField txtMatKhau;
	public static JTable studentTable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBox_queQuan_Admin;
	private JRadioButton radioButton_nam;
	private JRadioButton radioButton_nu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLTS_View_Admin frame = new QLTS_View_Admin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QLTS_View_Admin() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 837);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 31, 955, 759);
		contentPane.add(contentPane_1);
		
		JLabel lblMThSinh_1 = new JLabel("Mã thí sinh:");
		lblMThSinh_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMThSinh_1.setBounds(10, 98, 104, 44);
		contentPane_1.add(lblMThSinh_1);
		
		codeTextField = new JTextField();
		codeTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		codeTextField.setColumns(10);
		codeTextField.setBounds(124, 99, 167, 44);
		contentPane_1.add(codeTextField);
		
		JLabel lblDanhSchTh = new JLabel("Danh sách thí sinh:");
		lblDanhSchTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchTh.setBounds(10, 153, 183, 44);
		contentPane_1.add(lblDanhSchTh);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 207, 926, 127);
		contentPane_1.add(scrollPane);
		
		studentTable = new JTable();
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				txtMaTS.setText(tableModel.getValueAt(row, 0)+"");
				txtTenTS.setText(tableModel.getValueAt(row, 1)+"");
				comboBox_queQuan_Admin.setSelectedItem(tableModel.getValueAt(row, 2)+"");
				if(tableModel.getValueAt(row, 4).equals("Nam")) {
					radioButton_nam.setSelected(true);
				}else {
					radioButton_nu.setSelected(true);
					
				}
				txtNgaySinh.setText(tableModel.getValueAt(row, 3)+"");
				txtDiem1.setText(tableModel.getValueAt(row, 5)+"");
				txtDiem2.setText(tableModel.getValueAt(row, 6)+"");
				txtDiem3.setText(tableModel.getValueAt(row, 7)+"");
				try {
					String pw=new user_DAO().loadPassword(tableModel.getValueAt(row, 0)+"");
					txtMatKhau.setText(pw);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã Thí Sinh", "Tên Thí Sinh", "Quê Quán", "Ngày Sinh", "Giới Tính", "Môn 1", "Môn 2", "Môn 3","Tổng Điểm"
			}
		));
		scrollPane.setViewportView(studentTable);
		
		JButton JButton_Tim = new JButton("Tìm");
		JButton_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				tableModel.setRowCount(0);
				try {
					new user_DAO().showResult(codeTextField.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton_Tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton_Tim.setBounds(319, 98, 95, 44);
		contentPane_1.add(JButton_Tim);
		
		JLabel lblThngTinTh = new JLabel("Thông tin thí sinh:");
		lblThngTinTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinTh.setBounds(10, 344, 183, 44);
		contentPane_1.add(lblThngTinTh);
		
		JLabel lblMThSinh = new JLabel("Mã thí sinh:");
		lblMThSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMThSinh.setBounds(72, 413, 104, 44);
		contentPane_1.add(lblMThSinh);
		
		txtMaTS = new JTextField();
		txtMaTS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaTS.setColumns(10);
		txtMaTS.setBounds(208, 414, 167, 44);
		contentPane_1.add(txtMaTS);
		
		JLabel lblTnThSinh = new JLabel("Tên thí sinh:");
		lblTnThSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnThSinh.setBounds(72, 467, 126, 44);
		contentPane_1.add(lblTnThSinh);
		
		txtTenTS = new JTextField();
		txtTenTS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenTS.setColumns(10);
		txtTenTS.setBounds(208, 468, 167, 44);
		contentPane_1.add(txtTenTS);
		
		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuQun.setBounds(72, 521, 104, 44);
		contentPane_1.add(lblQuQun);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgySinh.setBounds(72, 575, 104, 44);
		contentPane_1.add(lblNgySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(208, 576, 167, 44);
		contentPane_1.add(txtNgaySinh);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiiTnh.setBounds(536, 467, 104, 44);
		contentPane_1.add(lblGiiTnh);
		
		JLabel lblimMn = new JLabel("Điểm môn 1:");
		lblimMn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblimMn.setBounds(536, 521, 116, 44);
		contentPane_1.add(lblimMn);
		
		txtDiem1 = new JTextField();
		txtDiem1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiem1.setColumns(10);
		txtDiem1.setBounds(669, 522, 167, 44);
		contentPane_1.add(txtDiem1);
		
		JLabel lblimMn_1 = new JLabel("Điểm môn 2:");
		lblimMn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblimMn_1.setBounds(536, 575, 116, 44);
		contentPane_1.add(lblimMn_1);
		
		txtDiem2 = new JTextField();
		txtDiem2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiem2.setColumns(10);
		txtDiem2.setBounds(669, 576, 167, 44);
		contentPane_1.add(txtDiem2);
		
		JLabel diemMon3 = new JLabel("Điểm môn 3:");
		diemMon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		diemMon3.setBounds(536, 629, 116, 44);
		contentPane_1.add(diemMon3);
		
		txtDiem3 = new JTextField();
		txtDiem3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiem3.setColumns(10);
		txtDiem3.setBounds(669, 630, 167, 44);
		contentPane_1.add(txtDiem3);
		
		comboBox_queQuan_Admin = new JComboBox();
		ArrayList<Tinh> listTinh =Tinh.getDSTinh();
		comboBox_queQuan_Admin.addItem("");
		for(Tinh tinh :listTinh) {
		comboBox_queQuan_Admin.addItem(tinh.getTenTinh());
		}
		
		comboBox_queQuan_Admin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_queQuan_Admin.setBounds(208, 521, 167, 44);
		contentPane_1.add(comboBox_queQuan_Admin);
		
		radioButton_nam = new JRadioButton("Nam");
		buttonGroup.add(radioButton_nam);
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButton_nam.setBounds(669, 473, 83, 32);
		contentPane_1.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		buttonGroup.add(radioButton_nu);
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioButton_nu.setBounds(763, 473, 70, 32);
		contentPane_1.add(radioButton_nu);
		
		JButton JButton_them = new JButton("Làm Mới");
		JButton_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaTS.setText("");
				txtTenTS.setText("");
				txtMatKhau.setText("");
				txtNgaySinh.setText("");
				txtDiem1.setText("");
				txtDiem2.setText("");
				txtDiem3.setText("");
				comboBox_queQuan_Admin.setSelectedIndex(0);
				buttonGroup.clearSelection();
				
				
			}
		});
		JButton_them.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton_them.setBounds(36, 705, 116, 44);
		contentPane_1.add(JButton_them);
		
		JButton JButton_xoa = new JButton("Xoá");
		JButton_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				
				int row=studentTable.getSelectedRow();
				String masv=(String) tableModel.getValueAt(row, 0);
				try {
					boolean check=new user_DAO().deleteStudent(masv);
					if(check) {
						JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
					}else {
						JOptionPane.showMessageDialog(rootPane, "Xóa không thành công!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableModel.removeRow(row);
				txtMaTS.setText("");
				txtTenTS.setText("");
				txtMatKhau.setText("");
				txtNgaySinh.setText("");
				txtDiem1.setText("");
				txtDiem2.setText("");
				txtDiem3.setText("");
				comboBox_queQuan_Admin.setSelectedIndex(0);
				buttonGroup.clearSelection();
				
			}
		});
		JButton_xoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton_xoa.setBounds(319, 705, 95, 44);
		contentPane_1.add(JButton_xoa);
		
		JButton JButton_capNhat = new JButton("Cập nhật");
		JButton_capNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				int row=studentTable.getSelectedRow();
				String macu=tableModel.getValueAt(row, 0)+"";
				String mamoi=txtMaTS.getText();
				String mk=txtMatKhau.getText();
				String ten=txtTenTS.getText();
				String que=comboBox_queQuan_Admin.getSelectedItem().toString();
				String gt=(radioButton_nam.isSelected()?"Nam":"Nữ");
//				if(tableModel.getValueAt(row, 4).equals("Nam")) {
//					gt="Nữ";
//				}else {
//					gt="Nữ";
//					
//				}
				String ns=txtNgaySinh.getText();
				String m1=txtDiem1.getText();
				String m2=txtDiem2.getText();
				String m3=txtDiem3.getText();
				
				
				boolean check;
				try {
					boolean checkMa= new user_DAO().checkMa(mamoi);
					if((checkMa)||(macu.equals(mamoi))) {
						boolean check1 = new user_DAO().updateStudent(macu, mamoi, mk, ten, que, ns, gt, m1, m2,m3);
						if(check1) {
							JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
							tableModel.setValueAt(mamoi, row, 0);
							tableModel.setValueAt(ten, row, 1);
							tableModel.setValueAt(que, row, 2);
							tableModel.setValueAt(ns, row, 3);
							tableModel.setValueAt(gt, row, 4);
							tableModel.setValueAt(m1, row, 5);
							tableModel.setValueAt(m2, row, 6);
							tableModel.setValueAt(m3, row, 7);
							tableModel.setValueAt(Float. parseFloat(m1) + Float. parseFloat(m2) + Float. parseFloat(m3), row, 8);
							txtMaTS.setText("");
							txtTenTS.setText("");
							txtMatKhau.setText("");
							txtNgaySinh.setText("");
							txtDiem1.setText("");
							txtDiem2.setText("");
							txtDiem3.setText("");
							comboBox_queQuan_Admin.setSelectedIndex(0);
							buttonGroup.clearSelection();
						} 
					}else {
						JOptionPane.showMessageDialog(rootPane, "Mã thí sinh đã tồn tại !");
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		JButton_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton_capNhat.setBounds(564, 705, 116, 44);
		contentPane_1.add(JButton_capNhat);
		
		JButton JButton_luu = new JButton("Lưu");
		JButton_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(txtMaTS.getText().equals("")) {
					sb.append("Ma thi sinh khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(txtTenTS.getText().equals("")) {
					sb.append("Ho ten khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(txtMatKhau.getText().equals("")) {
					sb.append("Mat khau khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(txtNgaySinh.getText().equals("")) {
					sb.append("Ngay sinh khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(txtDiem1.getText().equals("")) {
					sb.append("Diem 1 khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(txtDiem2.getText().equals("")) {
					sb.append("Diem 2 khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(txtDiem3.getText().equals("")) {
					sb.append("Diem 3 khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if(comboBox_queQuan_Admin.getSelectedItem().toString().equals("")) {
					sb.append("Que Quan khong duoc de trong!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
				
				if( radioButton_nam.isSelected()== false && radioButton_nu.isSelected()== false) {
					sb.append("Giới Tính không được để trống!");
				}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(rootPane, sb);
					return;
				}
					User stud = new User();
					stud.setMaThiSinh(txtMaTS.getText());
					stud.setTenThiSinh(txtTenTS.getText());
					stud.setMatKhau(txtMatKhau.getText());
					stud.setNgaySinh(txtNgaySinh.getText());
					stud.setDiemMon1(Float.parseFloat(txtDiem1.getText()));
					stud.setDiemMon2(Float.parseFloat(txtDiem2.getText()));
					stud.setDiemMon3(Float.parseFloat(txtDiem3.getText()));
					stud.setGioiTinh(radioButton_nam.isSelected()?"Nam":"Nữ");
					stud.setQueQuan(comboBox_queQuan_Admin.getSelectedItem().toString());
                     
					try {
						boolean checkMa= new user_DAO().checkMa(txtMaTS.getText());
						if(checkMa) {
							boolean check=new user_DAO().insert(stud);
							if(check) {
								JOptionPane.showMessageDialog(rootPane, "Thêm thí sinh thành công!");
								txtMaTS.setText("");
								txtTenTS.setText("");
								txtMatKhau.setText("");
								txtNgaySinh.setText("");
								txtDiem1.setText("");
								txtDiem2.setText("");
								txtDiem3.setText("");
								comboBox_queQuan_Admin.setSelectedIndex(0);
								buttonGroup.clearSelection();
							}
						}else {
							JOptionPane.showMessageDialog(rootPane, "Mã thí sinh đã tồn tại !");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
			}
		});
		JButton_luu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton_luu.setBounds(828, 705, 95, 44);
		contentPane_1.add(JButton_luu);
		
		JButton JButton_huyTim = new JButton("Huỷ tìm");
		JButton_huyTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) studentTable.getModel();
				tableModel.setRowCount(0);
				new user_DAO().loadTableAdmin();
			}
		});
		JButton_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButton_huyTim.setBounds(412, 98, 110, 44);
		contentPane_1.add(JButton_huyTim);
		
		JLabel lblNewLabel = new JLabel("Mật Khẩu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(72, 629, 104, 44);
		contentPane_1.add(lblNewLabel);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(208, 630, 167, 44);
		contentPane_1.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Trang admin");
		lblNewLabel_1.setBounds(376, 10, 276, 57);
		contentPane_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 344, 936, 2);
		contentPane_1.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-17, 694, 953, 2);
		contentPane_1.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(0, 152, 936, 2);
		contentPane_1.add(separator_1_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 965, 31);
		contentPane.add(menuBar);
		
		JMenu menuFile = new JMenu("Menu");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFile);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Đăng xuất");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				QLTS_View_Home viewHome = new QLTS_View_Home();
				viewHome.showView();
				
			}
		});
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
	}
}
