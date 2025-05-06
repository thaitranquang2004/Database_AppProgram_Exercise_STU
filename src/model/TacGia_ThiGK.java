package model;

public class TacGia_ThiGK {
	private int id;
	private String ten_tacgia;
	public TacGia_ThiGK(int id, String ten_tacgia) {
		super();
		this.id = id;
		this.ten_tacgia = ten_tacgia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen_tacgia() {
		return ten_tacgia;
	}
	public void setTen_tacgia(String ten_tacgia) {
		this.ten_tacgia = ten_tacgia;
	}
	public TacGia_ThiGK() {
		super();
	}
	@Override
	public String toString() {
		return ten_tacgia;
	}
	
	

}
