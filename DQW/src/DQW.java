import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DQW {
	public static void main(String[] args) {
		final Scanner SC = new Scanner(System.in);
		Map<Card, Integer> cards = new LinkedHashMap<>() {
			{
				put(new Card('S', 3, 240), 0);
				put(new Card('A', 5, 48), 0);
				put(new Card('B', 10, 12), 0);
				put(new Card('C', 30, 3), 0);
				put(new Card('D', 52, 1), 0);
			}
		};
		System.out.println("合成シミュレーター");
		while(true) {
			String[] menus = {
					"カードを引く",
					"カードを合成する",
					"カードをセットする",
					"シミュレーションする",
					"終了"
					};
			for(int i=0;i<menus.length;i++) {
				System.out.printf("%d:%s%n",i,menus[i]);
			}
			System.out.print(">>");
			int select = SC.nextInt();
			switch(select) {
			case 0:
				Card c = drawCards(cards);
				System.out.println(c.rank + "が出ました!");
				cards.put(c, cards.get(c) + 1);
				showCards(cards);
				break;
			case 1:
				System.out.println("合成しました");
				synthesizeCards(cards);
				showCards(cards);
				break;
			case 2:
				System.out.println("カードを任意枚数にセットします\n"
						+ "0,2,1,3,4 のように\n"
						+ "カンマ区切りでS,A,B,C,Dの枚数を入力してください");
				System.out.print(">>");
				String[] numArr = (SC.next()).split(",");
				int[] cardCounts = new int[numArr.length];
				for (int i = 0; i < cardCounts.length; i++) {
					cardCounts[i] = Integer.parseInt(numArr[i]);
				}
				setCards(cards, cardCounts);
				System.out.println("指定枚数でセットしました");
				showCards(cards);
				break;
			case 3:
				System.out.println("現在の状況からSが指定枚数できるまでの回数をシミュレーションします");
				System.out.print("Sの必要枚数を入力>>");
				int sCount = SC.nextInt();
				System.out.print("シミュレーション回数を入力>>");
				int tryCount = SC.nextInt();
				simulator(cards, sCount, tryCount);
				break;
			case 4:
				System.out.println("終了");
				return;
			}
		}
	}

	//手持ちのカード枚数
	static void showCards(Map<Card, Integer> cards) {
		for (Card card : cards.keySet()) {
			System.out.printf("%s(%d)", card.rank, cards.get(card));
		}
		System.out.println();
	}

	//カードを引く
	static Card drawCards(Map<Card, Integer> cards) {
		Card card = null;
		int n = (int) (Math.random() * 100);
		for (Card c : cards.keySet()) {
			if (n - c.ratio < 0) {
				card = c;
				break;
			}
			n -= c.ratio;
		}
		return card;
	}

	//カードを合成
	static void synthesizeCards(Map<Card, Integer> cards) {
		int totalPoint = 0;
		//Mapを回しながら合計ポイントに加算していく
		for (Card c : cards.keySet()) {
			totalPoint += c.point * cards.get(c);
		}
		//合計ポイントを元にSから順に合成後のカード枚数を更新していく
		for (Card c : cards.keySet()) {
			cards.put(c, totalPoint / c.point);
			totalPoint = totalPoint % c.point;
		}
	}

	//カード枚数をランクごとに指定数セットする
	static void setCards(Map<Card, Integer> cards, int[] cardCount) {
		int idx = 0;
		for (Card c : cards.keySet()) {
			cards.put(c, cardCount[idx++]);
		}
	}
	//合成シミュレーター
	static void simulator(Map<Card,Integer> cards,int sCount,int tryCount) {
		int nowPoint = 0;//現在のトータルポイント集計用変数
		//MAPをループさせて、それぞれのカードポイント保持枚数をトータルポイントに加算
		for(Card c:cards.keySet()) {
			nowPoint += cards.get(c);
		}
		//すでに合成に必要な枚数が揃っている時はメッセージを表示して抜ける
		if(nowPoint >= sCount*240) {
			System.out.println("カードを引く必要はありません");
			return;
		}
		//Map<揃った回数,それが何回か>を保持するMap作成
		Map<Integer,Integer> result = new TreeMap<>();
		//試行回数分ループ
		for(int i=0;i<tryCount;i++) {
			int count = 0;//回数保持
			int tempPoint = nowPoint;//現在保有ポイントを退避
			//必要な合成ポイントに達するまで繰り返す
			while(tempPoint < sCount*240) {
				count++;
				Card card = drawCards(cards);
				tempPoint += card.point;
			}

			//ここに到達したということは必要な合成ポイントが揃ったということ
			//その回数はMapに含まれているか
			if(result.containsKey(count)){
				//含まれていたらその回数を1増やす
				result.put(count, result.get(count)+1);
			}else {
				//そうでなかったら1回目
				result.put(count, 1);
			}
		}
		//ここから集計、表示処理
		int total = 0;
		for(int key:result.keySet()) {
			System.out.printf("%3d(%3d):",key,result.get(key));
			total += key*result.get(key);
			for(int i=0;i<result.get(key);i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.printf("平均:%.1f回%n",total/(double)tryCount);
	}
}

class Card {
	Character rank;
	int ratio;
	int point;

	Card(Character rank, int ratio, int point) {
		this.rank = rank;
		this.ratio = ratio;
		this.point = point;
	}
}