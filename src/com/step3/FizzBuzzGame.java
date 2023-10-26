package com.step3;
//변수는 몇 개가 필요하지? - 5의 배수 x, 7의 배수y
//변수의 타입은 뭘로 할까요?
//for문 안에 if문이 오는거야?
//조건을 따질 때 fizz를 먼저 따져야 하나?
//아니면 fizzbuzz인 경우 즉, 5와 7의 공배수를 먼저 따져야 하는지? - 결과에 영향이 있다
//---->35는 5로 나누어 나머지가 0인지를 먼저 비교하면 fizz를 출력하므로 원하는 결과가 아니다.
//				조건을 따질때도 순서가 결과에 영향을 미친다.
class FizzBuzz{
	void number() {
		int i = 0;
		for(i = 1; i <= 100; i++ ) {
			if(i % 5 == 0 & i % 7 == 0) {
				System.out.println("fizzbuzz");
			} else if (i % 5 == 0) {
				System.out.println("fizz");
			} else if (i % 7 == 0) {
				System.out.println("buzz");
				//5의 배수도 아니고 7의 배수도 아니고 또 35의 배수도 아닐때만 출력한다.
			} else {
				System.out.println(i);
			}
		}	
	}
}

public class FizzBuzzGame {
	public static void main(String[] args) {
		FizzBuzz fizzbuzz = new FizzBuzz();
		fizzbuzz.number();
	}
}	
	
//fizzbuzz게임 구현해보기(5의 배수에 fizz, 7의 배수에 buzz, 5와 7의 공배수(35)일 때는 fizzbuzz)
// 1 2 3 4 fizz 6 buzz 8 9 fizz 11 12 13 buzz	
