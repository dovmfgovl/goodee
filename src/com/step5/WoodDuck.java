package com.step5;

public class WoodDuck extends Duck {
	WoodDuck(){
		flyBehavior = new FlyNoWay();
		quakBehavior = new MuteQuack();
	}
	@Override
	public void display() {
		
	}

}
