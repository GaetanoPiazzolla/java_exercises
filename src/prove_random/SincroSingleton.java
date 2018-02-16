package prove_random;

public class SincroSingleton{
	
	private static SincroSingleton instance = null;
	
	//construttore statico inizializzato solo una volta
	static
	{
		instance = new SincroSingleton();
	}
	
	private SincroSingleton()
	{
		super();
	}
	
	public static SincroSingleton getInstance() throws Exception
	{
		if(instance == null) //<- NEVER
		{
			throw new Exception();
		}
		return instance;
	}
	
	
	public static synchronized void sincronizedMEthod() throws InterruptedException {
		System.out.println("remove doc called");
		Thread.sleep(10000);
		System.out.println("remove doc ended");
	}
}
