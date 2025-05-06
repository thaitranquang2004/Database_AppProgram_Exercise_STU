package bus;

import java.util.ArrayList;
import dao.HinhTronDAO;
import model.HinhTron;

public class HinhTronBUS {
    private HinhTronDAO hinhTronDao;

    // Constructor
    public HinhTronBUS() {
        this.hinhTronDao = new HinhTronDAO(); 
    }

    // Lấy danh sách hình tròn từ database
    public ArrayList<HinhTron> getallHinhTron() {
        return (ArrayList<HinhTron>) hinhTronDao.getAllHinhTron();
    }

    // Thêm hình tròn vào database
    public boolean themHinhTron(HinhTron hinhTron) {
        return hinhTronDao.insertHinhTron(hinhTron);
    }

    // Xóa hình tròn theo ID
    public boolean xoaHinhTron(int id) {
        return hinhTronDao.deleteHinhTron(id);
    }

    // Sửa bán kính của hình tròn theo ID
    public boolean suaHinhTron(int id, double newR) {
        return hinhTronDao.updateHinhTron(id, newR);
    }
}