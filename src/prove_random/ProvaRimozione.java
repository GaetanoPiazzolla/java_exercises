package prove_random;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ProvaRimozione {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("ciao");
		set.add("ciao");
		set.add("ciao");
		set.add("ciao");
		set.add("rimuovi");
		
		System.out.println("Dimensione:"+set.size());
		
		removeInvalidDocuments(set);
		
		System.out.println("Dimensione:"+set.size());
		
	}
		
	
	public static void removeInvalidDocuments(Set<String> documentSet) {
		if (documentSet == null || documentSet.isEmpty()) {
			return;
		}
		Iterator<String> it = documentSet.iterator();
		int i =0;
		while (it.hasNext()) {
			String document = it.next();
			if (document.equals("rimuovi")) {
				it.remove();
				i++;
			}
		}
		System.out.println("RIMOSSI"+i);
	}
}

