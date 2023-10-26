package bclass.step1;
class D1{
	//DMain에서 선언된 변수를 굳이 methodA에서 사용하고 싶다.
	//어떡하지? - 파라미터를 이용하면 된다(call by value, call by reference)
	/*void*/ int methodA(int i, int j) {
		System.out.println(i + ", " + j);
		return i+j;
	}
}
public class DMain {

	public static void main(String[] args) {
		D1 d1 = new D1();
		int i = 1;
		int j = 2;
		int hap = d1.methodA(i, j);
		System.out.println(hap);
	}

}
