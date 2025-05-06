package model;

public class KhachHang_DonhangOT {
	private int id;
	private String ten_khachhang;
	public KhachHang_DonhangOT(int id, String ten_khachhang) {
		super();
		this.id = id;
		this.ten_khachhang = ten_khachhang;
	}
	public KhachHang_DonhangOT() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen_khachhang() {
		return ten_khachhang;
	}
	public void setTen_khachhang(String ten_khachhang) {
		this.ten_khachhang = ten_khachhang;
	}
	@Override
	public String toString() {
		return ten_khachhang;
	}
	
}
