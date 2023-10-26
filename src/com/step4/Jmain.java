package com.step4;
class J{
	//선언부
	int a;
	//왜 빨간색인가? 파라미터를 갖는 생성자는 JVM이 추측 불가함.
	Jmain jm = new Jmain(this);
	J(){} //디폴트생성자는 파라미터가 없으니까 생략해도 JVM이 제공해줌
}
public class Jmain {
	int b;
	J j = null;
	Jmain(){
		//텅텅 빈 깡통이다 - 아무런(전역변수 j, b) 초기화도 하지 않았다.
	}
	Jmain(J j){ //생성자도 파라미터 자리를 갖는다. 파라미터 자리에 참조형을 넘길 수 있다.
		this.j = j;
		this.b = 10;
	}
	void methodA() {
		//파라미터로 넘어온 원본을 쓰고 싶다. 어떡하지?
		//원본이 뭘 의미하나요? - J가 Heap메모리 영역에 활성화 됐을 때 그 주소번지
		System.out.println(j);
	}
	public static void main(String[] args) {
		J j = new J();
		Jmain jm = new Jmain(j);
		//jm = new Jmain(); //생성자가 두 번 호출되는데 자바에서는 메소드오버로딩 컨벤션이라서 같은 이름이더라도 다른 생성자로 인식한다.
		System.out.println(jm.b); //0 - 디폴트생성자 호출되면 0 출력, 파라미터를 가진 생성자 호출되면 10 호출됨.
		jm.methodA(); //null이 출력될 것이다. 왜냐면 14번 this.j = j;를 경유하지 않았으니까
	}

}
