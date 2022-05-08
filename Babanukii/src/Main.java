import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scan = new Scanner(System.in);//スキャナー用意
		Random rand = new Random();//ランダム用意
		//ファイル読み込み
		FileInputStream fis = new FileInputStream("tranp.csv");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		List<String[]> list = new ArrayList<>();
		while((line=br.readLine()) != null) {
			list.add(line.split(","));
		}
		br.close();

		//参加者の用意
		Player my = new Player("自分");
		Player pc = new Player("PC");
		
		//トランプ用意
		List<Tramp> tramps = new ArrayList<>();//山札用
		String[] simbols = {"♡","♧","♤","♢"};//マーク
		//各マーク毎、13枚ずつトランプ用意
		for(String s:simbols) {//マークの種類文ループ
			for(String[] ss:list) {//読み込んだデータの行数分ループ
				//ss[0]:英数字表記、ss[1]:数字表記,s:マーク
				Tramp t = new Tramp(ss[0],Integer.parseInt(ss[1]),s);
				tramps.add(t);
			}
		}
		Tramp joker = new Joker();
		tramps.add(joker);//ジョーカー用意

		//トランプをそれぞれに配る
		System.out.println("トランプを配ります");
		while(true) {
			//自分に一枚配る,PCに一枚配る
			//山札が無くなったら配布終了(break)
			if(giveTramp(tramps,my) || giveTramp(tramps,pc))break;
		}
		Thread.sleep(1000);
		//数字が同じのトランプを捨てる
		System.out.println("手札でペアになるトランプを捨ててます");
		removeTramp(my,false);
		removeTramp(pc,false);
		Thread.sleep(1000);
		
		//ババ抜き開始
		while(true) {
			//相手の手札表示
			System.out.println("-----------------------------------");
			System.out.print("PCの手札:[");
			for(int i=0;i<pc.tramps.size();i++) {
				System.out.print("?");
				if(i<pc.tramps.size()-1)System.out.print(", ");
			}
			System.out.println("]");

			//自分の手札表示
			System.out.println("自分の手札"+ my.tramps);
			System.out.println("-----------------------------------");
			
			//自分の番
			System.out.print("どれを引く？(左から何番目か)>>");
			int num = scan.nextInt()-1;
			drawTramp(my,pc,num);
			Thread.sleep(1000);
			if(my.tramps.size() == 0) {
				System.out.println( "あなたの勝ち！！");
				break;
			}
			System.out.println();
			//相手の番
			num = rand.nextInt(my.tramps.size());
			drawTramp(pc,my,num);
			Thread.sleep(1000);
			if(pc.tramps.size() == 0) {
				System.out.println("あなたの負け・・・");
				break;
			}
			System.out.println();
		}
	}
	//メインメソッドはここまで、下は自作メソッド
	//トランプを一枚配る
	static boolean giveTramp(List<Tramp> tramps,Player p) {
		Random rand = new Random();
		if(tramps.size()<=0)return true;//山札が無くなったらtrue
		int trampNum = rand.nextInt(tramps.size());//山札から配るトランプを決める
		p.tramps.add(tramps.get(trampNum));//プレイヤーにトランプ渡す
		tramps.remove(trampNum);//山札から渡したトランプを消す
		return false;
	}
	//数字が同じトランプをペアにして捨てる
	static void removeTramp(Player p) {
		removeTramp(p,true);
	}
	static void removeTramp(Player player,boolean b) {
		for(int i=0;i<player.tramps.size()-1;i++) {
			for(int j=i+1;j<player.tramps.size();j++) {
				if(player.tramps.get(i).num == player.tramps.get(j).num) {
					if(b)System.out.println("揃った！！");
					player.tramps.remove(i);//ペアの一枚目捨てる
					player.tramps.remove(j-1);//ペアの二枚目捨てる
					i=-1;//一番の左のトランプからまた見ていく
					break;
				}
			}
		}
	}
	//相手の手札を引く
	static void drawTramp(Player my,Player you,int num) {
			Tramp tramp = you.tramps.get(num);
			System.out.println(my.name + "は" + tramp.name + "を引いた");
			you.tramps.remove(num);
			my.tramps.add(tramp);
			removeTramp(my);
	}
}
