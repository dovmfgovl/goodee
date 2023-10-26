package com.step3;

import java.util.Scanner;

//메뉴 선택하기
public class Scan2 {

	public static void main(String[] args) {
		System.out.println("메뉴를 선택하세요.[새 게임: 1, 정답확인: 2, 종료: 3]");
		Scanner sc = new Scanner(System.in);
		//사용자가 선택한 메뉴 번호를 담을 변수 선언
		int menu = 0;
		int i = 0;
		//for(변수선언 및 초기화; 조건식-true or false; 증감연산자);
		for(i = 0; i < 3; i++) {
			System.out.println(i);
			// 당신의 선택은?
			menu = sc.nextInt();
			//너 새 게임을 원해? - 1
			if(menu == 1) { //1==1 같니? -> true 참이다 - 그러면 20 실행하시오.
				System.out.println("새 게임을 선택하였습니다.");
			}
			//뭘 봤니?
			//if문 앞에 else를 빼면 첫번째 조건이 만족했음에도 다음 조건을 일단 따진다.
			//물론 조건의 결과가 false이니까 실행문은 실행되지 않는다.
			//처음 조건을 수렴하면 다음 조건은 굳이 비교할 필요가 없잖아!
			//그러면 정답을 확인하고 싶어? - 2
			if(menu == 2) { //else가 없으면 아래 조건도 따진다 - 일량이 늘어난다
				System.out.println("정답보기를 선택하였습니다.");			
			}
			//그만하고 싶어? - 3
			if(menu == 3) {
				System.out.println("종료를 선택하였습니다.");				
			}///end of if
		}/////end of for
		System.out.println("for문 탈출 - 여기로...");
	}///////end of main
}//////////end of Scan1
/*
	사용자와 개발자 사이의 소통하기
	이것은 화면 구현을 통해서 가능하다.
	우리는 아직 html 공부하지 않고 있어서 콘솔창을 활용한 소통하기 시도
	'화면에서 입력받아야 하는 값들이 파라미터 자리를 채워야 한다.'
	사용자가(업무담당자가) 입력한 값을 받아오기
*/