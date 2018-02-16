package pattern.template;

public abstract class AbstractAnimal {
	
    public abstract void makeSound();
    public abstract void eatFood();
    public abstract void sleep();

    public final void doEveryday(){
        makeSound();
        eatFood();
        sleep();
    }
}