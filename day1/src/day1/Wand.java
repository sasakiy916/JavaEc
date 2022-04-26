package day1;

public class Wand {
	private String name;
	private double power;

	public Wand(String name,double power) {
		setName(name);
		setPower(power);
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
	public double getPower() {
		return this.power;
	}
	public void setPower(double power) {
		if(0.5 >  power || power > 100) {
			throw new IllegalArgumentException("増幅率は0.5以上100以下で設定してください");
		}
		this.power = power;
	}
}
