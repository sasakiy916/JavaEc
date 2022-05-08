
public class Tramp {
	String name;
	int num;
	String simbol;
	public Tramp(String name,int num,String simbol) {
		this.name = name;
		this.num = num;
		this.simbol = simbol;
	}
	@Override
	public String toString() {
		return "Tramp [name=" + name + ", num=" + num + ", simbol=" + simbol + "]";
	}
}
