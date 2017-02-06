package chapter10;
import chapter09.Hello;

public interface ClassInInterface {

	void howdy();
	class Test implements ClassInInterface{

		@Override
		public void howdy() {
			System.out.println("hallo Deutschland");
			
		}
		
		public static void main(String[] args){
			new Test().howdy();
			
			Hello he=new Hello();
			he.hello();
		}
		
	}
}
