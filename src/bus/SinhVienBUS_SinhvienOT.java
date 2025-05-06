package bus;
import dao.SinhVienDAO_SinhvienOT;
import model.SinhVien_SinhvienOT;
import java.util.List;
public class SinhVienBUS_SinhvienOT {
	   private SinhVienDAO_SinhvienOT sinhVienDAO;

	    public SinhVienBUS_SinhvienOT() {
	        sinhVienDAO = new SinhVienDAO_SinhvienOT();
	    }

	    public List<SinhVien_SinhvienOT> getAllSinhVien() {
	        return sinhVienDAO.findAll();
	    }

	    public boolean addSinhVien(SinhVien_SinhvienOT sv) {	
	        return sinhVienDAO.insert(sv);
	    }

	    public boolean updateSinhVien(SinhVien_SinhvienOT sv) {
	        return sinhVienDAO.update(sv);
	    }

	    public boolean deleteSinhVien(int id) {
	        return sinhVienDAO.delete(id);
	    }
}
