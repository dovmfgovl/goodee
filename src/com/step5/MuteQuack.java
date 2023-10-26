package com.step5;

public class MuteQuack implements QuakBehavior {

	@Override
	public void quack() {
		System.out.println("<<무음. 조용~~~>>");
	}

}
