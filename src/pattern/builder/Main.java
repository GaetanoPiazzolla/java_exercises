package pattern.builder;

public class Main {

	public static void main(String[] args) {

		CommonObjectWithTanoBuilderPattern common = new CommonObjectWithTanoBuilderPattern().setValue1("a").setValue2("b");
		
		CommonObjectBuilder commonBuilder = new CommonObjectBuilder.Builder().value1("va").build();

	}
}
