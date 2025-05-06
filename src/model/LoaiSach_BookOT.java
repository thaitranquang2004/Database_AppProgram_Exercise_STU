package model;

public class LoaiSach_BookOT {
	 private int maLoai;
	 private String tenLoai;
	public LoaiSach_BookOT(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public LoaiSach_BookOT() {
		super();
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	@Override
	public String toString() {
		return  tenLoai ;
	}
}
