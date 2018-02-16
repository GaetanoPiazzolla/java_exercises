package prove_random.deadlock;

public class ProvaDeadlock {
	

	public static void main(String[] args) {
		
		// final serve per le inner classes ( i runnable ).
		final DeadLock alphonse = new DeadLock();
		final DeadLock gaston = new DeadLock();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					alphonse.bow(gaston);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					gaston.bow(alphonse);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
