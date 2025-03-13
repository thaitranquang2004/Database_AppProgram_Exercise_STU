package tuan3;

import java.util.ArrayList;
import java.util.List;

public class Lop {
	private String maLop;
	private String tenlop;
	private List<Sinhvien> sinhviens;
	
	public Lop() {
		super();
		// TODO Auto-generated constructor stub
		sinhviens = new ArrayList<Sinhvien>();
	}
	
	public Lop(String maLop, String tenlop, List<Sinhvien> sinhviens) {
		super();
		this.maLop = maLop;
		this.tenlop = tenlop;
		this.sinhviens = sinhviens;
	}
	
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	
	public List<Sinhvien> getSinhviens() {
		return sinhviens;
	}
	public Sinhvien getListSinhviens(int i) {
		return sinhviens.get(i);
	}
	public void setSinhviens(List<Sinhvien> sinhviens) {
		this.sinhviens = sinhviens;
	}
	
	public double tinhDtblop() {
		double sum = 0;
		for(int i = 0;i < this.sinhviens.size();i++) {
			sum += this.sinhviens.get(i).getDtb();
		}
		return sum/this.getSinhviens().size();
	}
	
	@Override
	public String toString() {
		return "Lop [maLop=" + maLop + ", tenlop=" + tenlop + ", sinhviens=" + sinhviens + "]";
	}
	
	

}
