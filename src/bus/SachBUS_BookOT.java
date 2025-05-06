package bus;
import dao.SachDAO_BookOT;
import model.Sach_BookOT;
import java.util.List;
public class SachBUS_BookOT {
	private SachDAO_BookOT sachDAO;

    public SachBUS_BookOT() {
        sachDAO = new SachDAO_BookOT(); // Khởi tạo DAO
    }

    // Lấy tất cả sách
    public List<Sach_BookOT> findAll() {
        return sachDAO.findAll();
    }

    // Thêm sách mới
    public boolean insertSach(Sach_BookOT sach) {
        return sachDAO.insert(sach);
    }

    // Cập nhật thông tin sách
    public boolean updateSach(Sach_BookOT sach) {
        return sachDAO.update(sach);
    }

    // Xóa sách
    public boolean deleteSach(String maSach) {
        return sachDAO.delete(maSach);
    }
}
