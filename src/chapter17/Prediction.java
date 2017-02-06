package chapter17;

import java.util.Random;

public class Prediction {
	private static Random rand=new Random(23);
	private boolean shadow=rand.nextDouble()>0.5;
	public String toString() {
		if(shadow){return "six more weeks of winter!";}
		else
			return "early Spring";
	}


}
