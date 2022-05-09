package tarotto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);//スキャナー用意
		Random rand = new Random();//ランダム用意
		//ファイル読み込み
		FileInputStream fis = new FileInputStream("タロット - シート1.csv");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		List<String[]> list = new ArrayList<>();
		while((line=br.readLine()) != null) {
			list.add(line.split(","));
		}
		br.close();

		List<Card> cards = new ArrayList<>();
		for(String[] card:list) {
			cards.add(new Card(card[0],card[1]));
		}

		System.out.println("適当な二枚のカードを選んでください");
		for(int i=0;i<2;i++) {
			int select = rand.nextInt(cards.size());
			System.out.println((select+1) + "枚目のカード");
			Card card = cards.get(select);
			cards.remove(select);
			System.out.println(card);
		}
	}
}
