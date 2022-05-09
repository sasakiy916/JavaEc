package day5;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class DiceCompApp {
	static final int PER_PLAY_COST = 300;
	static final int TRIAL_COUNT = 500;
	static final Map<Integer,Integer> map = new TreeMap<>();
	static final Set<Integer> set = new HashSet<>();
	static final Random rand = new Random();
	static final StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		//<何回でコンプしたか、それが何回あったか>を管理するMap
		//TreeMapを使うことでKeyを昇順にしてくる
		Map<Integer, Integer> map = new TreeMap<>();
		//実行例を見ると１回～発生した最大回数まで出力しているのでその最大回数を調べる変数
		int maxThrowCount = 0;
		int totalCost = 0;
		int modeCount = 0;
		int mode = 0;
		for (int i = 0; i < TRIAL_COUNT; i++) {
			//1回ごとのコンプ回数
			int diceThrowCount = diceCompCount();
			totalCost += diceThrowCount * PER_PLAY_COST;
			if (diceThrowCount > maxThrowCount) {
				//もし最大回数が更新されたらmaxThrowCountを更新していく
				maxThrowCount = diceThrowCount;
			}
			//Mapに登録するときの回数用の変数
			int count;
			if (map.containsKey(diceThrowCount)) {
				//再登場ならcountは今までの合計値+1
				count = map.get(diceThrowCount) + 1;
			} else {
				//初登場なら
				count = 1;
			}
			//マップに登録、もしくは更新
			map.put(diceThrowCount, count);
			if(count > modeCount) {
				modeCount = count;
				mode = diceThrowCount;
			}
		}
		//結果表示
		System.out.println("***************************結果*****************************");
		for (int i = 1; i <= maxThrowCount; i++) {
			//マップに含まれているときだけ*を出力する
			System.out.printf("%d(%d):%s%n", i, PER_PLAY_COST * i, map.containsKey(i) ? createStar(map.get(i)) : "");
		}
		System.out.printf("コンプ平均値:%d円%n",totalCost/TRIAL_COUNT);
		System.out.printf("モード(最頻値):%d回(%d円)%n",mode,mode*PER_PLAY_COST);
	}

	//ダイスが6種類揃うまでに振った回数
	static int diceCompCount() {
		int count = 0;
		set.clear();
		while (set.size() < 6) {
			count++;
			int dice = rand.nextInt(6) + 1;
			set.add(dice);
		}
		return count;
	}

	//コンプ回数分の星の生成
	static String createStar(int count) {
		sb.setLength(0);
		for (int i = 0; i < count; i++) {
			sb.append("*");
		}
		return sb.toString();
	}
//	//平均の算出
//	static int calcAvg(Map<Integer,Integer> map) {
//		int totalCount = 0;
//		int sum = 0;
//		for(int compCount:map.keySet()) {
//			totalCount += compCount;
//			sum += compCount * 300 * map.get(compCount);
//		}
//		return sum / totalCount;
//	}
//	//モードの算出(最頻値)
//	static int calcMode(Map<Integer,Integer> map) {
//		int modeKey = 0;
//		int modeValue = 0;
//		for(int compCount:map.keySet()) {
//			if(modeValue < map.get(compCount)) {
//				modeValue = map.get(compCount);
//				modeKey = compCount;
//			}
//		}
//		return modeKey;
//	}
}
