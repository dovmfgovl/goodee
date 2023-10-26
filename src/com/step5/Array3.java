package com.step5;

public class Array3 {

	public static void main(String[] args) {
		int is[] = new int[3];
		System.out.println(is[1]); //0
		for(int i = 0; i<=is.length; i++) { //<=을 해놔서 결국 터짐....그러므로 DeptManager에서 0으로 값 정함
			System.out.println(is[i]);
		}
	}

}
