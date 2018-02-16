package prove_random.deadlock;

class DeadLock {

	public synchronized void bow(DeadLock dead) throws InterruptedException {
		System.out.println("bow called at: "+System.currentTimeMillis());
		Thread.sleep(10);
		dead.bowBack(this);
		System.out.println("bow back called.");
	}

	public synchronized void bowBack(DeadLock dead) {
		// bowBack e' locked da bow dell'altro thread.
		// SYNCHRONIZED si applica a tutto l'oggetto, non al metodo.
	}
}
