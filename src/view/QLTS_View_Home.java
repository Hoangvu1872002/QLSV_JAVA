package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class QLTS_View_Home extends JFrame {

	private JPanel contentPane;
	protected static QLTS_View_Home frame;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				    frame = new QLTS_View_Home();
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
	public QLTS_View_Home() {
		this.setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn tài khoản đăng nhập:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(87, 23, 353, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thí Sinh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new QLTS_View_Login_User();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(163, 103, 158, 53);
		contentPane.add(btnNewButton);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				QLTV_View_Login_Admin viewloginAdmin=new QLTV_View_Login_Admin();
				viewloginAdmin.showView();
				
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdmin.setBounds(163, 188, 158, 53);
		contentPane.add(btnAdmin);
	}
	
	public void showView() {
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
