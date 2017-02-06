package chapter14;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
interface Essen{}

class Toy{
	Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots,Essen{
	FancyToy(){super(1);}
}
public class Toytest {
	@SuppressWarnings("rawtypes")
	static void printinfo(Class cc){
		System.out.println("Class name: "+cc.getName()+
				" is interface? ["+cc.isInterface()+"]");
		System.out.println("Simple name: "+cc.getSimpleName());
		System.out.println("Canonical name : "+cc.getCanonicalName());
	}
	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
	
		Class c=null;
		try{
			c=Class.forName("chapter14.FancyToy");
			
		}catch(ClassNotFoundException e){
			System.out.println("can't find fancytoy");
			System.exit(1);
		}
		printinfo(c);
		for(Class face : c.getInterfaces()){
			printinfo(face);
			Class up=c.getSuperclass();
			Object ob=null;
			try{
				ob=up.newInstance();
				
			}catch(InstantiationException e){
				System.out.println("cannot instantiate");
				System.exit(1);
			}catch(IllegalAccessException e){
			    System.out.println("cannot access");
			    System.exit(1);
			}
			printinfo(ob.getClass());
		}
	}

}
