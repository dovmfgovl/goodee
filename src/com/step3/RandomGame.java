package com.step3;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class RandomGame {
	//선언부
	//새로 채번된 숫자를 담는다 - 정답이다
	int dap = -1; //-1은 end of file : '찾아도 없다'는 의미(0은 답 중 하나니까 0~9가 아닌 -1을 적음).
	//사용자가 입력하는 숫자는 절대로 전역변수로 하지 않는다. - 매번 입력할 때 마다 바뀌어야하니까
	//게임을 하는데 필요한 메소드
	//새 게임을 누를 때 마다 호출되는 메소드
	//여기서 채번되는 숫자가 정답이므로 노출하지 않는다. - 그래서 나는 전역변수로 선언하였다.
	public void newGame() {
		Random r = new Random();
		//리턴 타입이 없어도 전역변수면 어떠한 메소드에서도 재정의가 가능하다.
		dap = r.nextInt(10); // 정답이 결정되었다 - 답이 수시로 변경되면 안된다 - 유지되어야 한다 - 종료될때까지
	}
	//판정을 내려주는 메소드를 선언해보자. 
	/**************************************************************************************
	 * 판정을 내려주는 메소드 구현하기
	 * @param user - 사용자가 숫자를 맞추기 위해 입력하는 값을 담는 변수이다. - 입력할 때마다 바뀐다. - 지역변수
	 * @return - String - 힌트를 반환한다(예시: 높여라, 낮춰라, 정답입니다, 축하합니다)
	 **************************************************************************************/
	public String account(int user) { //user -> 매번 화면에 사용자가 입력하고 엔터 쳤을 때 결정되는 값이다.
		System.out.println("dap : " + dap + ", user : " + user);
		String hint = null;
		if(dap == user) {
			hint = "정답입니다.";
		} else if(dap > user) { //사용자가 입력한 값이 정답보다 작으면 높여라를 반환해준다.
			hint = "높여라.";
		} else if(dap < user) { //사용자가 입력한 값이 정답보다 크면 낮춰라는 반환해준다.
			hint = "낮춰라.";
		}
		return hint; 
	}
	//메소드 파라미터 자리에 리턴타입이 존재하는 메소드를 호출할 수 있다. - 는 것을 보여주기 위해 추가한 것!
//	public void messagePrint(int user) { //user = 5복사됨 - call by value
//		System.out.println(account(user)); // 24번째로 -> 5를 쥐고 간다 -> 높여라 출력
//	}
	public static void main(String[] args) {
		RandomGame rg = new RandomGame(); // F6
		rg.newGame(); // 이 메소드가 호출되어야 0부터 9사이의 숫자가 채번된다. 그래서 채번된 숫자는 dap에 담김
		// messagePrint 호출할 때 파라미터 자리에 5를 넘겨주고 37번에서 account() 호출될 때 지역변수에 복사된 user값
		//즉 5가 파라미터로 넘어간다.
		//24번에서도 user값은 5가 된다.
		//rg.account(5);
		Scanner sc = new Scanner(System.in); //java.util.Scanner
		for(int i = 0; i < 5; i++) {
			System.out.println("0~9 사이의 숫자를 입력하세요.(입력하면 엔터치기");
			int user = sc.nextInt(); //초기화가 5번 반복된다 - 덮어쓰기가 된다. - 맨 마지막에 덮어씌워진 값만 유지된다.
			String hint = rg.account(user); //메소드를 따라가서 추적할 땐 F5
			if(hint.equals("정답입니다.")) {
				System.out.println("축하합니다.");
				break; //for문 탈출하기
			}
			//insert here
			else if(hint.equals("높여라.")) {
				System.out.println("더 큰 숫자를 입력하세요.");
			}
			else if(hint.equals("낮춰라.")) {
				System.out.println("더 작은 숫자를 입력하세요.");
			}
		}////////////////////////////end of for
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