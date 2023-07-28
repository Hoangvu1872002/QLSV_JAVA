package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLTS_Model;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.user_DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class QLTS_View_User extends JFrame {
	private JPanel contentPane;
	public QLTS_Model model;
	public JTextField textField_MaSinhVien;
	private JComboBox comboBox_queQuan;
	public static JTable table;
	public static JTable myTable;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLTS_View_ThiSinh frame = new QLTS_View_ThiSinh();
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
	public QLTS_View_User() {
		this.model = new QLTS_Model();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQueQuan = new JLabel("Quê quán:");
		lblQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblQueQuan.setBounds(33, 265, 97, 60);
		contentPane.add(lblQueQuan);
		
		JLabel lblMaThisSinh = new JLabel("Tên thí sinh:");
		lblMaThisSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMaThisSinh.setBounds(395, 265, 127, 60);
		contentPane.add(lblMaThisSinh);
		
		textField_MaSinhVien = new JTextField();
		textField_MaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaSinhVien.setColumns(10);
		textField_MaSinhVien.setBounds(513, 266, 201, 60);
		contentPane.add(textField_MaSinhVien);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
				tableModel.setRowCount(0);
				new user_DAO().filterData(comboBox_queQuan.getSelectedItem().toString(), textField_MaSinhVien.getText());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(724, 278, 98, 34);
		contentPane.add(btnNewButton);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(140, 265, 201, 60);
		contentPane.add(comboBox_queQuan);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 335, 956, 2);
		contentPane.add(separator_1);
		
		JLabel lblDanhSachThi = new JLabel("Danh sách tìm kiếm:");
		lblDanhSachThi.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDanhSachThi.setBounds(33, 347, 178, 60);
		contentPane.add(lblDanhSachThi);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã Thí Sinh", "Tên Thí Sinh", "Quê Quán", "Ngày Sinh", "Giới Tính", "Môn 1", "Môn 2", "Môn 3", "Tổng Điểm"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(155);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 413, 956,207 );
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Điểm của bạn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 81, 178, 45);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 256, 873, -1);
		contentPane.add(separator_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(10, 136, 956, 50);
		contentPane.add(scrollPane_1);
		
		myTable = new JTable();
		scrollPane_1.setViewportView(myTable);
		myTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Th\u00ED Sinh", "T\u00EAn Th\u00ED Sinh", "Qu\u00EA Qu\u00E1n", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "M\u00F4n 1", "M\u00F4n 2", "M\u00F4n 3", "T\u1ED5ng \u0110i\u1EC3m"
			}
		));
		myTable.getColumnModel().getColumn(0).setPreferredWidth(68);
		myTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		myTable.getColumnModel().getColumn(2).setPreferredWidth(66);
		
		JLabel lblNewLabel_1 = new JLabel("Trang Tra Cứu Điểm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(313, 10, 295, 70);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tra cứu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(10, 196, 162, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton cancelSearch = new JButton("Hủy tìm");
		cancelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new user_DAO().loadData();
			}
		});
		cancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cancelSearch.setBounds(832, 278, 111, 34);
		contentPane.add(cancelSearch);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 196, 956, 2);
		contentPane.add(separator_1_2);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("Menu");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFile);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Đăng xuất");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				QLTS_View_Login_User viewloginUser=new QLTS_View_Login_User();
				viewloginUser.setVisible(true);
				
			}
		});
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		user_DAO dao=new user_DAO();
		dao.loadData();
		
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void showView() {
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
