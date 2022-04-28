package day3;

public abstract class Animal {
	String name;
	Animal(String name){
		this.name = name;
	}

	public void introduce() {
		System.out.println("こんにちは、" + this.name + "です");
	}
	abstract void makeNoise();
}
