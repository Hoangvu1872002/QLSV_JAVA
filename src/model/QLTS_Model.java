package model;

import java.util.ArrayList;

public class QLTS_Model {
	private ArrayList<User> dsThiSinh;

	public QLTS_Model() {
		this.dsThiSinh = new ArrayList<User>();
	}

	public QLTS_Model(ArrayList<User> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<User> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<User> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public void insert(User thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
	
	public void delete(User thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}

	public void update(User thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}
	
	
}
