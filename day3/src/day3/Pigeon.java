package day3;

public class Pigeon extends Animal implements Flyable {

	public Pigeon(String name) {
		super(name);
	}

	@Override
	public void Fly() {
		System.out.println("バサバサバッサァ・・・");
	}

	@Override
	void makeNoise() {
		System.out.println("くるるっぽぉ・・・");
	}

}
