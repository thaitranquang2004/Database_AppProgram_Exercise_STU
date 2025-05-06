package model;

public class Sach_ThiGK {
	private int id;
	private String ten_sach;
	private String mo_ta;
	private float gia;
	private int tacgia_id;
	public Sach_ThiGK(int id, String ten_sach, String mo_ta, float gia, int tacgia_id) {
		super();
		this.id = id;
		this.ten_sach = ten_sach;
		this.mo_ta = mo_ta;
		this.gia = gia;
		this.tacgia_id = tacgia_id;
	}
	public Sach_ThiGK(String ten_sach, String mo_ta, float gia, int tacgia_id) {
		super();
		this.ten_sach = ten_sach;
		this.mo_ta = mo_ta;
		this.gia = gia;
		this.tacgia_id = tacgia_id;
	}
	public Sach_ThiGK() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen_sach() {
		return ten_sach;
	}
	public void setTen_sach(String ten_sach) {
		this.ten_sach = ten_sach;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public int getTacgia_id() {
		return tacgia_id;
	}
	public void setTacgia_id(int tacgia_id) {
		this.tacgia_id = tacgia_id;
	}
	@Override
	public String toString() {
		return "Sach [id=" + id + ", ten_sach=" + ten_sach + ", mo_ta=" + mo_ta + ", gia=" + gia + ", tacgia_id="
				+ tacgia_id + "]";
	}
	
	

}
