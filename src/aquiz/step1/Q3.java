package aquiz.step1;

class BaseClass {
	private float x = 1.0f;

	protected float getVar() {
		return x;
	}
}

class SubClass extends BaseClass {
	private float x = 2.0f;
	///*float*/ public float getVar() { return x; } //private < friendly < protected < public - 접근제한자가 같거나 범위 더 넓은 건 메소드 오버 라이드에 상관없다! //O
	protected float getVar() { return x; } //O
//	public double getVar() { return x; } //X
//	public float getVar(float f) { return f; } //X
//	float getVar() { return x; } //X
}
public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
