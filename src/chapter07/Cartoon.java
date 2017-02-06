package chapter07;

class Art{
	Art(){System.out.println("Art Const");}
}
class Drawing extends Art{
	private String drw="private drw";
	Drawing(){System.out.println("Drawing Const");}
	Drawing(String s){
		s=drw;
		System.out.println(s+ " Drawing Const ");
	}
}

public class Cartoon extends Drawing{
	
	public static void main(String[] args){
		new Cartoon();
		System.out.println("test 01");
	}

//	public Cartoon() {
//		System.out.println("Cartoon Const");
//	}

}
