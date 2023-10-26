package com.step2;

public class SungJuk {
	/************************************************
	 * 총점을 구하는 메소드를 구현하기
	 * @param no1 - 첫번째 학생의 점수입니다.
	 * @param no2 - 두번째 학생의 점수입니다.
	 * @param no3 - 세번째 학생의 점수입니다.
	 * @return
	*********************************************** */
	//총점을 구하는 메소드를 선언해보시오.
	public int total(int no1, int no2, int no3) {
		return no1+no2+no3;
	}
	//평균을 구하는 메소드를 구현하시오.
	//단, total 메소드의 반환값으로 총점을 가져와서 처리해볼 것.
	//왜냐면 그래야 전역변수, 지역변수, 정적변수에 대해서 뭔가 뚜렷해질 수 있습니다.
	
	//위 총점을 구하는 메소드의 리턴타입으로 총점을 받아 평균을 구하는 메소드를 선언해보시오.
	public double aver(int total) {
		return total/3; //3으로 하면 안됨!!! double이니까 타입 맞춰 3.0으로 하자!!
	}
	
	//선생님꺼
	public double avg() {
		int result = total(75, 85, 85); //인스턴스화 안해도 됨 - 메인메소드 아니니까. non-static메소드에서 non-static메소드 가져오는 건 합법 //240
		System.out.println("avg메소드 호출 성공");
		return result/3.0;
	}
	
	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		int tot = sj.total(75, 80, 85);
		System.out.println(tot);
		double value = sj.aver(tot);
		System.out.println(value);
		
		//선생님꺼 - avg 메소드 호출해볼까?
		double result = sj.avg();
		System.out.println(result);
	}

}
//3학생 중간고사 성적 입력 받아서 총점과 평균 구하는 메소드 설계하시오. 