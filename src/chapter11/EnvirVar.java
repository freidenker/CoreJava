package chapter11;

import java.util.Map;

public class EnvirVar {

	public EnvirVar() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		for(@SuppressWarnings("rawtypes") Map.Entry entry: System.getenv().entrySet()){
			System.out.println(entry.getKey()+": "+ entry.getValue());
		}
	}
}
