package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Score {
	public static void main(String[] args) throws Exception {
		//準備
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		String path = "src/day2/score.txt";
		String scoreLine = reader(path);
		String[] lines = new String[3];
		int preScore = 0;
		String gameTxt = "HighScore 0";
		String result = "";
		if(scoreLine != null) {
			lines = scoreLine.split(" ");
			preScore = Integer.parseInt(lines[1]);
			gameTxt = scoreLine;
		}

		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
		//ゲーム
		System.out.println("****乱数ゲーム****");
		System.out.printf("%s%n",gameTxt);
		int highScore = preScore;
		while (true) {
			System.out.print("やりますかyes…y no…n>");
			String play = scan.next();
			int score = 0;
			if (play.equals("y")) {
				score = rand.nextInt(100000) + 1;
				System.out.println(score);
				if (score > highScore) {
					highScore = score;
					System.out.println("new Record");
					Date now = new Date();
					String date = f.format(now);
					result = "HighScore " + highScore + " "+ date;
					writer(path, result);
				}
			} else {
				if(result.equals("")) {
					writer(path, result);
				}
				System.out.println("アプリを終了します");
				return;
			}

		}
	}

	static String reader(String path) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		if((line = br.readLine())==null) {
			line = null;
		}
		br.close();
		return line;
	}

	static void writer(String path, String line) throws Exception {
		FileOutputStream fos = new FileOutputStream(path);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.append(line);
		bw.close();
	}
}
