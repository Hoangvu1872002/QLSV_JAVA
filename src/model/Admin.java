package model;

public class Admin {

	public String tenAdmin;
	public String matKhau;
	
	
	public Admin(String tenAdmin, String matKhau) {
		
		this.tenAdmin = tenAdmin;
		this.matKhau = matKhau;
	}
	
    public Admin() {
		
	}

	public String getTenAdmin() {
		return tenAdmin;
	}
	public void setTenAdmin(String tenAdmin) {
		this.tenAdmin = tenAdmin;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "Admin [tenAdmin=" + tenAdmin + ", matKhau=" + matKhau + "]";
	}
	
}
