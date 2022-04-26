package day1;

public class Hero {
	private String name;
	private int hp;

	Hero(String name, int hp){
		setName(name);
		setHp(hp);
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	@Override
	public String toString() {
		return "名前:" + this.name + "/HP:" + this.hp;
	}

}
