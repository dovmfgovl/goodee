package com.step3;

import java.util.Random;
import java.util.Scanner;

public class RandomGameExam {
	int dap = -1;
	
	public void newGame() {
		Random r = new Random();
		dap = r.nextInt(10);
	}
	
	public String account(int user) {//user = 5			
		System.out.println("dap : " + dap + ", user : " + user);
		String hint = null;
		if(dap == user) {
			hint = "정답입니다.";
		} else if(dap > user) {
			hint = "높여라.";
		} else if(dap < user) {
			hint = "낮춰라.";
		}
		return hint;
	}
	
//	public void message(int user) {
//		System.out.println(account(user));
//	}	
	
	public static void main(String[] args) {
		RandomGameExam rge = new RandomGameExam();
		rge.newGame();	
		//5번 이내에 숫자를 맞히면 성공 출력 후 for문 종료. 5번 만에 맞히지 못하면 실패 출력.
		Scanner sc = new Scanner(System.in);
		int i;
		for(i = 0; i < 5; i++) {
			System.out.println("0~9 숫자 중 값을 입력하세요.");
			int user = sc.nextInt();//3
			String hint = rge.account(user);
		
			if("정답입니다.".equals(hint)) {
				System.out.println("축하합니다.");
				break;//for문을 벗어난다
			} 
			//rge.message(i);
		}//end of for
		System.out.println("for탈출");
		if(i==5) {
			System.out.println("실패");			
		}
	}

}
/*
0~9사이 임의의 숫자를 채번하고
사용자로부터 숫자를 입력받아
입력받은 숫자가 더 작으면 '힌트를 높여라' 라고 출력하고
더 크면 낮춰라 라고 힌트를 주어
5번까지만 기회를 제공해서 그 숫자를 맞추는 게임을 작성해 보시오.

새게임을 선택했을 때는 0~9사이에 새로운 숫자를 채번해야 합니다.
채번한 숫자는 dap이라는 변수에 저장해 둡시다(힌트를 줘야하니까).
그리고 전역변수로 하는 것이 좋겠습니다. 
왜냐면 그 게임을 하는 그 사람이 사용하는 동안에는 오직 하나의 객체만 사용하게 될테니까요(답은 하나니까. 정답보기, 종료 전까지 유지돼야하니까).
*/