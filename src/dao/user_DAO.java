package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import helper.connectionDatabase;
import model.Admin;
import model.User;
import view.QLTS_View_Admin;
import view.QLTS_View_User;

public class user_DAO {
	private QLTS_View_User viewThiSinh;

	public boolean insert(User stud) throws Exception {
		String sql = "insert into ThiSinh (MaThiSinh, MatKhau, TenThiSinh, QueQuan, NgaySinh, GioiTinh, diemMon1, diemMon2, diemMon3) values(?,?,?,?,?,?,?,?,?)";
		try (Connection con = connectionDatabase.openConnectionDatabase();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, stud.getMaThiSinh());
			pst.setString(2, stud.getMatKhau());
			pst.setString(3, stud.getTenThiSinh());
			pst.setString(4, stud.getQueQuan());
			pst.setString(5, stud.getNgaySinh());
			pst.setString(6, stud.getGioiTinh());
			pst.setFloat(7, stud.getDiemMon1());
			pst.setFloat(8, stud.getDiemMon2());
			pst.setFloat(9, stud.getDiemMon3());
			insertStudentTable(stud);

			return pst.executeUpdate() > 0;

		}
	}

	
	public Admin checkLogin_Admin(String tenAdmin, String MatKhau) throws SQLException {
		String sql = "select * from UserAdmin where TenAdmin=? and MatKhau=? ";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, tenAdmin);
			pst.setString(2, MatKhau);
			

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Admin ts = new Admin();
					ts.setTenAdmin(rs.getString("TenAdmin"));
					
					return ts;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	
	public User checkLogin_User(String MaThiSinh, String MatKhau) throws SQLException {
		String sql = "select * from ThiSinh where MaThiSinh=? and MatKhau=?";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, MaThiSinh);
			pst.setString(2, MatKhau);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					User ts = new User();
					ts.setMaThiSinh(rs.getString("MaThiSinh"));
					ts.setTenThiSinh(rs.getString("TenThiSinh"));
					ts.setQueQuan(rs.getString("QueQuan"));
					ts.setNgaySinh(rs.getString("NgaySinh"));
					ts.setGioiTinh(rs.getString("GioiTinh"));
					ts.setDiemMon1(rs.getFloat("DiemMon1"));
					ts.setDiemMon2(rs.getFloat("DiemMon2"));
					ts.setDiemMon3(rs.getFloat("DiemMon3"));

					return ts;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void loadMyPoint(String MaThiSinh, String MatKhau) throws SQLException {
		String sql = "select * from ThiSinh where MaThiSinh=? and MatKhau=?";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, MaThiSinh);
			pst.setString(2, MatKhau);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					User ts = new User();
					ts.setMaThiSinh(rs.getString("MaThiSinh"));
					ts.setTenThiSinh(rs.getString("TenThiSinh"));
					ts.setQueQuan(rs.getString("QueQuan"));
					ts.setNgaySinh(rs.getString("NgaySinh"));
					ts.setGioiTinh(rs.getString("GioiTinh"));
					ts.setDiemMon1(rs.getFloat("DiemMon1"));
					ts.setDiemMon2(rs.getFloat("DiemMon2"));
					ts.setDiemMon3(rs.getFloat("DiemMon3"));
					ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));
					loadToMyTable(ts);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loadToMyTable(User ts) {
		DefaultTableModel tableModel = (DefaultTableModel) viewThiSinh.myTable.getModel();

		tableModel.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh() + "", ts.getQueQuan() + ""
				, ts.getNgaySinh() + "",ts.getGioiTinh() + "", ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", ts.getTongDiem() + "", });

	}

	public void loadData() {
		String sql = "select * from ThiSinh";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);
			int stt = 1;
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					User ts = new User();
					ts.setMaThiSinh(rs.getString("MaThiSinh"));
					ts.setTenThiSinh(rs.getString("TenThiSinh"));
					ts.setQueQuan(rs.getString("QueQuan"));
					ts.setNgaySinh(rs.getString("NgaySinh"));
					ts.setGioiTinh(rs.getString("GioiTinh"));
					ts.setDiemMon1(rs.getFloat("DiemMon1"));
					ts.setDiemMon2(rs.getFloat("DiemMon2"));
					ts.setDiemMon3(rs.getFloat("DiemMon3"));
					ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));
					
					addRowToTable(ts, stt++);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addRowToTable(User ts, int stt) {
		DefaultTableModel tableModel = (DefaultTableModel) viewThiSinh.table.getModel();

		tableModel.addRow(new Object[] { stt + "", ts.getMaThiSinh() + "", ts.getTenThiSinh() + "",
				ts.getQueQuan() + "", ts.getGioiTinh() + "", ts.getNgaySinh() + "", ts.getDiemMon1() + "",
				ts.getDiemMon2() + "", ts.getDiemMon3() + "", ts.getTongDiem() + "", });
	}

	public void filterData(String que, String tensv) {
		if ((que == "") && (tensv != "")) {
			String sql = "select * from ThiSinh where TenThiSinh like N'%" + tensv + "'";
			try {
				Connection con = connectionDatabase.openConnectionDatabase();
				PreparedStatement pst = con.prepareStatement(sql);
				int stt = 1;
				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						User ts = new User();
						ts.setMaThiSinh(rs.getString("MaThiSinh"));
						ts.setTenThiSinh(rs.getString("TenThiSinh"));
						ts.setQueQuan(rs.getString("QueQuan"));
						ts.setNgaySinh(rs.getString("NgaySinh"));
						ts.setGioiTinh(rs.getString("GioiTinh"));
						ts.setDiemMon1(rs.getFloat("DiemMon1"));
						ts.setDiemMon2(rs.getFloat("DiemMon2"));
						ts.setDiemMon3(rs.getFloat("DiemMon3"));
						ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));

						addRowToTable(ts, stt++);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ((que != "") && (tensv == "")) {
			String sql = "select * from ThiSinh where QueQuan=?";
			try {
				Connection con = connectionDatabase.openConnectionDatabase();
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, que);
				int stt = 1;
				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						User ts = new User();
						ts.setMaThiSinh(rs.getString("MaThiSinh"));
						ts.setTenThiSinh(rs.getString("TenThiSinh"));
						ts.setQueQuan(rs.getString("QueQuan"));
						ts.setNgaySinh(rs.getString("NgaySinh"));
						ts.setGioiTinh(rs.getString("GioiTinh"));
						ts.setDiemMon1(rs.getFloat("DiemMon1"));
						ts.setDiemMon2(rs.getFloat("DiemMon2"));
						ts.setDiemMon3(rs.getFloat("DiemMon3"));
						ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));
						
						addRowToTable(ts, stt++);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}

		if ((que != "") && (tensv != "")) {
			String sql = "select * from ThiSinh where TenThiSinh like N'%" + tensv + "' and QueQuan=?";
			try {
				Connection con = connectionDatabase.openConnectionDatabase();
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, que);
				int stt = 1;
				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						User ts = new User();
						ts.setMaThiSinh(rs.getString("MaThiSinh"));
						ts.setTenThiSinh(rs.getString("TenThiSinh"));
						ts.setQueQuan(rs.getString("QueQuan"));
						ts.setNgaySinh(rs.getString("NgaySinh"));
						ts.setGioiTinh(rs.getString("GioiTinh"));
						ts.setDiemMon1(rs.getFloat("DiemMon1"));
						ts.setDiemMon2(rs.getFloat("DiemMon2"));
						ts.setDiemMon3(rs.getFloat("DiemMon3"));
						ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));

						addRowToTable(ts, stt++);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void insertStudentTable(User ts) {

		DefaultTableModel tableModel = (DefaultTableModel) QLTS_View_Admin.studentTable.getModel();

		tableModel.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh() + "", ts.getQueQuan() + "", ts.getNgaySinh() + "",
				ts.getGioiTinh() + "", ts.getDiemMon1() + "", ts.getDiemMon2() + "",ts.getDiemMon3() + "", ts.getTongDiem() + "", });

	}

	public void loadTableAdmin() {
		String sql = "select * from ThiSinh";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					User ts = new User();
					ts.setMaThiSinh(rs.getString("MaThiSinh"));
					ts.setTenThiSinh(rs.getString("TenThiSinh"));
					ts.setQueQuan(rs.getString("QueQuan"));
					ts.setNgaySinh(rs.getString("NgaySinh"));
					ts.setGioiTinh(rs.getString("GioiTinh"));
					ts.setDiemMon1(rs.getFloat("DiemMon1"));
					ts.setDiemMon2(rs.getFloat("DiemMon2"));
					ts.setDiemMon3(rs.getFloat("DiemMon3"));
					ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));
					insertStudentTable(ts);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean deleteStudent(String masv) throws Exception {
		String sql = "delete from ThiSinh where MaThiSinh=?";
		try (Connection con = connectionDatabase.openConnectionDatabase();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, masv);

			return pst.executeUpdate() > 0;

		}
	}

	public void showResult(String MaThiSinh) throws SQLException {
		String sql = "select * from ThiSinh where MaThiSinh like ?+'%'";
		
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, MaThiSinh);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					User ts = new User();
					ts.setMaThiSinh(rs.getString("MaThiSinh"));
					ts.setTenThiSinh(rs.getString("TenThiSinh"));
					ts.setQueQuan(rs.getString("QueQuan"));
					ts.setNgaySinh(rs.getString("NgaySinh"));
					ts.setGioiTinh(rs.getString("GioiTinh"));
					ts.setDiemMon1(rs.getFloat("DiemMon1"));
					ts.setDiemMon2(rs.getFloat("DiemMon2"));
					ts.setDiemMon3(rs.getFloat("DiemMon3"));
					ts.setTongDiem(rs.getFloat("DiemMon1") + rs.getFloat("DiemMon2") + rs.getFloat("DiemMon3"));
					
					insertStudentTable(ts);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String loadPassword(String mats) throws Exception{
		String sql = "select MatKhau from ThiSinh where MaThiSinh=?";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, mats);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					return rs.getString("MatKhau");

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateStudent(String macu,String mamoi, String mk, String ten, String que, String ns, String gt, String m1,
			String m2, String m3) throws Exception{
		String sql = "update ThiSinh set MaThiSinh=?, MatKhau=?, TenThiSinh=?, QueQuan=?, NgaySinh=?, GioiTinh=?, DiemMon1=?, DiemMon2=?, DiemMon3=? where MaThiSinh=?";
		try (Connection con = connectionDatabase.openConnectionDatabase();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mamoi);
			pst.setString(2, mk	);
			pst.setString(3, ten);
			pst.setString(4, que);
			pst.setString(5, ns);
			pst.setString(6, gt);
			pst.setFloat(7, Float.parseFloat(m1));
			pst.setFloat(8, Float.parseFloat(m2));
			pst.setFloat(9, Float.parseFloat(m3));
			pst.setString(10, macu);

			return pst.executeUpdate() > 0;

		}
	}

	public boolean checkMa(String mamoi) {
		String sql = "select * from ThiSinh where MaThiSinh=?";
		try {
			Connection con = connectionDatabase.openConnectionDatabase();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, mamoi);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}