package protectedTest;

public class Hello implements HelloIn{

	String name="winter";
	public Hello() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hello(String myname) {
		// TODO Auto-generated method stub
		
		System.out.println(myname);
	}
	
	public static void main(String[] args){
		Hello her=new Hello();
		her.hello("sommer");
	}

}
