package tuan2;

import java.util.Scanner;

public class baitapvenha2 {
	public static double Tinhtrungbinh(int ...numbers){
        if(numbers.length == 0){
            return 0;
        }
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return (double) sum/numbers.length;
    }


    public static void XetTrungBinh(int math,int chemical,int physical){
        if(math>10||chemical>10||physical>10 || chemical<0||physical<0||math<0){
            System.out.println("Diem Nhap Sai");
        }
        double diemTb = Tinhtrungbinh(math,chemical,physical);
        System.out.println("Diem trung binh cua 3 mon: "+diemTb);
        if(diemTb<0){
            System.out.println("Diem Nhap Sai");
        }else if(diemTb>=9){
            System.out.println("Xuat Sac");
        }else if(diemTb>=8){
            System.out.println("Gioi");
        }else if(diemTb>=7){
            System.out.println("Kha");
        }else if(diemTb>=5){
            System.out.println("Trung binh");
        }else if(diemTb>=4){
            System.out.println("Dau");
        }else{
            System.out.println("Rot");
        }
    }
    public static boolean CheckBoi3Va5(int n){
        if(n<0){
            return false;
        }
        if(n>2e9){
            return false;
        }
        return n%3==0&&n%5==0;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Nhap diem cua 3 mon: ");
    	int math=sc.nextInt();
        int chemical=sc.nextInt();
        int physical=sc.nextInt();
        XetTrungBinh(math,chemical,physical);

        // Check boi cua 3 va 5
        System.out.println("Nhap so de kiem tra bo cua 3 va 5:");
        int n= sc.nextInt();
        if(CheckBoi3Va5(n)) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

       

	}

}
