package com.step3;

import java.util.Scanner;

class Baseball{
	//게임 숫자 3자리를 각각 하나의 배열에 담아 랜덤으로 출력되도록 함.
	int[] gameNum = new int[3];
	public void newGame() {
		for(int i=0; i<gameNum.length; i++) {
		gameNum[i] = (int)(Math.random()*9);
		System.out.println(gameNum[i]);
		}
	}
	//게임 숫자와 사용자 입력 숫자 간의 결과를 알려주는 메소드 선언
	public void gameResult(int[] userNum) {
		int strike = 0;
		int ball = 0;
		for(int i=0; i<gameNum.length; i++) {
			for(int j=0; j<userNum.length; j++) {
				if(gameNum[i] == userNum[j] && i == j) {
					++strike;
				}else if(gameNum[i] == userNum[j] && i != j) {
					++ball;				
				}
			}
		}
		System.out.println(strike + "S " + ball + "B 입니다.");
	}
}

public class BaseballGame {
	
	public static void main(String[] args) {
		Baseball bb = new Baseball();
		//숫자 3자리가 랜덤으로 출력되도록 함.
		bb.newGame();
		//배열 3개를 선언
		int[] userNum = new int[3];
		//사용자가 숫자 입력하도록 for문 사용
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<userNum.length; i++) {
			System.out.println("3자리 숫자를 입력하세요(숫자 하나씩 누르고 엔터).");
			userNum[i] = sc.nextInt();		
			//gameResult 메소드의 파라미터에 userNum을 복사
			bb.gameResult(userNum);
		}
	}

}

/*<0~9사이의 숫자를 맞히는 게임 구현하기>
<3자리 숫자를 맞히는 게임 구현하기>
야구 숫자 게임 검색
strike를 전변으로 할까? 아님 지변으로 해야 하나?
ball 변수 선언
<학습목표>
변수의 갯수 결정할 수 있다|없다.
변수의 타입을 결정할 수 있다|없다.
*화면을 제공받았을 때도 코드의 재사용성을 누릴 수 있도록 메소드 설계가 되었는가? - 자가진단
파라미터의 타입과 리턴타입까지도 나는 결정할 수 있고 활용할 수 있는가.
257 정답
329: 0스 1볼
529: 0스 2볼
259: 2스 0볼
*/