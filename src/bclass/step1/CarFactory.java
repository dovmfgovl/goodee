package bclass.step1;

public class CarFactory {
	public static int serialNum = 1000;
	public static Car getInstance() {
		Car myCar = null;
		if(myCar == null) { //myCar 변수를 null 체크하여 null인 경우에만  인스턴스화함
			myCar = new Car();
		}
		return myCar;
	}////////////end of getInstance
}
