package pattern.prototype;

public class Square extends AbstractShape{

	public Square(){
	     this.setType("Square");
	   }

	@Override
	public void drawShape() {
		System.out.println("Inside Square::draw() method.");
		
	}
}
