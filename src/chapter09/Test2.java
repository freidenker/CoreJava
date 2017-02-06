package chapter09;


interface Eat{
	void eat();
}
interface Sleep{
	void sleep();
}	

interface Live extends Eat, Sleep{
	void live();
}

public class Test2 implements Live{
	public Test2(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void live() {
		System.out.println("stayin' alive");
		
	}
	public void sex(){
		System.out.println("have sexes");
	}
	
	public static void main(String[] args){
		Test2 t=new Test2();
		t.live();
		Live l=new Test2();
		l.live();
		l.eat();
	}

}
