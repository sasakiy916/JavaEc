package day5;
public class ConbApp {
	public static void main(String[] args) {
		for(int i=1;i<=7;i++) {
			for(int j=i+1;j<=8;j++) {
				for(int k=j+1;k<=9;k++) {
					if(i+j+k == 10) {
						System.out.print(""+i+j+k+" ");
					}
				}
			}
			System.out.println();
		}
	}
}
