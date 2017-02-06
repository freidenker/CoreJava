package chapter17;

import java.util.LinkedList;
import java.util.Stack;

enum Month{ JANUARY, FEBRUARY, MARCH, APRAIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER }
public class Stacks {

	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		for(Month m:Month.values())
			stack.push(m.toString());
		System.out.println("stack = "+stack);
		stack.addElement("the last line");
		System.out.println("element 5 = "+stack.elementAt(5));
		System.out.println("popping element:");
		while(!stack.empty())
			System.out.print(stack.pop()+" ");
		
		LinkedList<String> lstack=new LinkedList<String>();
		for(Month m:Month.values())
			lstack.addFirst(m.toString());
		System.out.println("lstack = "+lstack);
		while(!lstack.isEmpty())
			System.out.print(lstack.removeLast()+" ");
		
		
			
	}

}
