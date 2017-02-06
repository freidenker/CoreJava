package chapter09;


abstract class Base{
//	public Base(){ print();}
	public abstract void print();
}

abstract class Base2{
	
}

class Derived extends Base{
	int i=12;
	public void print(){
		System.out.println("i = " + i);
	}
}

class Derived2 extends Base2{
	public static void test(){
		System.out.println("test" );
	}
}

public class Init {

	public static void main(String args[]) {
		Derived de=new Derived();
		de.print();
		
		Base2 test=new Derived2();
		((Derived2)test).test();
		
//		StringBuilder sb = new StringBuilder();
	}

}
