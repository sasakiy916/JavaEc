package day3;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	void makeNoise() {
		System.out.println("ニャン");
	}
	public void sleep() {
		System.out.println("すやすや");
	}

}
