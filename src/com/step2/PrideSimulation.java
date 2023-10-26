package com.step2;

class Sonata{
	private int speed;
	private String carColor;
	private int wheelNumber;
	//getter 메소드는 전역변수에 담긴 값을 꺼낼 때 사용
	public int getSpeed() {
		return speed;
	}
	//setter 메소드는 전역변수가 private이라서 직접 접근이 불가하니까
	//메소드의 파라미터 자리를 활용하여 결정된(사용자나 업무담당자가) 값을 전역변수에 초기화해줌(this 붙은 것들)
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getWheelNumber() {
		return wheelNumber;
	}
	public void setWheelNumber(int wheelNumber) {
		this.wheelNumber = wheelNumber;
	}
}
public class PrideSimulation {
	
	public static void main(String[] args) {
		Sonata myCar = new Sonata(); //30km
		//myCar.speed = 30;
		myCar.setSpeed(30);
		Sonata herCar = new Sonata(); //50km
		//herCar.speed = 50;
		herCar.setSpeed(50);
		Sonata yourCar = new Sonata(); //100km
		//yourCar.speed = 100;
		yourCar.setSpeed(100);
		
		System.out.println(myCar.getSpeed());
		System.out.println(herCar.getSpeed());
		System.out.println(yourCar.getSpeed());
	}

}
