package pattern.singleton;

public final class Singleton {

	/*public static Singleton instance = null;*/
	public static int i;
	private Singleton()
	{
		super();
		System.out.println("Singleton1 constructor has been called now");
	}

	public static /*synchronized*/ Singleton getInstance() throws InterruptedException
	{
		/*if(instance == null)
		{
			System.out.println("Get Instance "+(i++));
			instance = new Singleton();
		}*/
		Thread.sleep(1000);
		//return instance;
		return SingletonHolder.INSTANCE;
	}
	
	// se togli synchronized, puoi utilizzare questo holder.
	 private final static class SingletonHolder{
		 private static final Singleton INSTANCE = new Singleton();
	}
	
}
