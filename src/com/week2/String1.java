package com.week2;

public class String1 {

	public static void main(String[] args) {
		String s1 = "안녕";
		String s2 = "안녕";
		String s3 = new String("안녕");
		String s4 = new String("안녕");
		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //false
		System.out.println(s1.equals(s3)); //true
		System.out.println(s1 == s4); //false
		System.out.println(s1.equals(s4)); //true
	}

}
