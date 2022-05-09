package day5;
import java.util.Scanner;
public class TileApp {
	static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("縦>>");
		int height = scan.nextInt();
		System.out.print("横>>");
		int width = scan.nextInt();
		int area = height*width;
		int sideLength = GCD(height,width);
		int tileArea = sideLength * sideLength;
		System.out.printf("1辺が%dのタイルを%d枚で埋めます%n",sideLength,area/tileArea);
	}
	static int tile(int height, int width) {
		int r = 0;
		while (true) {
			if (height > width) {
				height = height - width;
				r = height;
			}else if(height < width) {
				width = width - height;
				r = width;
			}else {
				return r;
			}
		}
	}
	static int GCD(int x,int y) {
		if(x%y==0) {
			return y;
		}
		return GCD(y,x%y);
	}
}
