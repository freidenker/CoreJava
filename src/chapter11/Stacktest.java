package chapter11;

import java.util.LinkedList;

class Stack<T>{
	private LinkedList<T> storage=new LinkedList<T>();
	public void push(T v){storage.addFirst(v);}
	public T peek(){return storage.getFirst();}
	public T pop(){return storage.removeFirst();}
	public boolean empty(){return storage.isEmpty();}
	public String toString(){return storage.toString();}
}
public class Stacktest {

	private final static Stack<Character> stack=new Stack<Character>();
	private static void evaluate(String expr){
		char data[]=expr.toCharArray();
		for(int i=0;i<data.length;){
			switch(data[i++]){
			case '+' : stack.push(data[i++]);
			           break;
			case '-' : System.out.print(stack.pop());
			}
		}
	}
	
	public Stacktest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		Stack<String> stack=new Stack<String>();
		for(String s:"my dog has fleas".split(" ")){
			stack.push(s);
		}
		while(!stack.empty()){
			System.out.print(stack.pop()+" ");
		}
		
		System.out.println("/n###################");
		evaluate("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");
	}
}
