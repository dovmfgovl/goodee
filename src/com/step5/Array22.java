package com.step5;

public class Array22 {

	public static void main(String[] args) {
		String datas[][] = {
				{"나신입", "70", "80", "90"}
				,{"나초보", "60", "70", "80"}
				,{"나일등", "80", "90", "90"}
		};
		//2차 배열의 앞자리는 층수
		for(int x=0; x<datas.length; x++) { //****2차 배열에서 length는 row를 뜻함(js에서 활용빈도 높음)****
			for(int y=0; y<datas[x].length; y++) { //****[x]는 컬럼을 뜻함. 컬럼의 종류. y는 컬럼의 종류이다.****
				System.out.println("datas[" +x+ "][" +y+ "] = " +datas[x][y]);
			}
		}
	}

}
