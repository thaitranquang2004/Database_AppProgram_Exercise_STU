package tuan3;

public class Sinhvien {
	private String Ten;
	private String MSSV;
	private double dtb;
	private Lop lop;
	
	public Sinhvien(String ten, String mSSV, double dtb) {
		super();
		Ten = ten;
		MSSV = mSSV;
		this.dtb = dtb;
	}
	
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
	@Override
	public String toString() {
		return "Sinhvien [Ten=" + Ten + ", MSSV=" + MSSV + ", dtb=" + dtb + "]";
	}
	
	

}
