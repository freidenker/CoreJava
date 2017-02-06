package chapter07;


class Amp{
	protected void creep(){
		System.out.println("some amps creep");
	}
	protected static void look(Amp am){
		am.creep();
	}
}
public class Frog extends Amp{

	public static void main(String[] args){
		Frog fg=new Frog();
		Amp.look(fg);
	
		Amp am=new Frog();
		am.creep();
		

	}

}
