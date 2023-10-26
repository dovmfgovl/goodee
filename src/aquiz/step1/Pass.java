package aquiz.step1;

public class Pass {
	static int x = 5; //main에서 선언된 지역변수 5->6
	public static void main(String []args) {
		Pass.doStuff(Pass.x);
		System.out.print("main x = "+ Pass.x); //6
	}
	static void doStuff(int x) {
		//++가 앞에 있으면 출력하기 전에 먼저 1을 증가하고 그 다음에 출력함
		System.out.println("doStuff x = "+ ++Pass.x); //x를 증가시키기전에 출력한다.
		
	}
}
