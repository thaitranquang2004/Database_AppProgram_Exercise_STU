package bus;
import dao.LopDAO_SinhvienOT;
import model.Lop_SinhvienOT;
import java.util.List;
public class LopBUS_SinhvienOT {
    private LopDAO_SinhvienOT lopDAO;

    public LopBUS_SinhvienOT() {
        lopDAO = new LopDAO_SinhvienOT();
    }

    public List<Lop_SinhvienOT> getAllLop() {
        return lopDAO.findAll();
    }
}
