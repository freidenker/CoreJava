package chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountedString3{
	private static List<String> created=new ArrayList<String>();
	private String s;
	private int id=0;
	public CountedString3(String str){
		s=str;
		created.add(s);
		for(String s2:created)
			if(s2.equals(s))
				id++;
	}
	public String toString(){
		return "String: "+s+" id: "+id+" hashCode(): "+hashCode();
	}
	
	public int hashCode(){
		int result = 17;
		result = 37 * result + s.hashCode();
		// result = 37 * result + id;
		return result;
	}
	public boolean equals(Object o){
		return o instanceof CountedString3 &&
				s.equals(((CountedString3)o).s) &&
				id == ((CountedString3)o).id;
	}
}
public class E27_CountedString3 {

	public static void main(String[] args) {
		Map<CountedString3,Integer> map =
				new HashMap<CountedString3,Integer>();
		CountedString3[] cs = new CountedString3[5];
		for(int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString3("hi");
			map.put(cs[i], i); // Autobox int -> Integer
		}
		for(CountedString3 cstring : cs) {
			System.out.println("looking up "+cstring);
			System.out.println(map.get(cstring));
		}
	}

}