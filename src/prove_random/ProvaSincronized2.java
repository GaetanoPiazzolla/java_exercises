package prove_random;

public class ProvaSincronized2 {

	public class ProvaLock {

		public int var1 = 0;
		public int var2 = 0;

		Object lock1 = new Object();
		Object lock2 = new Object();

		public void incrementVar1() {
			synchronized (lock1) {
				var1++;
			}
		}

		public void incrementVar2() {
			synchronized (lock2) {
				var2++;
			}
		}
	}

	public class ProvaLock2 {

		public int var1 = 0;
		public int var2 = 0;

		public void incrementVar1() throws InterruptedException {
			
			// PROVA A TOGLIERE QUESTO SYNCHRONIZE
			synchronized (this) {
				System.out.println("increment var 1");
				Thread.sleep(10000);
				var1++;
				System.out.println("increment var 1 stop");
			}
		}

		public void incrementVar1_bis() throws InterruptedException{
			synchronized (this) {
				var1++;
				Thread.sleep(10000);
				System.out.println("increment var 1 bis");
			}
		}

	}

	public static void main(String[] args) throws Exception {

		ProvaSincronized2 m = new ProvaSincronized2();
		final ProvaLock2 lock = m.new ProvaLock2();
		new Thread(new Runnable() {
			public void run() {
				try {
					lock.incrementVar1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		// questa acquisisce prima il lock su incrementVar1 dell'altro thread.
		lock.incrementVar1_bis();
	}

}
