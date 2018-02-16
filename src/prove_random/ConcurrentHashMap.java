package prove_random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMap {

	// The methods such as get(), put(), remove() are synchronized in HashTable
	// whereas ConcurrentHashMap does not use synchronized methods for
	// concurrency.

	static java.util.concurrent.ConcurrentHashMap<Integer, String> map = new java.util.concurrent.ConcurrentHashMap<Integer, String>();
	static java.util.Map<Integer, String> map2 = new HashMap<Integer, String>();

	class WriteThreasOne implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {

				map.putIfAbsent(i, "A" + i);

				if (!map2.containsKey(i))
					map2.put(i, "A" + i);
			}
		}
	}

	class WriteThreasTwo implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				map.put(i, "B" + i);

				if (!map2.containsKey(i))
					map2.put(i, "B" + i);
			}
		}
	}

	class ReadThread implements Runnable {
		@Override
		public void run() {
			Iterator<Integer> ite = map.keySet().iterator();
			while (ite.hasNext()) {
				Integer key = ite.next();
				System.out.println(key + " : " + map.get(key));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap ob = new ConcurrentHashMap();

		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(ob.new WriteThreasOne());
		service.execute(ob.new WriteThreasTwo());
		service.execute(ob.new ReadThread());

		System.out.println(map.toString());
		System.out.println(map2.toString());
	}
}
