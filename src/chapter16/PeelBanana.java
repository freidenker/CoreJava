package chapter16;

import java.util.ArrayList;

class Banana{
	private final int id;
	Banana(int id){
		this.id=id;
	}
	public String toString(){
		return getClass().getSimpleName()+" "+id;
	}
}

class Peel<T>{
	T fruit;
	Peel(T fruit){this.fruit=fruit;}
	void peel(){System.out.println("Peeling "+fruit);}
}

public class PeelBanana {
	public static void main(String[] args) {
		// Peel<Banana>[] a = new Peel<Banana>[10];
		ArrayList<Peel<Banana>> ar=new ArrayList<Peel<Banana>>();
		for(int i=0;i<10;i++){
			ar.add(new Peel<Banana>(new Banana(i)));
			
		}
		for(Peel<Banana> p:ar){
			p.peel();
		}
		
		
		
		
		
	}
	

}
