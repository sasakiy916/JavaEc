package day5;

public class BallApp2 {

	public static void main(String[] args) {
		int n=5;
		System.out.println(" R G B");
		for(int i=0;i<n+1;i++) {
			int rCount=i;
			for(int j=i+1;j<n+2;j++) {
				int bCount = j-rCount-1;
				int gCount = n-rCount-bCount;
				System.out.printf("[%d,%d,%d]%n",rCount,bCount,gCount);
			}
		}
	}

}
