package jankenn;

import java.util.Random;
import java.util.Scanner;

public class Main extends Sub {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner s = new Scanner(System.in);
		Random r = new Random();

		System.out.println("じゃんけん大会を開催します");
		System.out.println("グー = 0 , チョキ = 1 , パー = 2で入力してください");

		for(int i = 0; i < 10; i++) {

			playerhands(s);
			pchands(r);
			judge(s, r);

		}
		comment(winCount);

		System.out.println("じゃんけん大会を終了します");
	}

	public static void comment(int winCount) {
		if(winCount == 0) {
			System.out.println(winCount + "勝でした。まだまだ...");
		}else if(winCount == 1 || winCount == 2 || winCount == 3) {
			System.out.println(winCount + "勝でした。もう少し頑張ろう");
		}else if(winCount == 4 || winCount == 5 || winCount == 6 || winCount == 7) {
			System.out.println(winCount + "勝でした。あと少し！！");
		}else if(winCount == 8 || winCount == 9) {
			System.out.println(winCount + "勝でした。よく頑張った！！！");
		}else if(winCount == 10) {
			System.out.println("全勝でした！素晴らしい！！");
		}
	}

	public static void playerhands(Scanner s) {
		handSelect = s.nextInt();
		if (handSelect == 0 || handSelect == 1 || handSelect == 2) {
			playerHand = hand[handSelect];
			System.out.println("あなたは"+ playerHand + "です");
		}else {
			System.out.println("もう一度入力してください");
			playerhands(s);
		}

	}

	public static void pchands(Random r) {
		pcHand = hand[r.nextInt(3)];
		System.out.println("相手は" + pcHand + "です");
	}

	public static void judge(Scanner s, Random r) {
		if(pcHand == "グー" && playerHand == "パー" || pcHand == "チョキ" && playerHand == "グー" || pcHand == "パー" && playerHand == "チョキ") {
			System.out.println("あなたの勝ちです");
			winCount++;
		}else if (pcHand == "グー" && playerHand == "グー" || pcHand == "チョキ" && playerHand == "チョキ" || pcHand == "パー" && playerHand == "パー") {
			System.out.println("引き分けです。もう一度");
			playerhands(s);
			pchands(r);
			judge(s, r);
		}else {
			System.out.println("あなたの負けです");
		}
	}


}


