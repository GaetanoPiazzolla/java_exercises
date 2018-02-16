package pattern.builder;

public class CommonObjectBuilder {

	private String value1 = null;
	private String value2 = null;
	
	public CommonObjectBuilder(Builder builder)
	{
		this.value1 = builder.value1;
		this.value2 = builder.value2;
	}
	
	public static class Builder{
		
		private String value1;
		private String value2;
		
		public Builder value1(String arg){
			value1=arg;
			return this;
		}
		
		public Builder value2(String arg){
			value2=arg;
			return this;
		}
		
		public CommonObjectBuilder build(){
			return new CommonObjectBuilder(this);
		}
		
	}
}
