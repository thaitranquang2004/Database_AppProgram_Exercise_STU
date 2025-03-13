package tuan3;

public class Hinhchunhat {
	private int dai;
	private int rong;
	
	
	
	public Hinhchunhat(int dai, int rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai = dai;
	}
	public int getRong() {
		return rong;
	}
	public void setRong(int rong) {
		this.rong = rong;
	}
	
	public int tinhCV() {
		return (dai + rong)*2;
	}
	
	public int tinhDT() {
		return dai * rong;
	}
	
	@Override
	public String toString() {
		return "Hinhchunhat [dai=" + dai + ", rong=" + rong + "]" + "\nChuvi = " + tinhCV() +"\nDienTich = " + tinhDT();
	}
	
	

}
