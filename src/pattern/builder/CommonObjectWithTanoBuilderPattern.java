package pattern.builder;

public class CommonObjectWithTanoBuilderPattern {

	private String value1;
	private String value2;
	
	public CommonObjectWithTanoBuilderPattern(){
		super();
	}
	
	public CommonObjectWithTanoBuilderPattern setValue1(String arg)
	{
		this.value1=arg;
		return this;
	}
	
	public CommonObjectWithTanoBuilderPattern setValue2(String arg)
	{
		this.value2=arg;
		return this;
	}
}
