package day1;

public class MainEx13 {

	public static void main(String[] args) {
		Hero h = new Hero("勇者",100);
		Wizard w = new Wizard("魔法使い",-1,10);
		w.setWand(new Wand("すごい杖",1.5));
		w.heal(h);
		System.out.println(h);
	}

}
