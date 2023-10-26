package com.step3;
//1부터 10까지의 합을 구하는 프로그램을 작성하시오.
//1. 변수는 몇 개가 필요한가요?
//2. 지변으로 할까? 아님 전변으로 할까? 아님 둘 다 다 된다?
//3. 타입은 뭘로 하지?
public class For2 {

	public static void main(String[] args) {
		int i = 0;
		int hap = 0; // 2를 주면 답에 영향이 있다. - 초기화 위치, 값 정확히 해야함
		//for(초기화; 조건식; 증감연산자) {
		for(i= 1; i <= 10; i++) {
			hap += i;
			//여기서 출력하면 답이 1, 3, 6, 10, 15 이런 식으로 나옴.. 그러므로 중괄호 바깥에서 출력
			System.out.println(i + "," + hap);
		}
		//System.out.println(i); // 11
		System.out.println(hap);
		
		hap = 0; //초기화 위치 선정이 중요하다. 여기서 초기화 하지 않으면 위 for문 값에서 아래 for문 값이 더해져 출력된다.
		for(i= 1; i <= 5; i++) {
			hap += i;
		}
		System.out.println(hap);
	}

}
