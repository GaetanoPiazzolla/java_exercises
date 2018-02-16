package prove_random;

import java.util.HashMap;
import java.util.Map;

public class ProvaHashCode {
	
	static class Oggetto{
		
		@Override
		public int hashCode(){
			return 1;
		}
//		
//		@Override
//		public boolean equals(Object obj) {
//			return true;
//		}
	}
	
	public static void main(String[] args) {
		
	 Oggetto o = new Oggetto();
	 Oggetto o2 = new Oggetto();
	 Oggetto o3 = new Oggetto();
	 Map<Oggetto,String> map = new HashMap<Oggetto,String>();
	 
	 map.put(o,"1");
	 map.put(o2,"2");
	 map.put(o3,"3");
	 
	 String r = map.get(o);
	 r = map.get(o2);
	 r = map.get(o3);
	}
}
