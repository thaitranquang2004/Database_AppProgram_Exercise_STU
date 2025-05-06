package bus;

import java.util.List;

import dao.DonHangDAO_DonhangOT;
import model.DonHang_DonhangOT;

public class DonHangBUS_DonhangOT {
	
	private DonHangDAO_DonhangOT donhangDAO;
	
	public DonHangBUS_DonhangOT() {
		donhangDAO = new DonHangDAO_DonhangOT();
	}
	
    public List<DonHang_DonhangOT> getAllSinhVien() {
        return donhangDAO.findAll();
    }

    public boolean addDonHang(DonHang_DonhangOT dh) {	
        return donhangDAO.insert(dh);
    }

    //public boolean updateDonHang(DonHang sv) {
      //  return donhangDAO.update(sv);}

    //public boolean deleteDonHang(int id) {
      //  return donhangDAO.delete(id);}

}
