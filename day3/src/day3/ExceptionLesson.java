package day3;

import java.io.FileWriter;

public class ExceptionLesson {
	public static void main(String[] args) throws InterruptedException {
		try(FileWriter fw = new FileWriter("data2.txt");) {
			fw.write("data2");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		}

		//Thread.sleep
		sleep();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		sleep();

		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException例外をcatchしました");
			System.out.println("--スタックトレースは(ここから)--");
			e.printStackTrace();
			System.out.println("--スタックトレースは(ここまで)--");
		}

		try {
			int num = Integer.parseInt("三");
		} catch (NumberFormatException e) {
			System.out.println("不正な引数です");
			e.printStackTrace();
		}
	}
	static void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
}