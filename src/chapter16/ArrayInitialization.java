package chapter16;

public class ArrayInitialization {

  static void hide(BerylliumSphere[] s){
	  System.out.println("Hiding "+s.length+" spheres(s)");
  } 
  
  public static void main(String[] args) {
	hide(new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()});
	BerylliumSphere[] d={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
	hide(d);
	BerylliumSphere[] a=new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};
	hide(a);
}

}
