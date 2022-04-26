package day1;

public class Wizard {
	private int hp;
	private int mp;
	private String name;
	private Wand wand;
	Wizard(String name,int hp,int mp){
		setName(name);
		setHp(hp);
		setMp(mp);
	}
	public void heal(Hero h) {
		int basePoint = 10;
		int recoverPoint = (int)(basePoint * this.getWand().getPower());
		h.setHp(h.getHp() + recoverPoint);
		System.out.println(h.getName() + "のHPを" + recoverPoint + "回復した!");
	}

	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		if(hp < 0) {
			this.hp = 0;
		}
		this.hp = hp;
	}
	public int getMp() {
		return this.mp;
	}
	public void setMp(int mp) {
		if(mp < 0) {
			throw new IllegalArgumentException("MPは0以上で設定する");
		}
		this.mp = mp;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if(name.length() < 3) {
			throw new IllegalArgumentException("名前が短すぎます。3文字以上で設定してください");
		}
		this.name = name;
	}
	public Wand getWand() {
		if(this.wand == null) {
			throw new IllegalArgumentException(getName() + "は杖を装備していない");
		}
		return this.wand;
	}
	public void setWand(Wand wand) {
		this.wand = wand;
	}
}
