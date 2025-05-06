package model;

import java.util.Date;

public class DonHang_DonhangOT {
	private int id;
	private String ma_donhang;
	private Date ngay_tao;
	private float tong_tien;
	private int khachhang_id;
	
	public DonHang_DonhangOT(int id, String ma_donhang, Date ngay_tao, float tong_tien, int khachhang_id) {
		super();
		this.id = id;
		this.ma_donhang = ma_donhang;
		this.ngay_tao = ngay_tao;
		this.tong_tien = tong_tien;
		this.khachhang_id = khachhang_id;
	}

	public DonHang_DonhangOT(String ma_donhang, Date ngay_tao, float tong_tien, int khachhang_id) {
		super();
		this.ma_donhang = ma_donhang;
		this.ngay_tao = ngay_tao;
		this.tong_tien = tong_tien;
		this.khachhang_id = khachhang_id;
	}

	public DonHang_DonhangOT() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMa_donhang() {
		return ma_donhang;
	}

	public void setMa_donhang(String ma_donhang) {
		this.ma_donhang = ma_donhang;
	}

	public Date getNgay_tao() {
		return ngay_tao;
	}

	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}

	public float getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(float tong_tien) {
		this.tong_tien = tong_tien;
	}

	public int getKhachhang_id() {
		return khachhang_id;
	}

	public void setKhachhang_id(int khachhang_id) {
		this.khachhang_id = khachhang_id;
	}

	@Override
	public String toString() {
		return "DonHang [id=" + id + ", ma_donhang=" + ma_donhang + ", ngay_tao=" + ngay_tao + ", tong_tien="
				+ tong_tien + ", khachhang_id=" + khachhang_id + "]";
	}
	
	

}
