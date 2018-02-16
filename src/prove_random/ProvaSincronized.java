package prove_random;

public class ProvaSincronized {

	private static SincroSingleton sing;

	/*
	 * Il problema dei metodi Synchronized, è che posso aumentare il ciclo di vita.
	 */
	public static void main(String[] args) throws Exception {

		
		// attenzione! se tolgo lo static dal metodo sinchronizedMethod, il sincronized si riferira'
		// a tutto l'oggetto.
		sing = SincroSingleton.getInstance();

		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					SincroSingleton.sincronizedMEthod();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		a.start();

		SincroSingleton.sincronizedMEthod();
	}

}
