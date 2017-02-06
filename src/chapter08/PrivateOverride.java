package chapter08;

public abstract class PrivateOverride {

private void f(){System.out.println("private f()");}
public void abf(){};

public static void main(String[] args){
	PrivateOverride po=new Derived();
	((Derived)po).f2();
	((Derived)po).abf();
	
//	PrivateOverride po2=new PrivateOverride();
}

}

class Derived extends PrivateOverride{
	public void f(){System.out.println("public f()");}
	public void f2(){System.out.println("private f2()");}
	@Override
	public void abf() {
		// TODO Auto-generated method stub
		System.out.println("abf abf()");
	}
}
