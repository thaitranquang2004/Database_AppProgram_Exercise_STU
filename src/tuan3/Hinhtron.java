package tuan3;

public class Hinhtron {
	private double bankinh;
	private Point pt;
	
	

	public Hinhtron(double bankinh, Point pt) {
		super();
		this.bankinh = bankinh;
		this.pt = pt;
	}

	//public Hinhtron(double bankinh) {
	//	super();
	//	this.bankinh = bankinh;
	//}
	
	

	public double getBankinh() {
		return bankinh;
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}

	public void setBankinh(double bankinh) {
		this.bankinh = bankinh;
	}
	
	public double tinhChuvi() {
		return 2 * Math.PI * bankinh;
	}

	@Override
	public String toString() {
		return "Chuvi Hinhtron [bankinh=" + bankinh + "] [ x = "+ pt.getX() + ", y = "+ pt.getY()+", z = "+pt.getZ()+" ] = "
				+ tinhChuvi();
	}
	
	

}
