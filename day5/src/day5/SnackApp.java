package day5;

public class SnackApp {
	public static void main(String[] args) {
		Snack[] snacks = {
				new Snack("アメ", 30),
				new Snack("チョコ", 120),
				new Snack("ガム", 100),
				new Snack("ポテチ", 80),
				new Snack("ビスケット", 90),
		};
		//		//重複なし
		//		for(int i=0;i<snacks.length-1;i++) {
		//			for(int j=i+1;j<snacks.length;j++) {
		//				if(snacks[i].price+snacks[j].price <= 200) {
		//					System.out.printf("[%s,%s]%n",snacks[i],snacks[j]);
		//				}
		//			}
		//		}
//		//重複あり
		int count = 0;
//		for (int i = 0; i < snacks.length; i++) {
//			for (int j = i + 1; j < snacks.length + 1; j++) {
//				if (snacks[i].price + snacks[j - 1].price <= 200) {
//					System.out.printf("[%s,%s]%n", snacks[i], snacks[j - 1]);
//				}
//			}
//		}
		for (int i = 0; i < snacks.length; i++) {
			for (int j = i + 1; j < snacks.length + 1; j++) {
				for (int k = j + 1; k < snacks.length + 2; k++) {
					count++;
					if (snacks[i].price + snacks[j - 1].price + snacks[k - 2].price <= 300) {
						System.out.printf("[%s,%s,%s]%n", snacks[i], snacks[j - 1], snacks[k - 2]);
					}
				}
			}
		}
		System.out.println(count);
		count = 0;
		for (int i = 0; i < snacks.length; i++) {
			for (int j = i; j < snacks.length; j++) {
				for (int k = j; k < snacks.length; k++) {
					count++;
					if (snacks[i].price + snacks[j].price + snacks[k].price <= 300) {
						System.out.printf("[%s,%s,%s]%n", snacks[i], snacks[j], snacks[k]);
					}
				}
			}
		}
		System.out.println(count);
	}
}

class Snack {
	String name;
	int price;

	Snack(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s(%d)", this.name, this.price);
	}
}