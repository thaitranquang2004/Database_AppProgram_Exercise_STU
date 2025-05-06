package model;

public class SinhVien_SinhvienOT {
    private int id;
    private String hoTen;
    private float dtb;
    private int maLop;
	public SinhVien_SinhvienOT(int id, String hoTen, float dtb, int maLop) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.dtb = dtb;
		this.maLop = maLop;
	}
	public SinhVien_SinhvienOT(String hoTen, float dtb, int maLop) {
		super();
		this.hoTen = hoTen;
		this.dtb = dtb;
		this.maLop = maLop;
	}
	public SinhVien_SinhvienOT() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDtb() {
		return dtb;
	}
	public void setDtb(float dtb) {
		this.dtb = dtb;
	}
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", hoTen=" + hoTen + ", dtb=" + dtb + ", maLop=" + maLop + "]";
	}
}
