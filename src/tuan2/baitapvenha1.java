package tuan2;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class baitapvenha1 {
	public static int LargestNumber(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    public static String[] tennhan(String name){
        String[] split = name.trim().split(" ");
        if(split.length == 1){
            return new String[]{split[0]};
        }
        return new String[]{split[0],split[split.length-1]};
    }

    public static  boolean Sosanhngaythang(int day, int month, int year){
        if(month > 12 || month < 1 || month == 12){
            return false;
        }
        if(day > 31){
            return false;
        }
        if(year>1980){
            return false;
        }
        Calendar currentDate =  Calendar.getInstance();
        Calendar compareDate =  Calendar.getInstance();
        compareDate.set(year,month-1,day);
        return compareDate.after(currentDate);
    }

    public static double GetAverage(int ...numbers){
        if(numbers.length == 0){
            return 0;
        }
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return (double) sum/numbers.length;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Nhap 3 so de xet");
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      System.out.println(LargestNumber(a,b,c));

       // TáchTên
      System.out.println("Nhap ten de tach");
      String name=sc.next();
      String[] result = tennhan(name);
      System.out.println(Arrays.toString(result));


      // sosanh
      System.out.println("Nhap ngay thang nam");
      int day = sc.nextInt();
      int month = sc.nextInt();
      int year = sc.nextInt();
      if(Sosanhngaythang(day,month,year)){
          System.out.println("Lon hon");
      }else{
          System.out.println("Không tìm ra cái gì hết");
      }

	}

}
