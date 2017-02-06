package chapter12;

class MyRuntimeException extends RuntimeException {
	
  public MyRuntimeException(String s) {
	  super(s);
  }
}
public class E28_RuntimeExceptionClass {
	public static void main(String args[]) {
	//	throw new MyRuntimeException("MyRuntimeException msg");
		throw new RuntimeException("RuntimeException msg");
	}
}