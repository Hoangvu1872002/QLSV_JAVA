package model;

import java.util.Date;
import java.util.Objects;

public class User {
	
	public String maThiSinh;
	public String matKhau;
	public String tenThiSinh;
	public String queQuan;
	public String ngaySinh;
	public String gioiTinh;
	public float diemMon1, diemMon2, diemMon3, tongDiem;
	
	public User() {
		
	}

	public User(String maThiSinh, String matKhau, String tenThiSinh, String queQuan, String ngaySinh, String gioiTinh,
			float diemMon1, float diemMon2, float diemMon3) {
		this.maThiSinh = maThiSinh;
		this.matKhau = matKhau;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
		this.tongDiem = diemMon1 + diemMon2+ diemMon3;
	}

	

	public float getTongDiem() {
		return tongDiem;
	}

	public void setTongDiem(float tongDiem) {
		this.tongDiem = tongDiem;
	}

	public String getMaThiSinh() {
		return maThiSinh;
	}

	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenThiSinh() {
		return tenThiSinh;
	}

	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getDiemMon1() {
		return diemMon1;
	}

	public void setDiemMon1(float diemMon1) {
		this.diemMon1 = diemMon1;
	}

	public float getDiemMon2() {
		return diemMon2;
	}

	public void setDiemMon2(float diemMon2) {
		this.diemMon2 = diemMon2;
	}

	public float getDiemMon3() {
		return diemMon3;
	}

	public void setDiemMon3(float diemMon3) {
		this.diemMon3 = diemMon3;
	}

	@Override
	public String toString() {
		return "User [maThiSinh=" + maThiSinh + ", matKhau=" + matKhau + ", tenThiSinh=" + tenThiSinh + ", queQuan="
				+ queQuan + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemMon1=" + diemMon1
				+ ", diemMon2=" + diemMon2 + ", diemMon3=" + diemMon3 + ", tongDiem=" + tongDiem + "]";
	}
	
	
	
	
}
