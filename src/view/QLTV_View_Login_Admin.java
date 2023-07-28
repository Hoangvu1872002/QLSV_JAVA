package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.user_DAO;
import model.Admin;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;

public class QLTV_View_Login_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField tenAdmin;
	private JPasswordField matKhau;
	protected static QLTV_View_Login_Admin frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				    frame = new QLTV_View_Login_Admin();
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
	public QLTV_View_Login_Admin() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 481, 350);
		contentPane.add(contentPane_1);
		
		JLabel lblTrangngNhp = new JLabel("Trang Đăng Nhập Admin");
		lblTrangngNhp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrangngNhp.setBounds(133, 57, 259, 44);
		contentPane_1.add(lblTrangngNhp);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Admin:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(57, 119, 96, 29);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(57, 184, 85, 29);
		contentPane_1.add(lblNewLabel_2);
		
		tenAdmin = new JTextField();
		tenAdmin.setColumns(10);
		tenAdmin.setBounds(182, 114, 198, 44);
		contentPane_1.add(tenAdmin);
		
		matKhau = new JPasswordField();
		matKhau.setBounds(182, 179, 198, 44);
		contentPane_1.add(matKhau);
		
		JButton loginButton = new JButton("Đăng Nhập");
		loginButton.addActionListener(new ActionListener() {
			private user_DAO dao;
			public void actionPerformed(ActionEvent e) {
				
				try {
					dao=new user_DAO();
					String tnAdmin=tenAdmin.getText();
					String mkAdmin=matKhau.getText();
					Admin ts=dao.checkLogin_Admin(tnAdmin, mkAdmin );
					if(ts!=null) {
						dispose();
						QLTS_View_Admin viewAdmin=new QLTS_View_Admin();
						new user_DAO().loadTableAdmin();
						viewAdmin.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(rootPane, "Tài khoản không hợp lệ!");
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginButton.setBounds(160, 263, 126, 37);
		contentPane_1.add(loginButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 487, 31);
		contentPane_1.add(menuBar);
		
		JMenu menuFile = new JMenu("Menu");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFile);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem mntmQuayLi = new JMenuItem("Quay lại");
		mntmQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				QLTS_View_Home viewHome = new QLTS_View_Home();
				viewHome.setVisible(true);
				
			}
		});
		mntmQuayLi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(mntmQuayLi);
	}
	
	public void showView() {
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
