package day5;
public class BallApp {
	public static void main(String[] args) {
		int n = 5;
		for(int i=0;i<n+1;i++) {
			for(int j=i+1;j<n+2;j++) {
//				System.out.printf("%d,%d%n",i,j);
				for(int k=0;k<n+2;k++) {
					if(k<i) {
						System.out.print("R");
					}else if(k==i || k == j) {
						System.out.print("|");
					}else if(k>j) {
						System.out.print("B");
					}else {
						System.out.print("G");
					}
				}
				System.out.println();
			}
		}
	}
}
