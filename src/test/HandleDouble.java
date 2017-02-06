package test;

import java.math.BigDecimal;

public class HandleDouble {

	public HandleDouble() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		double dout=3;   
		BigDecimal bd= new BigDecimal(dout);   
		bd=bd.setScale(1, BigDecimal.ROUND_HALF_UP);// 
		double result=bd.doubleValue();
		System.out.println(result);  
	}

}
