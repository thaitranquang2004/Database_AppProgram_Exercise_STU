package bus;

import java.util.List;

import dao.KhachHangDAO_DonhangOT;
import model.KhachHang_DonhangOT;

public class KhachHangBUS_DonhangOT {
	
	private KhachHangDAO_DonhangOT khachhangDAO;
	
    public KhachHangBUS_DonhangOT() {
    	khachhangDAO = new KhachHangDAO_DonhangOT();
    }
    
    public List<KhachHang_DonhangOT> getAllLop() {
        return khachhangDAO.findAll();
    }

}
