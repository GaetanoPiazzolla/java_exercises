package prove_random;

public class CloneTesting {

	public class ClonableObject implements Cloneable {
		private String name;
	    private int age;
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }
		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTesting cl = new CloneTesting();
		ClonableObject obj = cl.new ClonableObject();
		obj.setAge(10);
		obj.setName("name");
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			obj = cl.new ClonableObject();
			obj.setAge(10);
			obj.setName("name");
		}
		System.out.println("Creating : " + (System.currentTimeMillis() - start) + " ms");

		start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			obj = (ClonableObject) obj.clone();
		}
		System.out.println("Cloning : " + (System.currentTimeMillis() - start) + " ms");

	}
}
