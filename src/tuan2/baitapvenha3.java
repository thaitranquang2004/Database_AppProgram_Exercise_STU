package tuan2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class baitapvenha3 {
	public static void DemSoChuoiXuatHien(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" xuat hien: "+entry.getValue()+" lan");
        }
    }
    public static void MangKiTuNguoc(List<String> list){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Nhap chuoi de them vao : ");
            String str=sc.nextLine();
            if(str.equalsIgnoreCase("done")){
                break;
            }
            list.add(str);
        }
        for(String s:list) {
            System.out.println(s);
        }

    }
    public static void SapXepMangChuoi(List<Integer> list){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Nhap so vao mang : ");
            int a=sc.nextInt();
            if(a==-99){
                break;
            }
            list.add(a);
        }
        Collections.sort(list);

        for (int n:list){
            System.out.println(n);
        }
    }
    public static boolean SoSanh2Mang(List<Integer> list1,List<Integer> list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).equals(list2.get(i))){
                return false;
            }


        }
        return true;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        //Dem so luong phan tu xuat hien trong String
        System.out.println("Nhap ten de dem so luong");
        String name3=sc.nextLine();
        DemSoChuoiXuatHien(name3);

        // Dao ngược mảng chuỗi
        List<String> list3=new ArrayList<>();
        MangKiTuNguoc(list3);



        // Sắp xêó mảng arry
        List<Integer> list4=new ArrayList<>();
        SapXepMangChuoi(list4);
        
        // So sanh 2 mang
        List<Integer> list1=new ArrayList<>() ;
	}

}
