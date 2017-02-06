package chapter12;

import java.io.IOException;

public class NeverCaught {

	public NeverCaught() {
		// TODO Auto-generated constructor stub
	}
	static void f() throws IOException{
		throw new IOException("from f()");
	}
	static void g() throws IOException{
	//	System.out.println(this);
		f();
	}
	public void h(){
		System.out.println(this);
	}
	public static void main(String[] args) throws IOException{
		new NeverCaught().h();
		g();
	}
}
