package chapter07;


class Component1{
	Component1(){
		System.out.println("Com-1");
	}
}

class Component2{
	Component2(){
		System.out.println("Com-2");
	}
}

class Component3{
	Component3(){
		System.out.println("Com-3");
	}
}

 class Root1 {

	Component1 c1 = new Component1();
	Component2 c2 = new Component2();
	Component3 c3 = new Component3();
	public Root1() { System.out.println("Root"); }

}

class Stem extends Root1 {
Component1 c1 = new Component1();
Component2 c2 = new Component2();
Component3 c3 = new Component3();
public Stem() { System.out.println("Stem"); }
}

public class Root {
public static void main(String args[]) {
new Stem();
}
}


