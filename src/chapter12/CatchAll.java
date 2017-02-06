package chapter12;

class ExBase extends Exception{}
class Ex1 extends ExBase{}
class Ex2 extends ExBase {}
class Ex3 extends ExBase {}

class Thrower2{
	void f() throws ExBase,Ex1,Ex2,Ex3{
	//	throw new Ex1();
		throw new Ex2();
	//	throw new ExBase();
	}
}

public class CatchAll {

	public CatchAll() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		Thrower2 t=new Thrower2();
		try{
			t.f();
		}catch(ExBase e){
			System.out.println("caught"+e);
			System.out.println(e.getStackTrace());
		}catch(Exception e){
			System.out.println("caught"+e);
		}
	}
}
