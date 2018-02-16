package prove_random;

public class VolatileTest extends Thread {

	// changes to a volatile variable are always visible to other threads
	// PROVA A RIMUOVERE VOLATILE, rimarra sempre nel WHILE e non si concluderà mai.
	volatile boolean keepRunning = true;

    public void run() {
        while (keepRunning) {
        }
        System.out.println("Thread terminated.");
    }

    public static void main(String[] args) throws InterruptedException {
    	VolatileTest t = new VolatileTest();
        t.start();
        Thread.sleep(1000);
        t.keepRunning = false;
        System.out.println("keepRunning set to false.");
    }
}