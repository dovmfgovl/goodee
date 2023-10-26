package bclass.step1;

public class Car {
	private int carNum;
	public Car() { //디폴트 생성자 - 리턴타입, 파라미터 없음. 구현 없음. 생략가능. 생략했을 경우 컴파일 될 때 JVM이 주입해 줌
		CarFactory.serialNum++;
		carNum = CarFactory.serialNum;
	}
	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
}
