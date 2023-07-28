package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.user_DAO;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;

public class QLTS_View_Login_User extends JFrame {

	private JPanel contentPane;
	private JTextField tenDangNhap;
	private JPasswordField matKhau;
	protected static QLTS_View_Login_User frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frame = new QLTS_View_Login_User();
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
	public QLTS_View_Login_User() {
		this.setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang Đăng Nhập Thí Sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(108, 58, 259, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã thí sinh:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(72, 135, 96, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(72, 205, 85, 29);
		contentPane.add(lblNewLabel_2);
		
		tenDangNhap = new JTextField();
		tenDangNhap.setBounds(197, 130, 198, 44);
		contentPane.add(tenDangNhap);
		tenDangNhap.setColumns(10);
		
		matKhau = new JPasswordField();
		matKhau.setBounds(197, 200, 198, 44);
		contentPane.add(matKhau);
		
		JButton loginButton = new JButton("Đăng Nhập");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginButton.addActionListener(new ActionListener() {
			private user_DAO dao;

			public void actionPerformed(ActionEvent e) {
				try {
					dao=new user_DAO();
					String tenDN=tenDangNhap.getText();
					String MK=matKhau.getText();
					User ts=dao.checkLogin_User(tenDN, MK );
					if(ts!=null) {
						dispose();
						QLTS_View_User viewThiSinh=new QLTS_View_User();
						new user_DAO().loadMyPoint(tenDN, MK);
						viewThiSinh.showView();
					}else {
						JOptionPane.showMessageDialog(rootPane, "Tài khoản không hợp lệ!");
						

					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginButton.setBounds(167, 269, 126, 37);
		contentPane.add(loginButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 505, 31);
		contentPane.add(menuBar);
		
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
				viewHome.showView();
				
			}
		});
		mntmQuayLi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(mntmQuayLi);
		
	}

	
}
