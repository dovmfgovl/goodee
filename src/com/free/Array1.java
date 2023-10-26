package com.free;

public class Array1 {
	public static void main(String[] args) {
		int score[][] = {{77, 80, 54}, {98, 80, 66}};
		System.out.println(score.length); //2 출력
		System.out.println(score[0].length); //3 출력
		System.out.println(score[1].length); //3 출력
		
		for(int x=0; x<score.length; x++) {
			for(int y=0; y<score[x].length; y++) {
				System.out.println("is[" +x+ "][" +y+ "] = " +score[x][y]);
			}
		}
 	}

}
