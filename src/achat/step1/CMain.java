package achat.step1;
class C{
	int i;
	C(C1 c1){
		System.out.println("C : "+c1);
	}
}
class C1{
	//여기서 쓰고 싶다
	C c = new C(this);
	C1(){
		System.out.println("C1 : "+this);
	}
}
public class CMain {

	public static void main(String[] args) {
		 new C1();

	}

} 
