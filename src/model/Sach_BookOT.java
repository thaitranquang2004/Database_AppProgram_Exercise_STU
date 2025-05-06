package model;

public class Sach_BookOT {
    private String maSach;
    private String tenSach;
    private float gia;
    private int maLoai;
	public Sach_BookOT(String maSach, String tenSach, float gia, int maLoai) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.maLoai = maLoai;
	}
	public Sach_BookOT( String tenSach, float gia, int maLoai) {
		super();
		this.tenSach = tenSach;
		this.gia = gia;
		this.maLoai = maLoai;
	}
	public Sach_BookOT() {
		super();
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", gia=" + gia + ", maLoai=" + maLoai + "]";
	}
	
}
