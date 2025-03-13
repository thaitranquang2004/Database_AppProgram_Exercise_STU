package tuan3;

import java.util.ArrayList;
import java.util.List;

public class Phongban {

	private String maPhongban;
	private String tenPhongban;
	private List<Nhanvien> nhanviens = new ArrayList<Nhanvien>();
	
	public Phongban() {
		super();
		// TODO Auto-generated constructor stub
		nhanviens = new ArrayList<Nhanvien>();
	}
	public Phongban(String maPhongban, String tenPhongban, List<Nhanvien> nhanviens) {
		super();
		this.maPhongban = maPhongban;
		this.tenPhongban = tenPhongban;
		this.nhanviens = nhanviens;
	}
	public String getMaPhongban() {
		return maPhongban;
	}
	public void setMaPhongban(String maPhongban) {
		this.maPhongban = maPhongban;
	}
	public String getTenPhongban() {
		return tenPhongban;
	}
	public void setTenPhongban(String tenPhongban) {
		this.tenPhongban = tenPhongban;
	}
	public List<Nhanvien> getNhanviens() {
		return nhanviens;
	}
	public void setNhanviens(List<Nhanvien> nhanviens) {
		this.nhanviens = nhanviens;
	}
	
	public Nhanvien getListnhanviens(int i) {
		return this.nhanviens.get(i);
	}
	
	@Override
	public String toString() {
		return "Phongban [maPhongban=" + maPhongban + ", tenPhongban=" + tenPhongban + ", nhanviens=" + nhanviens + "]";
	}
}
