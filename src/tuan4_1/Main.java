package tuan4_1;

public class Main {

	public static void main(String[] args) {
		
        ResizableCircle resizableCircle = new ResizableCircle(5.0);
        System.out.println("Ban đầu:");
        System.out.println("Bán kính: " + resizableCircle.getRadius());
        System.out.println("Chu vi: " + resizableCircle.getPerimeter());
        System.out.println("Diện tích: " + resizableCircle.getArea());
        
        resizableCircle.resize(20); // Tăng kích thước lên 20%
        
        System.out.println("\nSau khi resize 20%:");
        System.out.println("Bán kính: " + resizableCircle.getRadius());
        System.out.println("Chu vi: " + resizableCircle.getPerimeter());
        System.out.println("Diện tích: " + resizableCircle.getArea());

	}

}
