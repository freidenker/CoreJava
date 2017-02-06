package chapter07;


class A{
	A(int a){System.out.println("A"+a);}
}
public class Eight extends A {
	
	public Eight () {
		super(10);
		System.out.println("default const");
	}
	public Eight (int e) {
		super(11);
		System.out.println("not default const");
	}
	
	public static void main(String[] args){
		new Eight(20);
	}
}
