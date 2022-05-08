
public class Tramp {
	String name;//名称
	int num;//数字
	String simbol;//マーク
	public Tramp(String name,int num,String simbol) {
		this.name = name;
		this.num = num;
		this.simbol = simbol;
	}
	//デバッグに使ったtoStringのオーバーライド
	@Override
	public String toString() {
//		return "Tramp [name=" + name + ", num=" + num + ", simbol=" + simbol + "]";
		return "" + this.name;
//		return "" + this.num;
	}
}
