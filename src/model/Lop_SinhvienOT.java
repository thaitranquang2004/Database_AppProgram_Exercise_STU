package model;

public class Lop_SinhvienOT {
    private int maLop;
    private String tenLop;
	public Lop_SinhvienOT(int maLop, String tenLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
	}
	public Lop_SinhvienOT() {
		super();
	}
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	@Override
	public String toString() {
		return tenLop ;
	}
}
