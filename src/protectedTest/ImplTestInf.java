package protectedTest;

import chapter09.TestInf;

public class ImplTestInf implements TestInf{

	public ImplTestInf() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void f1() {
		System.out.println("f1");
		
	}

	@Override
	public void f2() {
		System.out.println("f2");
		
	}
	
	public static void main(String[] args){
		TestInf test=new ImplTestInf();
		test.f1();
		test.f2();
	}

}
