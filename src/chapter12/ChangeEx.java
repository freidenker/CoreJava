package chapter12;

class AnException extends Exception{}
class AnotherException extends Exception{}

public class ChangeEx {

  public void g() throws AnException{
	  throw new AnException();
  }
  public void f(){
	  try{
		  g();
	  }catch(AnException e){
		  throw new RuntimeException(e);
	  }
  }
  
  public static void main(String[] args){
	  ChangeEx ce=new ChangeEx();
/*	  try{
		  ce.f();
	  }catch(AnotherException e){
		  System.out.println("caught: "+e);
	  }*/
	  ce.f();
  }

}
