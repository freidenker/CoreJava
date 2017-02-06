package chapter03;


class Tank{
	float level;
}

public class Assignment {
 public static void main(String args[]){
	 Tank t1=new Tank();
	 Tank t2=new Tank();
	 t1.level =9.9F;
	 t2.level =47.8F;
	 
	 System.out.println("one: t1 level: "+t1.level+"  t2 level: "+t2.level );
	 
	 t1=t2;
	 System.out.println("two: t1 level: "+t1.level+"  t2 level: "+t2.level );
	 t1.level=56.0F;
	 System.out.println("three: t1 level: "+t1.level+"  t2 level: "+t2.level );
 }
}
