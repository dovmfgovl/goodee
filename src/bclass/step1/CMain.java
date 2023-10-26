package bclass.step1;
class C1{
	int i;
}
class C2{
	
}
public class CMain {
	//c1은 C1 타입이고 아직 생성되지 않았다. 선언만 함. 아직 인스턴스화 안함.
	C1 c1 = null; //타입이 결정된 것도 아님
	public static void main(String[] args) {
		CMain cm = new CMain();
		cm.c1 =new C1(); //생성 
		System.out.println(cm.c1); //null
		System.out.println(cm.c1 instanceof C1); //false -> true (cm.c1 = new C1(); 인스턴스화로 생성을 해줬음으로 타입이 결정됨)
		System.out.println(cm.c1.i); //NullPointerException 발동됨 //CMain을 인스턴스화 한 것이지 C1을 인스턴스화 하지 않았으므로 int i; 는 모르는 값이다. -> 0
		System.out.println(cm.c1.i+2); //2
		System.out.println("main");
	}
}/////////end of CMain
