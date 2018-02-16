package pattern.singleton;

public class Main {

	public class Runnn implements Runnable {
		@Override
		public void run() {
			try {
				Singleton b = Singleton.getInstance();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public class Runnn2 implements Runnable {
		@Override
		public void run() {
				try {
					Singleton2 b = Singleton2.getInstance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) throws Exception {

		Main m = new Main();

		/* SINGLETON */
		long a = System.currentTimeMillis();
		Thread b = new Thread(m.new Runnn());
		Thread c = new Thread(m.new Runnn());
		Thread d = new Thread(m.new Runnn());
		Thread e = new Thread(m.new Runnn());
		// TODO prova a togliere synchronized dal Singleton.getInstance()...
		b.start();
		c.start();
		d.start();
		e.start();
		System.out.println(System.currentTimeMillis() - a);
		
		/* SINGLETON2 */
		Singleton2.getInstance();
		Thread b2 = new Thread(m.new Runnn2());
		Thread c2= new Thread(m.new Runnn2());
		Thread d2 = new Thread(m.new Runnn2());
		Thread e2 = new Thread(m.new Runnn2());
		b2.start();
		c2.start();
		d2.start();
		e2.start();
		
		System.out.println(b.getStackTrace().toString());
		while(!b.getState().equals(Thread.State.TERMINATED))
		{
			System.out.println("non terminato");
		}
		System.out.println("terminato");
		b.start();
	}
}
