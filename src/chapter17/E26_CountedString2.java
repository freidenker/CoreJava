package chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountedString2{
	private static List<String> created=new ArrayList<String>();
	private String s;
	private char c;
	private int id;
	public CountedString2(String str,char ci){
		s=str;
		c=ci;
		created.add(s);
		for(String s2:created)
			if(s2.equals(s))
				id++;
	}
	public String toString(){
		return "String: " + s + " id: " + id + " char: " + c +
				" hashCode(): " + hashCode();
	}
	public int hashCode(){
		int result=17;
		result=37*result+s.hashCode();
		result = 37 * result + id;
		result = 37 * result + c;
		return result;
	}
	public boolean equals(Object o){
		return o instanceof CountedString2 &&
				s.equals(((CountedString2)o).s) && 
				id == ((CountedString2)o).id &&
				c == ((CountedString2)o).c ;
	}
}
public class E26_CountedString2 {

	public static void main(String[] args) {
		Map<CountedString2, Integer> map=new HashMap<CountedString2,Integer>();
		CountedString2[] cString2s=new CountedString2[5];
		for(int i=0;i<cString2s.length;i++){
			cString2s[i]=new CountedString2("hi", 'c');
			map.put(cString2s[i], i);
		}
		System.out.println(map);
		for(CountedString2 csString:cString2s){
			System.out.println("looking up "+csString);
			System.out.println(map.get(csString));
		}
		
	}

}
