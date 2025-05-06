	package bus;
	import dao.LoaiSachDAO_BookOT;
	import model.LoaiSach_BookOT;
	import java.util.List;
	public class LoaiSachBUS_BookOT {
		   private LoaiSachDAO_BookOT loaiSachDAO;
	
		    public LoaiSachBUS_BookOT() {
		        loaiSachDAO = new LoaiSachDAO_BookOT(); // Khởi tạo DAO
		    }
	
		    // Lấy tất cả loại sách
		    public List<LoaiSach_BookOT> findAll() {
		        return loaiSachDAO.findAll();
		    }
	
		    // Thêm loại sách mới
		    public boolean insertLoaiSach(LoaiSach_BookOT loaiSach) {
		        return loaiSachDAO.insert(loaiSach);
		    }
	
		    // Cập nhật thông tin loại sách
		    public boolean updateLoaiSach(LoaiSach_BookOT loaiSach) {
		        return loaiSachDAO.update(loaiSach);
		    }
	
		    // Xóa loại sách
		    public boolean deleteLoaiSach(int maLoai) {
		        return loaiSachDAO.delete(maLoai);
		    }
	}
