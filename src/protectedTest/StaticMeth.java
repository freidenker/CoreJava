package protectedTest;

public class StaticMeth {

public static void me(String name){
	System.out.println(name);
}

public static void th(String name){
	me("winter");
}

public static void main(String[] args){
	th("hello");
}
}
