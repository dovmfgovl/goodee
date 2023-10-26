package com.week1;
class getS1{
	String name = "나신입";
		int html = 85;
		int css = 70;
		int java = 75;
		int plus1;
		double avr1;
		void hap1() {
			int plus1 = html + css + java;
			this.plus1 = plus1;
			double avr1 = plus1/3.0;
			this.avr1 = avr1;
		}
}
class getS2{
	String name = "나일등";
	int html = 90;
	int css = 85;
	int java = 80;	
	int plus2;
	double avr2;
	void hap2() {
		int plus2 = html + css + java;
		this.plus2 = plus2;
		double avr2 = plus2/3.0;
		this.avr2 = avr2;
	}
}
class getS3{
	String name = "홍길동";
	int html = 70;
	int css = 75;
	int java = 75;	
	int plus3;
	double avr3;
	void hap3() {
		int plus3 = html + css + java;
		this.plus3 = plus3;
		double avr3 = plus3/3.0;
		this.avr3 = avr3;
	}
}
	
public class StudentSimulation {
	public static void main(String[] args) {
		getS1 s1 = new getS1();
		s1.hap1();
		System.out.println(s1.name + " 성적의 총점은 " + s1.plus1 + "이고, 평균은 " + s1.avr1 + "이다.");
		getS2 s2 = new getS2();
		s2.hap2();
		System.out.println(s2.plus2);
		System.out.println(s2.name + " 성적의 총점은 " + s2.plus2 + "이고, 평균은 " + s2.avr2 + "이다.");
		getS3 s3 = new getS3();
		s3.hap3();
		System.out.println(s3.plus3);
		System.out.println(s3.name + " 성적의 총점은 " + s3.plus3 + "이고, 평균은 " + s3.avr3 + "이다.");
	}

}
