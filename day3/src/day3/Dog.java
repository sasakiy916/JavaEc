package day3;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}

	@Override
	void makeNoise() {
		System.out.println("ワン");
	}
}
