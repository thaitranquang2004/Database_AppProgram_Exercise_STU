package tuan3;

public class BT_Tuan3_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hinhchunhat hcn = new Hinhchunhat(7,6);
		
		System.out.println(hcn.toString());
		
		Hinhtron ht = new Hinhtron(7,new Point(4,3,1));
		
		System.out.println(ht.toString());
		
		Lop lop = new Lop();
		
		lop.setMaLop("TH05");
		lop.setTenlop("Tin hoc 05");
		
		for (int i = 0; i<10;i++) {
			Sinhvien sinhvvien = new Sinhvien("tensinhvien" + i,"mssv" + i,(double)i);
			sinhvvien.setLop(lop);
			lop.getSinhviens().add(sinhvvien);
		}
		
		for (int i = 0; i<10;i++) {
			System.out.println(lop.getListSinhviens(i));
		}
		
		System.out.println("DTB cua lop = " + lop.tinhDtblop());
		
		Phongban phong = new Phongban();
		
		phong.setMaPhongban("24690");
		phong.setTenPhongban("An ninh");
		
		for (int i = 0; i<10;i++) {
			Nhanvien nhanvien = new Nhanvien("tennhanvien" + i,i,(double)i*2.3);
			//Phongban phongg = new Phongban("24690","An ninh",List<>);
			nhanvien.setPhong(phong);
			phong.getNhanviens().add(nhanvien);
		}
		
		for (int i = 0; i<10;i++) {
			System.out.println(phong.getListnhanviens(i));
		}
		
	}

}
