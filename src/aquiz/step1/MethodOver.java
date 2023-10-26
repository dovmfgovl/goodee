package aquiz.step1;

public class MethodOver {
	public void setVar(int a, int b, float c) {}
	//private void setVar(int a, float c, int b) {} //접근제한자는 메소드 오버로딩에 영향 없다. O
	//protected void setVar(int a, int b, float c) {} //Duplicate X
	public int setVar(int a, float c, int b) { return a; } // O
	public int setVar(int a, int b, float c) { return a; } //리턴타입이 있고 없고는 메소드 오버로딩에 영향 없다. X
}
