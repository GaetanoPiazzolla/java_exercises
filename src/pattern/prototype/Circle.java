package pattern.prototype;

public class Circle extends AbstractShape{

	public Circle(){
	     this.setType("Circle");
	   }

	@Override
	public void drawShape() {
		System.out.println("Inside Circle::draw() method.");
		
	}
}
