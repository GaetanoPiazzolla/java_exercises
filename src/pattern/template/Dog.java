package pattern.template;

public class Dog extends AbstractAnimal{

	@Override
	public void makeSound() {
		System.out.println("BAU");
		
	}

	@Override
	public void eatFood() {
		System.out.println("GNAM");
		
	}

	@Override
	public void sleep() {
		System.out.println("zzz");
	}

	/* CANNOT OVERRIDE, IT'S FINALLLLL!!!!! */
    /*public void doEveryday(){
		
	}*/
}
