package chapter09;

import chapter07.Creature;

class Animal extends Creature{
	void hunt(){
		System.out.println("hunt");
	}
}

class Human extends Animal{
	void think(){
		System.out.println("thinking");
	}
}

public class TestMuExtends {

	public TestMuExtends() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
	Human man=new Human();
	 man.move();
	
	}

}
