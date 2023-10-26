package aquiz.step1;
//메소드 오버라이딩은 선언부를 건드리지 않는다.
class A {
	public byte getNumber() { //shadow method
		return 1;
	}
}

class B extends A {
//	public short getNumber() {
//		return 2;
//	}
	@Override
	public byte getNumber() {
		return 2;
	}

	public static void main(String args[]) {
//		B b = new B();
//		System.out.println(b.getNumber()); //2 출력. 부모껀 가려짐
		A b = new B();
		System.out.println(b.getNumber()); //2 출력. 부모껀 가려짐. 쉐도우 메소드
	}
}
//자동코드정렬 : ctrl + shift  + f
//D. Compilation fails because of an error in line 10. -> 메소드 오버라이딩 관계 위배 