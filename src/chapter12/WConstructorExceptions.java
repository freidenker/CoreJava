package chapter12;

class Except1 extends Exception {
  public Except1(String s) { super(s); }
}

class BaseWithException {
  public BaseWithException() throws Except1 {
    throw new Except1("thrown by BaseWithException");
  }
}

class DerivedWE extends BaseWithException{

	public DerivedWE() throws Except1 {
		throw new Except1("thrown by DerivedWE");
	}
	
}
public class WConstructorExceptions {

	
	public static void main(String[] args){
		try{
			new DerivedWE();
			
		}catch(Except1 e){
			System.out.println("Caught " + e);
		}
	}
}
