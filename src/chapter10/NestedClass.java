package chapter10;

public class NestedClass {

	public NestedClass() {
		// TODO Auto-generated constructor stub
	}

	public static class Nested{
		public Nested(){
			System.out.println("I am nested inner class");
		}
		
		public static class NextNested{
			public NextNested(){
				System.out.println("I am next nested inner class");
			}
		}
	}
	
	public static void main(String[] args){
		Nested ne=new Nested();
	}
}

