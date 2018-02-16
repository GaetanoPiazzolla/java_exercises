package pattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {

	public Map<String, AbstractShape> cacheMap = null;

	public ShapeCache() {

		cacheMap = new HashMap<String,AbstractShape>();
		Circle circle = new Circle();
		circle.setId("1");
		cacheMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		cacheMap.put(square.getId(), square);

	};

	// Invece di passare la shape, gli passo una copia.
	// se non gli passassi una copia, potrebbe modificarlo.. ad esempio prova ad
	// usare il metodo
	// getShapeFromId();
	public AbstractShape getShapeFromIdCloned(String id) throws Exception {
		try {
			return (AbstractShape) cacheMap.get(id).clone();
		} catch (NullPointerException e) {
			String msg = "la cache non contiene shape con id:" + id;
			throw new Exception(msg);
		}
	}

	public AbstractShape getShapeFromId(String id) throws Exception {
		return cacheMap.get(id);
	}

}
