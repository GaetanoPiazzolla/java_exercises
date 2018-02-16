package pattern.singleton;

public final class Singleton2 {
	
	private static Singleton2 instance = null;

	//TODO try to remove this static keyword...
	static
	{
		instance = new Singleton2();
		System.out.println("Singleton2 constructor has been called now");
	}
	
	public static Singleton2 getInstance() throws Exception
	{
		if(instance == null) //<- NEVER
		{
			throw new Exception();
		}
		return instance;
	}
	
	
}
