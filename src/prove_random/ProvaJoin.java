package prove_random;

public class ProvaJoin {
	
	public static void main(String[] args)
	{
		
		long startTime = System.currentTimeMillis();
		long patience = 5000l;
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println("thread was interrupted");
				}
				
			}
		});
		
		a.start();
		
		while(a.isAlive())
		{
			try {
				System.out.println("waiting 1 sec");
				a.join(1000);
				
				if (((System.currentTimeMillis() - startTime) > patience)
		                  && a.isAlive()) {
		                a.interrupt();
		                // Shouldn't be long now
		                // -- wait indefinitely
		                a.join();
		            }
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Still alive");
		}
		
		
	}

}
