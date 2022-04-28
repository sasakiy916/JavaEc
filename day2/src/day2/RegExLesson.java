package day2;
public class RegExLesson {
	public static void main(String[] args) {
		String s = "Java,Jav:Javv";
		if(s.matches("Java")) {
			System.out.println("Match");
		}
		if(s.matches("J.va")) {
			System.out.println("Match");
		}
		if("Jaaaaaaaaaaaaaaaaaaaaaava".matches("Ja*va")) {
			System.out.println("Match");
		}
		if("あいうxx019".matches(".*")) {
			System.out.println("Match");
		}
		if("3r9".matches("[a-z0-9]{3}")) {
			System.out.println("eMatch");
		}

		//splitメソッド使用
		String[] words = s.split("[,:]");
		for(String w : words) {
			System.out.print(w + "->");
		}
		String w = s.replaceAll("[aJv]", "X");
		System.out.println(w);
		Method(1,2,3,4,5);
		int sum = sumOf(1,2,3,4,5);
		System.out.println(sum);
	}
	public static void Method(int...args) {
		for(int i:args) {
			System.out.println(i);
		}
	}

	public static int sumOf(int n,int...args) {
		int sum =n;
		for(int i:args) {
			sum += i;
		}
		return sum;
	}
}
