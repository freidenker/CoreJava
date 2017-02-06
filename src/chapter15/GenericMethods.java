package chapter15;

public class GenericMethods {

	public GenericMethods() {
		// TODO Auto-generated constructor stub
	}
//	public <T> void f(T x){
//	public <T,P,K> void f(T x,P p,K k){
		public <T,P,K> void f(T x,P p,String k){
		System.out.println(x.getClass().getName()+" "+p.getClass().getName()+" "+k.getClass().getName());
	}
	
	public static void main(String[] args) {
		GenericMethods gMethods=new GenericMethods();
		gMethods.f("","","");
		gMethods.f(1,2,"yes");
	//	gMethods.f(1.0);
	//	gMethods.f(1.0F);
	//	gMethods.f('c');
	//	gMethods.f(gMethods);
	}

}
