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
		
		int max=Integer.parseInt("1.01.95".replaceAll("\\.", ""));
		int config=Integer.parseInt("1.1.98".replaceAll("\\.", ""));
		
		if(config>max){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}


} 
