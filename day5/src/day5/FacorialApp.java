package day5;

public class FacorialApp {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(factorial1(num));

	}

	static int factorial(int n) {
		int r = n;
		for (int i = n - 1; i > 0; i--) {
			r *= i;
		}
		return r;
	}

	//recursive(再帰処理)
	static int factorial1(int n) {
		if (n == 1) {
			return n;
		}
		return n * factorial1(n - 1);
	}

}
