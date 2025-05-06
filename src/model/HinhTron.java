package model;

public class HinhTron {
    private int id;
    private double banKinh;

    public HinhTron(int id, double banKinh) {
        this.id = id;
        this.banKinh = banKinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getR() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public String toString() {
        return "HinhTron{id=" + id + ", banKinh=" + banKinh + "}";
    }

	public double dienTich() {
		// TODO Auto-generated method stub
		return Math.PI*banKinh*banKinh;
	}

	public double chuVi() {
		// TODO Auto-generated method stub
		return 2*Math.PI*banKinh;
	}
}