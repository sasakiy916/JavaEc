package day3;

public class Eagle extends Animal implements Flyable {

	public Eagle(String name) {
		super(name);
	}

	@Override
	public void Fly() {
		System.out.println("ふわっさぁ");
	}

	@Override
	void makeNoise() {
		System.out.println("ぴーひょろろろろろ");
	}

}
