package chapter09;


interface Cycle{
	int wheels();
}

interface CycleFact{
	Cycle getCycle();
}
class Unicycle implements Cycle{
	public int wheels(){
		return 1;
	}
}

class UnicycleFact implements CycleFact{

	@Override
	public Cycle getCycle() {		
	  return new Unicycle();
	}	
}

class Bicycle implements Cycle{

	@Override
	public int wheels() {		
		return 2;
	}	
}

class BicycleFact implements CycleFact{

	@Override
	public Cycle getCycle() {
		return new Bicycle();
	}	
}


public class CycleFactories {
	 static void ride(CycleFact fact){
		Cycle c=fact.getCycle();
		System.out.println("Num. of wheels: " + c.wheels());
	}
	
	public static void main(String[] args){
		ride(new UnicycleFact());
		ride(new BicycleFact());
	}

}
