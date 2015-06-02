package homework2;

//Gustavo Magalhaes Pereira. Circle2D.java

public class Circle2D {
	public double x;
	public double y;
	public double radius;
	
	public Circle2D () {
		this.x = 0.0;
		this.y = 0.0;
		this.radius = 1.0;
	}
	
	public Circle2D (double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI*Math.pow(radius,2);
	}
	
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	
	public boolean contains(double x, double y) {
		if (x <= this.radius && y <= this.radius) 
			if (x >= -this.radius && y >= -this.radius)
				return true;
		return false;
	}
	
	public boolean contains(Circle2D circle) {
		if (circle.getRadius() <= this.radius) {
			if (circle.getX()+circle.getRadius() <= this.radius) {
				if (circle.getY()+circle.getRadius() <= this.radius) {
					return true;
				}
			}
		}
		return false;
	} 
	
	public boolean overlaps(Circle2D circle) {
		double hypotenuse = Math.sqrt(Math.pow(this.x-circle.getX(),2)+Math.pow(this.y-circle.getY(),2));
		if (this.radius+circle.getRadius() >= hypotenuse) {
				return true;
			}
		return false;
		} 

	public static void main(String[] args) {
		Circle2D circle = new Circle2D();
		
		System.out.println("X value: "+circle.getX());
		System.out.println("Y value: "+circle.getY());
		System.out.println("Radius: "+circle.getRadius());
		System.out.println("Area: "+circle.getArea());
		System.out.println("Perimeter: "+circle.getPerimeter());
		
		System.out.println("(a): "+circle.contains(1,1));
		Circle2D circle2 = new Circle2D(0.0,0.0,1.0);
		System.out.println("(b): "+circle.contains(circle2));
		System.out.println("(c): "+circle.overlaps(circle2));
	}

}
