package tuan3;

public class Nhanvien {
	private String hoten;
	private int ngaycong;
	private double luongcb;
	private Phongban phong;
	
	public Nhanvien(String hoten, int ngaycong, double luongcb) {
		super();
		this.hoten = hoten;
		this.ngaycong = ngaycong;
		this.luongcb = luongcb;
	}
	
	public Phongban getPhong() {
		return phong;
	}

	public void setPhong(Phongban phong) {
		this.phong = phong;
	}

	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getNgaycong() {
		return ngaycong;
	}
	public void setNgaycong(int ngaycong) {
		this.ngaycong = ngaycong;
	}
	public double getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(double luongcb) {
		this.luongcb = luongcb;
	}
	
	public double getLuong() {
		return (double)ngaycong * luongcb;
	}
	
	@Override
	public String toString() {
		return "Nhanvien [hoten=" + hoten + ", Luong =" + getLuong() + "]";
	}
	

}
