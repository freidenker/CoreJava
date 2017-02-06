package test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public TestList() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	public static void main(String[] args){
		List<String> testlist=new ArrayList<String>();
		if(testlist == null){
			System.out.println("is null");
		}else{
			System.out.println("not null");
		}
		for(String at : testlist){
			System.out.println(at);
		}
	}
}
