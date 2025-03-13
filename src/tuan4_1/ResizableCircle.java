package tuan4_1;

public class ResizableCircle implements Resizeable {
	private Circle circle;
    
    public ResizableCircle(double radius) {
        this.circle = new Circle(radius);
    }
    
    @Override
    public void resize(int percent) {
        circle.radius *= (1 + percent / 100.0);
    }
    
    public double getPerimeter() {
        return circle.getPerimeter();
    }
    
    public double getArea() {
        return circle.getArea();
    }
    
    public double getRadius() {
        return circle.radius;
    }
}
