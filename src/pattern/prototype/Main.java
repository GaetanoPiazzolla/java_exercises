package pattern.prototype;

public class Main {

	// prototype usa il clone di java Cloneable. 
	// E' utile ad esempio per le copie difensive.
	public static void main(String[] args) throws Exception {

		ShapeCache s = new ShapeCache();
		AbstractShape sh = s.getShapeFromId("1");
		sh.setId("3");
		sh = s.getShapeFromId("1");
		if (sh.getId().equals("1")) {
			throw new Exception("dovrebbe cambiare, non ho usato il clone");
		}
		
		ShapeCache s1 = new ShapeCache();
		AbstractShape sh1 = s1.getShapeFromIdCloned("1");
		sh1.setId("3");
		sh1 = s1.getShapeFromIdCloned("1");
		if (!sh1.getId().equals("1")) {
			throw new Exception("non dovrebbe cambiare, ho usato il clone");
		}

	}
}
