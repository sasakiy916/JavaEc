package day3;

import java.util.ArrayList;
import java.util.List;

public class AnimalApp {
	public static void main(String[] args) {
		List<Animal> list = new ArrayList<>();
		list.add(new Pig("豚"));
		list.add(new Cat("猫"));
		list.add(new Dog("犬"));
		list.add(new Pigeon("鳩"));
		list.add(new Eagle("鷲"));
		for(Animal a : list) {
			a.introduce();
			a.makeNoise();
			if(a instanceof Cat) {
				((Cat)a).sleep();
			}
			if(a instanceof Flyable) {
				((Flyable) a).Fly();
			}
		}
	}
}
