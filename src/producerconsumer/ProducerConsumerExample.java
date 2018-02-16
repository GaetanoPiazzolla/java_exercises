package producerconsumer;

public class ProducerConsumerExample {
	
	// ATTENZIONE ALLA notifyAll()
    public static void main(String[] args) {
        Drop drop = new Drop();
        Drop drop2 = new Drop();
        
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
        
        (new Thread(new Producer(drop2))).start();
        (new Thread(new Consumer(drop2))).start();
    }
}