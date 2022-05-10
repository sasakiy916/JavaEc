package tarotto;

public class Card {
	String name;
	String text;
	public Card(String name,String text) {
		this.name = name;
		this.text = text;
	}
	@Override
	public String toString() {
		System.out.println("種類:" + this.name);
		System.out.println("テキスト:" + this.text);
		return "";
	}
}
