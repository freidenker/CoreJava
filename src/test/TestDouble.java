package test;

import java.text.DecimalFormat;

public class TestDouble {

	public TestDouble() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		double d = 3.76628729;
		double e = 4.646666;

		DecimalFormat newFormat = new DecimalFormat("#.#");
		double twoDecimal =  Double.valueOf(newFormat.format(d));
		double newe =  Double.valueOf(newFormat.format(e));
		System.out.println(twoDecimal + " " + newe);
	}


} 
