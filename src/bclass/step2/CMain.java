package bclass.step2;
class C{
	CMain cm = null; //= new CMain : 여기서 인스턴스화 바로 해버리면 스택메모리오버플로우 익셉션이 발생함!!
	public C(CMain cMain) { //리턴타입이 없지만 setter꼴처럼 재정의 통해서 원본 유지함
		//System.out.println(cm); //null 출력
		this.cm = cMain; //치환
		System.out.println(cm); //주소번지 출력
		//System.out.println(cm == cMain); //true - 증명끝 : 같은 걸 쥐고 있다.
	}
	
}
public class CMain {
	C c = new C(this);
	public static void main(String[] args) {
		CMain cm = new CMain();
		System.out.println("before : " + cm); //주소번지 출력
		cm = new CMain();
		System.out.println("after : "+ cm); //주소번지 출력
	}

}
